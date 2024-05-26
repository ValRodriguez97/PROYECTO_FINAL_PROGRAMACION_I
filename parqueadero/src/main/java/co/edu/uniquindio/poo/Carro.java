package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {
    /*
     * Método Constructor de la clase Carro
     * @param placa
     * @param modelo
     * @param propietario
     */
    public Carro(String placa, String modelo, Propietario propietario){
        super(placa, modelo, propietario);
    } 

    /*
     * @return cadena de texto que representa el objeto Carro 
     */
    @Override
    public String toString() {
        return "Carro []";
    }


}
