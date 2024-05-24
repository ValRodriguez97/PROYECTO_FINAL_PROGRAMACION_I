package co.edu.uniquindio.poo;

public abstract class Vehiculo {
    private final String placa;
    private final String modelo;
    private Tarifa tarifaVehiculo;
    private Registro registroVehiculo;
    private Propietario propietario;
    
    public Vehiculo(String placa, String modelo, Tarifa tarifaVehiculo, Registro registroVehiculo, Propietario propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.tarifaVehiculo = tarifaVehiculo;
        this.registroVehiculo = registroVehiculo;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Tarifa getTarifa(){
        return tarifaVehiculo;
    }

    public Registro getRegistroVehiculo(){
        return registroVehiculo;
    }

    public Propietario getPropietario (){
        return propietario;
    }

    @Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", modelo=" + modelo + ", tarifa=" + tarifaVehiculo +"]";
    }

}
