package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Registro {
    private final LocalDate fechaIngreso;
    private final LocalTime horaIngreso;
    private Vehiculo registroVehiculo;
    private Puesto registroPuesto;

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
    }

    public void setRegistroVehiculo(Vehiculo registroVehiculo) {
        this.registroVehiculo = registroVehiculo;
    }

    @Override
    public String toString() {
        return "Registro [fechaIngreso=" + fechaIngreso + ", horaIngreso=" + horaIngreso + ", vehiculo=" + registroVehiculo + ", puesto=" + registroPuesto + "]";
    }


}
