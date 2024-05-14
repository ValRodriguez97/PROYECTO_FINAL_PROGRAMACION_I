package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Parqueadero {
    private final String nombre;
    private Collection<Vehiculo> vehiculos;
    private Puesto[][] puestos;
    
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

     public void añadirVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }    

}
