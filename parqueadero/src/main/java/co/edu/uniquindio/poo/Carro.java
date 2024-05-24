package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {
    /*
     * Método Constructor de la clase Carro
     * @param placa
     * @param modelo
     * @param propietario
     */
    public Carro(String placa, String modelo, Tarifa tarifaVehiculo, Registro registroVehiculo, Propietario propietario){
        super(placa, modelo, tarifaVehiculo, registroVehiculo, propietario);
    } 

    /*
     * Método toString 
     */
    @Override
    public String toString() {
        return "Carro []";
    }


}
