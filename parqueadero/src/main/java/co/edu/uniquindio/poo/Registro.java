package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Registro {
    private final LocalDate fechaIngreso;
    private final LocalTime horaIngreso;
    private Vehiculo registroVehiculo;
    private Puesto registroPuesto;

<<<<<<< Updated upstream
    public Registro(LocalDate fechaIngreso, LocalTime horaIngreso, Puesto registroPuesto, Vehiculo registroVehiculo) {
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.registroPuesto = registroPuesto;
        this.registroVehiculo = registroVehiculo;
    }
    
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    
    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    public Vehiculo getRegistroVehiculo() {
        return registroVehiculo;
    }

    public Puesto getRegistroPuesto(){
        return registroPuesto;
=======
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


    public void setRegistroPuesto (Puesto registroPuesto){
        this.registroPuesto = registroPuesto;
>>>>>>> Stashed changes
    }

    public void setRegistroVehiculo(Vehiculo registroVehiculo) {
        this.registroVehiculo = registroVehiculo;
    }

<<<<<<< Updated upstream
=======
    public void setIngreso(LocalDateTime ingreso) {
        this.ingreso = ingreso;
    }
    
    /*
     * Método para registrar la salida de un vehículo
     */
    public void setSalida (LocalDateTime salida){
        assert salida != null;
        this.salida = salida;
    }

>>>>>>> Stashed changes
    @Override
    public String toString() {
        return "Registro [fechaIngreso=" + fechaIngreso + ", horaIngreso=" + horaIngreso + ", vehiculo=" + registroVehiculo + ", puesto=" + registroPuesto + "]";
    }


<<<<<<< Updated upstream
=======
     public static int calcularTiempo(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        Duration tiempo = Duration.between(fechaEntrada, fechaSalida);
        long minutos = tiempo.toMinutes();
        int horas = (int) Math.ceil(minutos / 60.0);
        return horas;
    }

     /**
     * Método para calcular el precio de la tarifa para cualquier vehiculo
     */
    
 

    /*public double calcularTarifa(){
        int tiempoEstacionado = calcularTiempo(fechaEntrada, fechaSalida);
        double tarifaPorHora = vehiculo.getTarifa();
        if (vehiculo instanceof Carro){
            vehiculo.getTarifa();
        }
        else if(vehiculo instanceof Moto){
            Moto moto = (Moto) vehiculo;
            if (moto.getTipoMoto()== TipoMoto.MOTO_HIBRIDA){
                moto.getTarifa();
            }
        }
        return tiempoEstacionado * tarifa*/

         

    /*public double calcularTarifa(Vehiculo vehiculo) {
        double valorTotal = 0;
        if (ingreso != null && salida != null) {
            long tiempoHoras = Duration.between(ingreso, salida).toHours();
            if (registroVehiculo instanceof Carro) {
                valorTotal = tiempoHoras * registroVehiculo.getTarifa().getTarifaCarro();
            } else if (registroVehiculo instanceof Moto) {
                Moto moto = (Moto) registroVehiculo;
                if (moto.getTipoMoto() == TipoMoto.CLASICA) {
                    valorTotal = tiempoHoras * registroVehiculo.getTarifa().getTarifaMotoClasica();
                } else {
                    valorTotal = tiempoHoras * registroVehiculo.getTarifa().getTarifaMotoHibrida();
                }
            }
        }
        return valorTotal;
    }

    
   /*public double calcularTarifa(Vehiculo vehiculo){
        double valor = 0;
        if (ingreso != null && salida != null){
            long tiempo = Duration.between(salida, ingreso).toHours();
            if (vehiculo instanceof Carro){
                valor = tiempo * vehiculo.getTarifa().getValorHora();
            }
        }
        int tiempoEstacionado = calcularTiempo(ingreso, salida);
        double tarifaPorHora = ;
        if (vehiculo instanceof Carro){
            vehiculo.getTarifa();
        }
        else if(vehiculo instanceof Moto){
            Moto moto = (Moto) vehiculo;
            if (moto.getTipoMoto()== TipoMoto.HIBRIDA){
                moto.getTarifa();
            }
        }
        return tiempo* tarifaPorHora;
    }
 }*/
>>>>>>> Stashed changes
}
