package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Parqueadero {
    private String nombre;
    private int filas;
    private int columnas;
    private  Tarifa tarifa;
    private Puesto[][] puestos;
    private Collection<Registro> registros;

    public Parqueadero(String nombre, int filas, int columnas, Tarifa tarifa){
        assert filas > 0 && columnas > 0;
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.puestos = new Puesto[filas][columnas];
        this.registros = new LinkedList<>();

        for (int i = 0; i < filas; i++){
            for (int j =0; j < columnas; j++){
                puestos[i][j] = new Puesto(i, j);
            }
        }
    }

    public String getNombre(){
        return nombre;
    }

    public int getFilas (){
        return filas;
    }

    public int getColumnas (){
        return columnas;
    }

    public Tarifa getTarifa (){
        return tarifa;
    }

    public Puesto[][] getPuestos(){
        return puestos;
    }

    public Collection<Registro> getRegistros (){
        return registros;
    }

    public void setNombre (String nombre){
        this.nombre = nombre;
    }

    public void setFilas (int filas){
        this.filas = filas;
    }

    public void setColumnas (int columnas){
        this.columnas = columnas;
    }

    public void setTarifa (Tarifa tarifa){
        this.tarifa = tarifa;
    }

    public void setPuestos(Puesto[][] puestos) {
        this.puestos = puestos;
    }

    public void setRegistros(Collection<Registro> registros) {
        this.registros = registros;
    }

    public boolean disponibilidad (int i, int j){
        return !puestos[i][j].noDisponible();
    }

    public boolean ubicarVehiculo (int i, int j, Vehiculo vehiculo){
        if (disponibilidad(i, j)){
            puestos[i][j].ocuparPuesto(vehiculo);
            registros.add(new Registro(puestos[i][j], vehiculo));
            return true;
        } else if(puestos[i][j].getVehiculo() != null && puestos[i][j].getVehiculo().getPlaca().equals(vehiculo.getPlaca())){
            return false;
        }
        return false;
    }

    public Propietario identificarPropietario(int i, int j) {
        if (i < 0 || i >= filas || j < 0 || j >= columnas) {
            throw new IllegalArgumentException("El parqueadero no cuenta con ese numero de puestos");
        }
    
        Puesto puesto = puestos[i][j];
        if (puesto.noDisponible()) {
            return puesto.getVehiculo().getPropietario();
        } else {
            return null; 
        }
    }

    public double calcularTarifa(Registro registro){
        LocalDateTime ingreso = registro.getIngreso();
        LocalDateTime salida = registro.getSalida();
        long horasEstacionadas = Duration.between(ingreso, salida).toHours();
        double tarifaHora = 0;

        if (registro.getRegistroVehiculo() instanceof Carro){
            tarifaHora = tarifa.getTarifaCarro();
        } else if (registro.getRegistroVehiculo() instanceof Moto) {
            Moto moto = (Moto) registro.getRegistroVehiculo();
            if (moto.getTipoMoto() == TipoMoto.CLASICA){
                tarifaHora = tarifa.getTarifaMotoClasica();
            } else {
                tarifaHora = tarifa.getTarifaMotoHibrida();
            }
        }
        double costoTotal = (horasEstacionadas) *tarifaHora;
        return costoTotal;
    }

        public void generarReporteDiario (){

        double dineroRecaudadoCarro = 0.0;
        double dineroRecaudadoMotoHibrida = 0.0;
        double dineroRecaudadoMotoClasica = 0.0;
        LocalDateTime fechaActual = LocalDateTime.now();

        for (Registro registro : registros) {
            LocalDateTime fechaIngreso = registro.getIngreso();
            if (fechaIngreso.toLocalDate().isEqual(fechaActual.toLocalDate()) && registro.getSalida() != null) {
                if (registro.getRegistroVehiculo() instanceof Carro){
                    dineroRecaudadoCarro += calcularTarifa(registro);
                } else if (registro.getRegistroVehiculo() instanceof Moto){
                    Moto moto = (Moto) registro.getRegistroVehiculo();
                    if (moto.getTipoMoto() == TipoMoto.CLASICA){
                        dineroRecaudadoMotoClasica += calcularTarifa(registro);
                    } else {
                        dineroRecaudadoMotoHibrida += calcularTarifa(registro);
                    }
                }
            
            }
        }
        double totalDineroRecaudado = dineroRecaudadoCarro + dineroRecaudadoMotoClasica +dineroRecaudadoMotoHibrida;
        System.out.println("Reporte de recaudo diario del parqueadero:");
        System.out.println("Carros: " + dineroRecaudadoCarro);
        System.out.println("Motos Clásicas: " + dineroRecaudadoMotoClasica);
        System.out.println("Motos Híbridas: " + dineroRecaudadoMotoHibrida);
        System.out.println("Total: " + totalDineroRecaudado);
    }

    public Map<LocalDate, Double> generarReporteMensual(int mes, int año) {
        Map<LocalDate, Double> reporteMensual = new HashMap<>();
        for (Registro registro : registros) {
            LocalDate fechaRegistro = registro.getIngreso().toLocalDate();
            if (fechaRegistro.getMonthValue() == mes && fechaRegistro.getYear() == año && registro.getSalida() != null) {
                double valorEstacionamiento = calcularTarifa(registro);
                reporteMensual.merge(fechaRegistro,valorEstacionamiento, Double :: sum);
               // reporteMensual.put(fechaRegistro, reporteMensual.getOrDefault(fechaRegistro, 0.0) + valorEstacionamiento);
            }
        }
        return reporteMensual;
    }

   
}
