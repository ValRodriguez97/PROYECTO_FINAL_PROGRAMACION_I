package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Parqueadero {
    private final String nombre;
    private int filas; 
    private int columnas;
    private Tarifa tarifa;
    private Collection<Vehiculo> vehiculos;
    private Puesto[][] puestos;
    private Collection<Registro> registros;
    
    /*
     * Método Constructor de la clase Parqueadero
     * 
     * @param nombre del parqueadero
     * @param filas del parqueadero
     * @param columnas del parquedero
     * @param tarifa por tipo de vehiculo del parqueadero
     */
    public Parqueadero(String nombre, int filas, int columnas, Tarifa tarifa) {
        assert filas > 0 && columnas > 0;
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.vehiculos = new LinkedList<>();
        this.puestos = new Puesto[filas][columnas];
        this.registros = new LinkedList<>(); 
       
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                puestos[i][j] = new Puesto(i, j);
            }
        }
    }
   
    /*
     * Método para obtener el nombre del parqueadero
     * 
     * @return nombre del parqueadero
     */
    public String getNombre() {
        return nombre;
    }

    /*
     * Método para obtener el número de filas del parqueadero
     * 
     * @return filas
     */
    public int getFilas() {
        return filas;
    }

    /*
     * Método para establecer el numero de filas 
     */
    public void setFilas(int filas) {
        this.filas = filas;
    }

    /*
     * Método para obtener el número de columnas del parqueadero
     */
    public int getColumnas() {
        return columnas;
    }
    
    /*
     * Método para establecer el número de columnas 
     */
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    /*
     * Método para obtener la tarifa por tipo de vehiculo de parqueadero
     * 
     * @return tarifa vehiculo
     */
    public Tarifa getTarifa (){
        return tarifa;
    }

    /*
     * Método para obtener la lista de vehiculos del parqueadero
     * 
     * @return lista vehiculos
     */
    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /*
     * Método para obtener los puestos del parqueadero
     * 
     * @return puestos 
     */
    public Puesto[][] getPuestos(){
        return puestos;
    }

    /*
     * Método para obtener la lista de registros del parqueadero
     * 
     * @return registros
     */
    public Collection<Registro> getRegistros (){
        return registros;
    }
    
    /*
     * @return cadena de texto que representa el objeto Parquadero
     */
    @Override
    public String toString() {
        return "Parqueadero [nombre=" + nombre + ", vehiculos=" + vehiculos + ", puestos=" + puestos + "]";
    }

    /*
     * Método para verificar la disponibilidad de un puesto en el parqueadero
     * 
     * @return disponibilidad 
     */
    public boolean disponibilidad (int i, int j){
        return !puestos[i][j].noDisponible();
    }

    /*
     * Método para ubicar un vehiculo en un determinado puesto
     */
    public void ubicarVehiculo(int i, int j, Vehiculo vehiculo){
        if (disponibilidad(i, j)){
            puestos[i][j].ocuparPuesto(vehiculo);
            registros.add(new Registro(puestos[i][j], vehiculo));
            System.out.println(registros);
        } 
    }
   
     /**
     * Método para generar un reporte del dinero que se recauda diariamente por vehiculo en el parqueadero
     */
    public Collection<Double> generarReporteDiario (LocalDate fecha){
        double dineroRecaudadoCarro = 0.0;
        double dineroRecaudadoMotoHibrida = 0.0;
        double dineroRecaudadoMotoClasica = 0.0;

        for (Registro registro : registros) {
            if (registro.getIngreso().toLocalDate().isEqual(fecha) && registro.getSalida() != null) {
                Vehiculo vehiculo = registro.getRegistroVehiculo();
                double tarifa = registro.calcularTarifa();
        
                if (vehiculo instanceof Carro) {
                    dineroRecaudadoCarro += tarifa;
                } else if (vehiculo instanceof Moto) {
                    Moto moto = (Moto) vehiculo;
                    if (moto.getTipoMoto() == TipoMoto.CLASICA) {
                        dineroRecaudadoMotoClasica += tarifa;
                    } else {
                        dineroRecaudadoMotoHibrida += tarifa;
                    }
                }
            }
        }
        Collection<Double> reporteDiario = new LinkedList<>();
        reporteDiario.add(dineroRecaudadoCarro);
        reporteDiario.add(dineroRecaudadoMotoClasica);
        reporteDiario.add(dineroRecaudadoMotoHibrida);

        return reporteDiario;
    }
    
    /*
     * Método para identificar el propietario de un vehiculi según el puesto
     * 
     */
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

    /*
     * Método para registrar la salida de un vehículo del parqueadero
     */
    public void registrarSalidaVehiculo(Vehiculo vehiculo) {
        for (Registro registro : registros) {
            if (registro.getRegistroVehiculo().equals(vehiculo) && registro.getSalida() == null) {
                registro.salidaVehiculo(LocalDateTime.now());
                Puesto puesto = registro.getRegistroPuesto();
                puesto.desocuparPuesto();
                break;
            }
        }
    }
    
    /**
     * Método para generar un reporte del dinero recaudado mensualmente en el parqueadero.
     * 
     * @return reporte mensual
     */
    public Map<LocalDate, Double> generarReporteMensual(int mes, int año) {
        Map<LocalDate, Double> reporteMensual = new HashMap<>();
        for (Registro registro : registros) {
            LocalDate fechaRegistro = registro.getIngreso().toLocalDate();
            if (fechaRegistro.getMonthValue() == mes && fechaRegistro.getYear() == año && registro.getSalida() != null) {
                double valorEstacionamiento = registro.calcularTarifa();
                reporteMensual.put(fechaRegistro, reporteMensual.getOrDefault(fechaRegistro, 0.0) + valorEstacionamiento);
            }
        }

        return reporteMensual;
    }
}

    /*public double generarReporteDiario(LocalDate fecha) {
        double dineroRecaudado = 0.0;
        for (Registro registro : registros) {
            if (registro.getIngreso().toLocalDate().isEqual(fecha) && registro.getSalida() != null) {
                dineroRecaudado += registro.calcularValorEstacionamiento();
            }
        }
        return dineroRecaudado;
    }
}*/
