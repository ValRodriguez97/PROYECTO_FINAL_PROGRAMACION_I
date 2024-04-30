package co.edu.uniquindio.poo;

public class Parqueadero {
    private final String nombre;

    public Parqueadero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Parqueadero [nombre=" + nombre + "]";
    }

    

}
