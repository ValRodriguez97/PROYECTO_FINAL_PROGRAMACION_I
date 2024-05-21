package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Parqueadero {
    private final String nombre;
    private Collection<Vehiculo> vehiculos;
    private Puesto[][] puestos;
    private int filas; 
    private int columnas;
    
    public Parqueadero(String nombre, int filas, int columnas) {
        this.nombre = nombre;
        this.vehiculos = new LinkedList<>();
        this.puestos = new Puesto[filas][columnas]; 
        
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


    public void añadirPuesto (Puesto puesto, Posicion posicion){
        if (posicion.getI() >= 0 && posicion.getI() < puestos.length && posicion.getJ() >= 0 && posicion.getJ() < puestos.length){
            puestos[posicion.getI()][posicion.getJ()] = puesto;
        }
        
    }

    public void disponibilidadPuesto() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                puestos[i][j] = new Puesto("Disponible", new Posicion(i, j));
            }
        }
    }

     public void añadirVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
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

