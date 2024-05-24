package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Registro {
    private LocalDateTime ingreso;
    private LocalDateTime salida;
    private Vehiculo registroVehiculo;
    private Puesto registroPuesto;

    public Registro(Puesto registroPuesto, Vehiculo registroVehiculo) {
        this.ingreso = LocalDateTime.now();
        this.registroPuesto = registroPuesto;
        this.registroVehiculo = registroVehiculo;
        assert registroPuesto != null;
        assert registroVehiculo != null;
    }
    
    public LocalDateTime getIngreso() {
        return ingreso;
    }
    
    public LocalDateTime salida() {
        return salida;
    }

    public Vehiculo getRegistroVehiculo() {
        return registroVehiculo;
    }

    public Puesto getRegistroPuesto(){
        return registroPuesto;
    }

    public void setRegistroVehiculo(Vehiculo registroVehiculo) {
        this.registroVehiculo = registroVehiculo;
    }

    public void salidaVehiculo (LocalDateTime salida){
        assert salida != null;
        this.salida = salida;
    }

    public double calcularValorEstacionamiento(Vehiculo vehiculo){
        double valor = 0;
        if (ingreso != null && salida != null){
            long tiempo = Duration.between(ingreso, salida).toHours();
            valor = tiempo * vehiculo.getTarifa().getValorHora();
        }
        return valor;
    }

    public double calcularTarifa(Vehiculo vehiculo){
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
            if (moto.getTipoMoto()== TipoMoto.MOTO_HIBRIDA){
                moto.getTarifa();
            }
        }
        return tiempo* tarifaPorHora;
    }

    @Override
    public String toString() {
        return "Registro [ingreso=" + ingreso + ", salida=" + salida + ", registroVehiculo=" + registroVehiculo
                + ", registroPuesto=" + registroPuesto + "]";
    }

    

}
