package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {

    public Carro(String placa, String modelo, Tarifa tarifaVehiculo, Registro registroVehiculo){
        super(placa, modelo, tarifaVehiculo, registroVehiculo);
    } 

    @Override
    public String toString() {
        return "Carro []";
    }


}
