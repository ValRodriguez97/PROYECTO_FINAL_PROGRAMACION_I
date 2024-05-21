package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.LinkedList;

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

    public void registrarVehiculo (Vehiculo vehiculo){
        this.registroVehiculo = vehiculo;
    }

    public void registroPuesto (Puesto puesto){
        this.registroPuesto = puesto;
    }

    @Override
    public String toString() {
        return "Registro [fechaIngreso=" + fechaIngreso + ", horaIngreso=" + horaIngreso + ", vehiculo=" + registroVehiculo + ", puesto=" + registroPuesto + "]";
    }

    /**
     * Método para generar un reporte del dinero que se recauda diariamente por vehiculo en el parqueadero
     */
    public Collection<Double> generarReporteDiario (LocalDate fecha) {
        double dineroRecaudadoCarro = 0.0;
        double dineroRecaudadoMotoHibrida = 0.0;
        double dineroRecaudadoMotoClasica = 0.0;

        for (Registro registro : registros) {
            if (registro.getFechaEntrada().toLocalDate().isEqual(fecha) && registro.getFechaSalida() != null) {
                Vehiculo vehiculo = registro.getVehiculo();
                double tarifa = registro.calcularTarifa();

                if (vehiculo instanceof Carro) {
                    dineroRecaudadoCarro += tarifa;
                } else if (vehiculo instanceof Moto) {
                    Moto moto = (Moto) vehiculo;
                    if (moto.getTipoMoto() == TipoMoto.MOTO_CLASICA) {
                        dineroRecaudadoMotoClasica += tarifa;
                    } else {
                        dineroRecaudadoMotoHibrida += tarifa;
                    }
                }
            }
        }
        Collection<Double> reporteDiario = new LinkedList<>();
        reporteDiario.add(dineroRecaudadoCarro);
        reporteDiario.add(dineroRecaudadoMotoClasica);
        reporteDiario.add(dineroRecaudadoMotoHibrida);

        return reporteDiario;
    }
/**
     * Método para clacular el tiempo que estuvo estacionado un vehiculo
     */

    public int calcularTiempo(LocalDateTime fechaEntrada, LocalDateTime fechaSalida){
        Duration tiempo = Duration.between(fechaEntrada, fechaSalida);
        long horas = tiempo.toHours();
        return (int) horas ;
    }

     /**
     * Método para clacular el precio de la tarifa para cualquier vehiculo
     */
    
    public double calcularTarifa(){
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
        return tiempoEstacionado * tarifa
public void registrarSalidaVehiculo(Vehiculo vehiculo) {
        // Iterar sobre cada registro en el historial de registros del parqueadero
        for (Registro registro : historialRegistros) {
            // Verificar si el vehículo en el registro coincide con el vehículo que se va a retirar
            // y si aún no tiene una fecha de salida registrada
            if (registro.getVehiculo().equals(vehiculo) && registro.getFechaSalida() == null) {
                // Establecer la fecha de salida del vehículo como la fecha y hora actuales
                registro.setFechaSalida(LocalDateTime.now());
                
                // Liberar el puesto ocupado por el vehículo si es necesario
                // Aquí deberías implementar la lógica según el diseño de tu parqueadero
                // Por ejemplo, puedes marcar el puesto como disponible nuevamente
                // o realizar cualquier otra acción necesaria para el proceso de salida del vehículo
                
                // Salir del bucle una vez que se haya encontrado y actualizado el registro adecuado
                break;
            }
        }
    }

}
