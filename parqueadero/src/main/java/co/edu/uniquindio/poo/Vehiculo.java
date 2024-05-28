package co.edu.uniquindio.poo;

public abstract class Vehiculo {
    private final String placa;
    private final String modelo;
    private Tarifa tarifaVehiculo;
    private Registro registroVehiculo;
    
    public Vehiculo(String placa, String modelo, Tarifa tarifaVehiculo, Registro registroVehiculo) {
        this.placa = placa;
        this.modelo = modelo;
        this.tarifaVehiculo = tarifaVehiculo;
        this.registroVehiculo = registroVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    /*/*ublic Tarifa getTarifa(){
        return tarifaVehiculo;
    }*/

    public Registro getRegistroVehiculo(){
        return registroVehiculo;
    }

    @Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", modelo=" + modelo + ", tarifa=" + tarifaVehiculo +"]";
    }

}
