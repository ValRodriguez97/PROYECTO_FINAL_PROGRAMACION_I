package co.edu.uniquindio.poo;

public class Propietario {
    private final String nombre;
    private final String identificacion;
    private final String direccion;
    private final String telefono;
    
    public Propietario(String nombre, String identificacion, String direccion, String telefono) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Propietario [nombre=" + nombre + ", identificacion=" + identificacion + ", direccion=" + direccion
                + ", telefono=" + telefono + "]";
    }

}
