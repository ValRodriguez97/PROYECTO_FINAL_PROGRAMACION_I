package co.edu.uniquindio.poo;

public abstract class Vehiculo {
    private final String placa;
    private final String modelo;
    private Propietario propietario;
    
    /*
     * Método Constructor de la clase Tarifa
     * 
     * @param placa vehículo
     * @param modelo vehículo
     * @param propietario vehiculo
     */
    public Vehiculo(String placa, String modelo, Propietario propietario) {
        assert placa != null && !placa.isBlank() : "¡Error! La placa no puede ser nula o vacia";
        assert modelo != null && !modelo.isBlank() : "¡Error! El modelo no puede ser nulo o vacio";
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    /*
     * Método para obtener la tarifa  por hora de un carro
     * 
     * @return tarifa carro
     */
    public String getPlaca() {
        return placa;
    }

    /*
     * Método para obtener el modelo de un vehículo
     * 
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }


    /*
     * Método para obtener el propietario
     * 
     * @return propietario
     */
    public Propietario getPropietario (){
        return propietario;
    }

    /*
     * Método que devuelve una representación en forma de cadena de Vehículo
     *
     * @return una cadena que represente Vehículo
     */
    @Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", modelo=" + modelo + "]";
    }

    
}
