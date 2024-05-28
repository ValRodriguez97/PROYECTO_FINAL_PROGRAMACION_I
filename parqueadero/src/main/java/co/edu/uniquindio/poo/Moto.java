package co.edu.uniquindio.poo;

public class Moto extends Vehiculo{
    private final TipoMoto tipoMoto;

    public Moto(String placa, String modelo, Tarifa tarifaVehiculo, Registro registroVehiculo, TipoMoto tipoMoto){
        super(placa, modelo, tarifaVehiculo, registroVehiculo);
        this.tipoMoto = tipoMoto;
    }
    
    public TipoMoto getTipoMoto (){
        return tipoMoto;
    }
    
    @Override
    public String toString() {
        return "Moto []";
    }


}
