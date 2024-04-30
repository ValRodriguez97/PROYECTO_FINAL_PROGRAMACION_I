package co.edu.uniquindio.poo;

public class Vehiculo {
    private final String placa;
    private final String modelo;
    
    public Vehiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", modelo=" + modelo + "]";
    }


}
