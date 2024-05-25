package co.edu.uniquindio.poo;

public class Moto extends Vehiculo{
    private final TipoMoto tipoMoto;
    private double velocidadMaxima;

    public Moto(String placa, String modelo, Tarifa tarifaVehiculo, Registro registroVehiculo, Propietario propietario, TipoMoto tipoMoto, double velocidadMaxima){
        super(placa, modelo, tarifaVehiculo, registroVehiculo, propietario);
        assert velocidadMaxima >= 0;
        this.tipoMoto = tipoMoto;
        this.velocidadMaxima =velocidadMaxima;
    }
    
    public TipoMoto getTipoMoto (){
        return tipoMoto;
    }

    public double getVelocidadMaxima(){
        return velocidadMaxima;
    }
    
    @Override
    public String toString() {
        return "Moto []";
    }


}
