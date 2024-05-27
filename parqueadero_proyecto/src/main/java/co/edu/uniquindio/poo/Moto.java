package co.edu.uniquindio.poo;

public class Moto extends Vehiculo{
    private final TipoMoto tipoMoto;
    private double velocidadMaxima;

    /*
     * Método Constructor de la clase Moto
     * 
     * @param placa de la moto
     * @param modelo de la moto
     * @param 
     */
    public Moto(String placa, String modelo, Propietario propietario, TipoMoto tipoMoto, double velocidadMaxima){
        super(placa, modelo, propietario);
        assert velocidadMaxima >= 0:"La velocidad máxima no puede ser menor a cero";
        this.tipoMoto = tipoMoto;
        this.velocidadMaxima =velocidadMaxima;
    }
    
    /*
     * Método para obtener el tipo de moto: HIBRIDA O CLÁSICA
     * 
     * @return tipo de moto
     */
    public TipoMoto getTipoMoto (){
        return tipoMoto;
    }

    /*
     * Método para obtener la velocidad máxima de una moto
     * 
     * @return velocidad máxima de la foto
     */
    public double getVelocidadMaxima(){
        return velocidadMaxima;
    }
    
    /*
     * @return cadena de texto que representa el objeto Moto
     */
    @Override
    public String toString() {
        return "Moto []";
    }
}
