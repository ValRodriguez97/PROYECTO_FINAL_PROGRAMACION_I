package co.edu.uniquindio.poo;

public class Propietario {
    private final String nombre;
    private final String identificacion;
    private final String direccion;
    private final String telefono;
  
    /*
     * Método Constructor de la clase Propietario
     * 
     * @param nombre del propietario
     * @param identificación del propietario
     * @param dirección del propietario
     * @param teléfono del propietario
     */
    public Propietario(String nombre, String identificacion, String direccion, String telefono) {
        assert nombre != null && !nombre.isBlank():"El nombre no puede ser nulo o vacío";
        assert identificacion != null && !identificacion.isBlank():"La identificación no puede ser nula o vacía";
        assert direccion != null && !direccion.isBlank():"La dirección no puede ser nula o vacía"; 
        assert telefono != null && !telefono.isBlank():"El teléfono no puede ser nulo o vacío";
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /*
     * Método para obtener el nombre del propietario
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /*
     * Método para obtener la identificación del propietario
     * 
     * @return identificación
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /*
     * Método para obtener la dirección del propietario
     * 
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /*
     * Método para obtener el teléfono del propietario
     * 
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /*
     * @return cadena de texto que representa el objeto Propietario
     */
    @Override
    public String toString() {
        return "Propietario [nombre=" + nombre + ", identificacion=" + identificacion + ", direccion=" + direccion
                + ", telefono=" + telefono +"]";
    }
}
