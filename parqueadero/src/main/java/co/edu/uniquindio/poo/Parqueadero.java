package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

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

