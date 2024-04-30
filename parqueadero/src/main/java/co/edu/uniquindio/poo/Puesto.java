package co.edu.uniquindio.poo;

public class Puesto {
    private final String disponibilidad;

    public Puesto(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    @Override
    public String toString() {
        return "Puesto [disponibilidad=" + disponibilidad + "]";
    }



}
