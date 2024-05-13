package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Parqueadero {
    private final String nombre;
    private Collection<Vehiculo> vehiculos;
    private Collection<Puesto> puestos;
    
    public Parqueadero(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new LinkedList<>();
        this.puestos = new LinkedList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public Collection<Puesto> getPuestos() {
        return puestos;
    }

    @Override
    public String toString() {
        return "Parqueadero [nombre=" + nombre + ", vehiculos=" + vehiculos + ", puestos=" + puestos + "]";
    }
    

}
