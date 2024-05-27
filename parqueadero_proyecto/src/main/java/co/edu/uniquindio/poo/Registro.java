package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Registro {
    private LocalDateTime ingreso;
    private LocalDateTime salida;
    private Vehiculo registroVehiculo;
    private Puesto registroPuesto;

    /*
     * Método Constructor de la clase Registro
     * 
     * @param registroPuesto
     * @param registroVehículo
     */
    public Registro(Puesto registroPuesto, Vehiculo registroVehiculo) {
        assert registroPuesto != null : "¡Error! El puesto no puede ser nulo";
        assert registroVehiculo != null : "¡Error! El vehiculo no puede ser nulo";
        this.registroPuesto = registroPuesto;
        this.registroVehiculo = registroVehiculo;
        this.ingreso = LocalDateTime.now();
    }
    
    /*
     * Método para obtener el registro de un Puesto
     * 
     * @return registro de un Puesto
     */
    public Puesto getRegistroPuesto(){
        return registroPuesto;
    }

    /*
     * Método para obtener el registro de un vehículo
     * 
     * @return registro de un vehículo
     */
    public Vehiculo getRegistroVehiculo() {
        return registroVehiculo;
    }

    /*
     * Método para obtener el ingreso de un vehículo
     * 
     * @return ingreso
     */
    public LocalDateTime getIngreso() {
        return ingreso;
    }
    
    /*
     * Método para obtener la salida de un vehículo
     * 
     * @return salida 
     */
    public LocalDateTime getSalida() {
        return salida;

    }

    /*
     * Método para establecer el registro de un puesto
     * 
     * @param registro puesto
     */
    public void setRegistroPuesto (Puesto registroPuesto){
        this.registroPuesto = registroPuesto;
    }

    /*
     * Método para establecer el registro de un vehículo
     *
     * @param registro vehículo
     */
    public void setRegistroVehiculo(Vehiculo registroVehiculo) {
        this.registroVehiculo = registroVehiculo;
    }

    /*
     * Método para establecer el ingreso de un vehículo al parqueadero
     * 
     * @param ingreso
     */
    public void setIngreso(LocalDateTime ingreso) {
        this.ingreso = ingreso;
    }
    
    /*
     * Método para registrar la salida de un vehículo
     *
     * param salida
     */
    public void setSalida (LocalDateTime salida){
        assert salida != null:"La salida del vehículo debe de ser diferente de cero";
        this.salida = salida;
    }
   
    /**
     * Método para calcular el tiempo que estuvo estacionado un vehiculo
     * 
     * @return horas
     */

     public int calcularTiempo() {
        Duration tiempo = Duration.between(ingreso, salida);
        long minutos = tiempo.toMinutes();
        int horas = (int) Math.ceil(minutos / 60.0);
        return horas;
    }

     /*
     * Método que devuelve una representación en forma de cadena de Registro
     *
     * @return una cadena que represente Registro
     */
    @Override
    public String toString() {
        return "Registro [ingreso=" + ingreso + ", salida=" + salida + ", registroVehiculo=" + registroVehiculo
                + ", registroPuesto=" + registroPuesto + "]";
    }
}