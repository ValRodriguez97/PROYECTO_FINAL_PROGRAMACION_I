package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Registro {
    private final LocalDate fechaIngreso;
    private final LocalTime horaIngreso;

    public Registro(LocalDate fechaIngreso, LocalTime horaIngreso) {
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
    }
    
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    
    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    @Override
    public String toString() {
        return "Registro [fechaIngreso=" + fechaIngreso + ", horaIngreso=" + horaIngreso + "]";
    }


}
