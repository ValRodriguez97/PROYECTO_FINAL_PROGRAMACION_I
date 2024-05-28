package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Parqueadero {
    private String nombre;
    private int filas;
    private int columnas;
    private  Tarifa tarifa;
    private Puesto[][] puestos;
    private Collection<Registro> registros;

    /**
     * Método Constructor de la clase Propietario
     * 
     * @param nombre del parqueadero
     * @param filas del parqueadero
     * @param columnas del parqueadero
     * @param teléfono del propietario
     * @param matriz de puestos del parqueadero
     * @param registro del parqueadero
     * 
     */
    public Parqueadero(String nombre, int filas, int columnas, Tarifa tarifa){
        assert filas > 0 && columnas > 0: "El número de filas y columnas debe ser mayor que cero";
        assert nombre != null && !nombre.isBlank() : "¡Error! El nombre del parqueadero no puede ser nulo y no puede estar en blanco";
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.puestos = new Puesto[filas][columnas];
        this.registros = new ArrayList<>();

        for (int i = 0; i < filas; i++){
            for (int j =0; j < columnas; j++){
                puestos[i][j] = new Puesto(i, j);
            }
        }
    }
   
    /**
     * Método para obtener el nombre del parqueadero
     * 
     * @return nombre
     */
    public String getNombre(){
        return nombre;
    }
   
    /** 
     * Método para obtener las filas del parqueadero
     * 
     * @return filas
     */
    public int getFilas (){
        return filas;
    }

    /**
     * Método para obtener el número de columnas del parqueadero.
     * 
     * @return columnas
     */
    public int getColumnas (){
        return columnas;
    }

    /**
     * Método para obtener la tarifa del parqueadero
     * 
     * @return tarifa
     */
    public Tarifa getTarifa (){
        return tarifa;
    }

    /**
     * Método para obtener el númerro de puestos
     * 
     * @return puestos
     */
    public Puesto[][] getPuestos(){
        return puestos;
    }  
   
    /**
     * Método para establecer el nombre del parqueadero
     * 
     * @param nombre
     */
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
   
    /**
     * Método para establecer las filas del parqueadero
     * 
     * @param filas
     */
    public void setFilas (int filas){
        this.filas = filas;
    }

    /**
     * Método para establecer las columnas del parqueadero
     * 
     * @param columnas
     */
    public void setColumnas (int columnas){
        this.columnas = columnas;
    }

    /**
     * Método para establecer la tarifa del parqueadero
     * 
     * @param tarifa
     */
    public void setTarifa (Tarifa tarifa){
        this.tarifa = tarifa;
    }

    /**
     * Método para  establecer los puestos del parqueadero
     * 
     * @aram puestos
     */
    public void setPuestos(Puesto[][] puestos) {
        this.puestos = puestos;
    }

    /**
     * Método para establecer el registro del parqueadero
     * 
     * @param registros
     */
    public void setRegistros(Collection<Registro> registros) {
        this.registros = registros;
    }

    /**
     * Método que verifica la disponilidad de un puesto específico en el parqueadero
     */
    public boolean disponibilidad (int i, int j){
        return !puestos[i][j].noDisponible();
    }

    /**
     * Método que ubica a un vehículo en un puesto específico del parqueadero
     */
    public boolean ubicarVehiculo (int i, int j, Vehiculo vehiculo){
        if (disponibilidad(i, j)){
            puestos[i][j].ocuparPuesto(vehiculo);
            registros.add(new Registro(puestos[i][j], vehiculo));
            System.out.println("Vehiculo ubicado exitosamente");
            return true;
        } else if(puestos[i][j].getVehiculo() != null && puestos[i][j].getVehiculo().getPlaca().equals(vehiculo.getPlaca())){
            return false;
        }
        return false;
    }

    /**
     * Método que registra la salida de un vehículo del parqueadero
     */
    public void registrarSalidaVehiculo(Vehiculo vehiculo, LocalDateTime salida) {
        for (Registro registro : registros) {
            if (vehiculo.equals(registro.getRegistroVehiculo()) && registro.getSalida() == null) {
                registro.setSalida(salida);
                Puesto puesto = registro.getRegistroPuesto();
                puesto.desocuparPuesto(vehiculo);
                System.out.println("Vehiculo retirado exitosamente");
                break;
            }
        }
    }

    /**
     * Método que identificar el propietario de un vehículo 
     */
    public Propietario identificarPropietario(int i, int j) {
        Puesto puesto = puestos[i][j];
        if (puesto.noDisponible()) {
            return puesto.getVehiculo().getPropietario();
        } else {
            return null; 
        }
    }

    /**
     * Método para calcular la tarifa a pagar por un vehículo dependiendo del tiempo de estacionamiento
     */
    public double calcularTarifa(Registro registro){
        LocalDateTime ingreso = registro.getIngreso();
        LocalDateTime salida = registro.getSalida();
        long minutosEstacionados = Duration.between(ingreso, salida).toMinutes();
        int tiempoHoras = (int) Math.ceil(minutosEstacionados / 60.0);
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
        double costoTotal = (tiempoHoras) *tarifaHora;
        return costoTotal;
    }

    /**
     * Método para generar el reporte diario del dinero recaudado dependiendo del tipo 
        de vehículo y la cantidad que ingresó al parqueadero
     */
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

    /**
     * Método que genera el reporte mensual del dinero recaudado dependiendo del tipo de vehículo 
        que ingresó, la cantidad de vehículos y en tiempo que estuvieron en el parqueadero
    */
    public Map<LocalDate, Double> generarReporteMensual(int mes, int año) {
        Map<LocalDate, Double> reporteMensual = new HashMap<>();
        double totalMensual = 0.0;
        for (Registro registro : registros) {
            LocalDate fechaRegistro = registro.getIngreso().toLocalDate();
            if (fechaRegistro.getMonthValue() == mes && fechaRegistro.getYear() == año && registro.getSalida() != null) {
                double valorEstacionamiento = calcularTarifa(registro);
                reporteMensual.merge(fechaRegistro,valorEstacionamiento, Double :: sum);
                totalMensual += valorEstacionamiento;
            }
        }
        System.out.println("Reporte Mensual:" + totalMensual);
        
        return reporteMensual;
    }
}
