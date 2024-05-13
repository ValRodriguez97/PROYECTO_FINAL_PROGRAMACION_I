package co.edu.uniquindio.poo;

public class Puesto {
    private final String disponibilidad;
    private Posicion posicion;

    public Puesto(String disponibilidad, Posicion posicion) {
        this.disponibilidad = disponibilidad;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public Posicion getPosicion() {
        return posicion;
    } 

    @Override
    public String toString() {
        return "Puesto [disponibilidad=" + disponibilidad + ", posicion=" + posicion + "]";
    }



}
