package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Parqueadero {
    private final String nombre;
    private Collection<Vehiculo> vehiculos;
    private Collection<Registro> registros;
    private Puesto[][] puestos;
    private int filas; 
    private int columnas;

    private Tarifa tarifaCarro;
    private Tarifa tarifaMotoClasica;
    private Tarifa tarifaMoroHibrida;
    
    
    public Parqueadero(String nombre, int filas, int columnas, Tarifa tarifaCarro, Tarifa tarifaMotoHibrida, Tarifa tarifaMotoClasica) {
        assert filas > 0 && columnas > 0;
        this.nombre = nombre;
        this.vehiculos = new LinkedList<>();
        this.puestos = new Puesto[filas][columnas];
        this.registros = new LinkedList<>(); 
        this.tarifaCarro = tarifaCarro;
        this.tarifaMoroHibrida = tarifaMotoHibrida;
        this.tarifaMotoClasica = tarifaMotoClasica;
        
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                puestos[i][j] = new Puesto(i, j);
            }
        }
    }
    public Tarifa getTarifaCarro(){
        return tarifaCarro;
    }
    public Tarifa getTarifaMotoHibrida(){
        return tarifaMoroHibrida;
    }
    public Tarifa getTarifaMotoClasica(){
        return tarifaMotoClasica;
    }

    public String getNombre() {
        return nombre;
    }
    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Puesto[][] getPuestos(){
        return puestos;
    }

    public int getColumnas() {
        return columnas;
    }
    
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    @Override
    public String toString() {
        return "Parqueadero [nombre=" + nombre + ", vehiculos=" + vehiculos + ", puestos=" + puestos + "]";
    }

    public boolean disponibilidad (int i, int j){
        return !puestos[i][j].noDisponible();
    }
    public void ubicarVehiculo(int i, int j, Vehiculo vehiculo){
        if (disponibilidad(i, j)){
            puestos[i][j].ocuparPuesto(vehiculo);
            registros.add(new Registro(puestos[i][j], vehiculo));
        } 
    }

    public Propietario buscPropietario(int i, int j){
        if (puestos[i][j].noDisponible()){
            return puestos[i][j].getVehiculo().getPropietario();
        }
        return null;
    }
   
    public void calcularValorEstacionamiento (Vehiculo vehiculo){
        double valor = 0;

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

    public double generarReporteDiario(LocalDate fecha) {
        double dineroRecaudado = 0.0;
        for (Registro registro : registros) {
            if (registro.getIngreso().toLocalDate().isEqual(fecha) && registro.getSalida() != null) {
                dineroRecaudado += registro.calcularValorEstacionamiento();
            }
        }

        return dineroRecaudado;
    }

    /**
     * Método para generar un reporte del dinero recaudado mensualmente en el parqueadero.
     */
    public Map<LocalDate, Double> generarReporteMensual(int mes, int año) {
        Map<LocalDate, Double> reporteMensual = new HashMap<>();
        for (Registro registro : registros) {
            LocalDate fechaRegistro = registro.getIngreso().toLocalDate();
            if (fechaRegistro.getMonthValue() == mes && fechaRegistro.getYear() == año && registro.getSalida() != null) {
                double valorEstacionamiento = registro.calcularValorEstacionamiento();
                reporteMensual.put(fechaRegistro, reporteMensual.getOrDefault(fechaRegistro, 0.0) + valorEstacionamiento);
            }
        }

        return reporteMensual;
    }
    /*public void buscarPropietario (Puesto puesto, int filas, int columnas, String propietario){
        for (int i = 0; i < puestos.length; i++ ){
            for (int j = 0; j < puestos.length; j++){
                Puesto ubicacionPuesto = puestos[i][j];
                Puesto registro = registro.getRegistroPuesto();
            }
        }
    }*/

}

//Programación basada en eventos, respuesta a un evento, reaccionar a un evento. Permite una capacidad de respuesta nehirada, un manejo sencillo de flujo de datos
//estabilidad, 
//Fundamentos de la recursividad ->capacidad de llamarse a si mimsa varias veces, varias funciones, descomponer un problema. Caso base -> principio de la funcion, finalidad de la función
//Caso recursivo -> la funcion se llama varias veces hasta que encuentra la solución, permite una claridad en el código, código más legible, facilidad, flexibilidad y adaptabilidad

