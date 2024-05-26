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
        this.ingreso = LocalDateTime.now();
        this.registroPuesto = registroPuesto;
        this.registroVehiculo = registroVehiculo;
        assert registroPuesto != null;
        assert registroVehiculo != null;
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
     * Método para obtener el registro de un vehículo
     * 
     * @return registro de un vehículo
     */
    public Vehiculo getRegistroVehiculo() {
        return registroVehiculo;
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
     * Método 
     */
    public void setRegistroVehiculo(Vehiculo registroVehiculo) {
        this.registroVehiculo = registroVehiculo;
    }

    public void setIngreso(LocalDateTime ingreso) {
        this.ingreso = ingreso;
    }

    public void setSalida(LocalDateTime salida) {
        this.salida = salida;
    }
    
    /*
     * Método para registrar la salida de un vehículo
     */
    public void salidaVehiculo (LocalDateTime salida){
        assert salida != null;
        this.salida = salida;
    }

    @Override
    public String toString() {
        return "Registro [ingreso=" + ingreso + ", salida=" + salida + ", registroVehiculo=" + registroVehiculo
                + ", registroPuesto=" + registroPuesto + "]";
    }

   
/**
     * Método para calcular el tiempo que estuvo estacionado un vehiculo
     */

     public static int calcularTiempo(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
        Duration tiempo = Duration.between(fechaEntrada, fechaSalida);
        long minutos = tiempo.toMinutes();
        int horas = (int) Math.ceil(minutos / 60.0);
        return horas;
    }

     /**
     * Método para calcular el precio de la tarifa para cualquier vehiculo
     */
    
 
     public double calcularTarifa() {
        if (ingreso == null || salida == null) {
            throw new IllegalStateException("El vehículo no tiene tiempo de ingreso o salida registrado.");
        }
        long tiempoMinutos = Duration.between(ingreso, salida).toMinutes();
        int tiempoHoras = (int) Math.ceil(tiempoMinutos / 60.0);
        double valorTotal = 0;
        Tarifa tarifa = registroVehiculo.getTarifa();
        if (registroVehiculo instanceof Carro) {
            valorTotal = tiempoHoras * tarifa.getTarifaCarro();
        } else if (registroVehiculo instanceof Moto) {
            Moto moto = (Moto) registroVehiculo;
            if (moto.getTipoMoto() == TipoMoto.CLASICA) {
                valorTotal = tiempoHoras * tarifa.getTarifaMotoClasica();
            } else if (moto.getTipoMoto() == TipoMoto.HIBRIDA) {
                valorTotal = tiempoHoras * tarifa.getTarifaMotoHibrida();
            }
        }

        return valorTotal;
    }

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
}
