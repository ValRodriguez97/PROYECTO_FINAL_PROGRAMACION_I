package co.edu.uniquindio.poo;

<<<<<<< Updated upstream
=======
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
>>>>>>> Stashed changes
import java.util.Collection;
import java.util.LinkedList;

public class Parqueadero {
<<<<<<< Updated upstream
    private final String nombre;
    private Collection<Vehiculo> vehiculos;
=======
    private String nombre;
    private int filas; 
    private int columnas;
    private Tarifa tarifa;
    private double dineroRecaudadoDiario;
    private double dineroRecaudadoMensual;
>>>>>>> Stashed changes
    private Puesto[][] puestos;
    
<<<<<<< Updated upstream
    public Parqueadero(String nombre, int filas, int columnas) {
        this.nombre = nombre;
        this.vehiculos = new LinkedList<>();
        this.puestos = new Puesto[filas][columnas]; 
=======
    /*
     * Método Constructor de la clase Parqueadero
     * 
     * @param nombre del parqueadero
     * @param filas del parqueadero
     * @param columnas del parquedero
     * @param tarifa por tipo de vehiculo del parqueadero
     */
    public Parqueadero(String nombre, int filas, int columnas, Tarifa tarifa) {
        assert filas > 0 && columnas > 0;
        assert dineroRecaudadoDiario >= 0;
        assert dineroRecaudadoMensual >= 0;

        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
        this.tarifa = tarifa;
        this.dineroRecaudadoDiario = 0;
        this.dineroRecaudadoMensual = 0;
        this.puestos = new Puesto[filas][columnas];
        this.registros = new LinkedList<>(); 
       
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                puestos[i][j] = new Puesto(i, j);
            }
        }
>>>>>>> Stashed changes
    }

    public String getNombre() {
        return nombre;
    }
<<<<<<< Updated upstream
    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

=======

    /*
     * Método para obtener el número de filas del parqueadero
     * 
     * @return filas
     */
    public int getFilas() {
        return filas;
    }

    /*
     * Método para establecer el numero de filas 
     */
    public void setFilas(int filas) {
        this.filas = filas;
    }

    /*
     * Método para obtener el número de columnas del parqueadero
     */
    public int getColumnas() {
        return columnas;
    }
    
    /*
     * Método para establecer el número de columnas 
     */
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    /*
     * Método para obtener la tarifa por tipo de vehiculo de parqueadero
     * 
     * @return tarifa vehiculo
     */
    public Tarifa getTarifa (){
        return tarifa;
    }

    /*
     * Método para obtener los puestos del parqueadero
     * 
     * @return puestos 
     */
>>>>>>> Stashed changes
    public Puesto[][] getPuestos(){
        return puestos;
    }

    @Override
    public String toString() {
        return "Parqueadero [nombre=" + nombre + ", puestos=" + puestos + "]";
    }

<<<<<<< Updated upstream
    public void añadirPuesto (Puesto puesto, Posicion posicion){
        if (posicion.getI() >= 0 && posicion.getI() < puestos.length && posicion.getJ() >= 0 && posicion.getJ() < puestos.length){
            puestos[posicion.getI()][posicion.getJ()] = puesto;
        }
        
    }

     public void añadirVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }    

}

//Programación basada en eventos, respuesta a un evento, reaccionar a un evento. Permite una capacidad de respuesta nehirada, un manejo sencillo de flujo de datos
//estabilidad, 
//Fundamentos de la recursividad ->capacidad de llamarse a si mimsa varias veces, varias funciones, descomponer un problema. Caso base -> principio de la funcion, finalidad de la función
//Caso recursivo -> la funcion se llama varias veces hasta que encuentra la solución, permite una claridad en el código, código más legible, facilidad, flexibilidad y adaptabilidad

=======
    /*
     * Método para verificar la disponibilidad de un puesto en el parqueadero
     * 
     * @return disponibilidad 
     */
    public boolean disponibilidad (int i, int j){
        return !puestos[i][j].noDisponible();
    }

    /*
     * Método para ubicar un vehiculo en un determinado puesto
     */
    public void ubicarVehiculo(int i, int j, Vehiculo vehiculo){
        if (disponibilidad(i, j)){
            puestos[i][j].ocuparPuesto(vehiculo);
            registros.add(new Registro(puestos[i][j], vehiculo));
        } else {
           System.out.println("¡Error! El puesto al que intenta acceder se encuentra ocupado");
        }
    }

    /*
     * Método para registrar la salida de un vehículo del parqueadero
     */
    public void registrarSalidaVehiculo(Vehiculo vehiculo) {
        LocalDateTime tiempoActual = LocalDateTime.now();
        for (Registro registro : registros) {
            if (vehiculo.equals(registro.getRegistroVehiculo()) && registro.getSalida() == null) {
                registro.setSalida(tiempoActual);
                Puesto puesto = registro.getRegistroPuesto();
                puesto.desocuparPuesto(vehiculo);
                break;
            }
        }
    }
    
    /*
     * Método para identificar el propietario de un vehiculi según el puesto
     * 
     */
    public Propietario identificarPropietario(int i, int j) {
        if (i < 0 || i >= filas || j < 0 || j >= columnas) {
            throw new IllegalArgumentException("El parqueadero no cuenta con ese numero de puestos");
        }
    
        Puesto puesto = puestos[i][j];
        if (puesto.noDisponible()) {
            return puesto.getVehiculo().getPropietario();
        } else {
            return null; 
        }
    }

    
    /**
     * Método para generar un reporte del dinero recaudado mensualmente en el parqueadero.
     * 
     * @return reporte mensual
     */
    public Map<LocalDate, Double> generarReporteMensual(int mes, int año) {
        Map<LocalDate, Double> reporteMensual = new HashMap<>();
        for (Registro registro : registros) {
            LocalDate fechaRegistro = registro.getIngreso().toLocalDate();
            if (fechaRegistro.getMonthValue() == mes && fechaRegistro.getYear() == año && registro.getSalida() != null) {
                double valorEstacionamiento = calcularTarifa(registro);
                reporteMensual.merge(fechaRegistro,valorEstacionamiento, Double :: sum);
               // reporteMensual.put(fechaRegistro, reporteMensual.getOrDefault(fechaRegistro, 0.0) + valorEstacionamiento);
            }
        }
        return reporteMensual;
    }

    /**
     * Método para generar un reporte del dinero que se recauda diariamente por vehiculo en el parqueadero
     */
    public void generarReporteDiario (){

        double dineroRecaudadoCarro = 0.0;
        double dineroRecaudadoMotoHibrida = 0.0;
        double dineroRecaudadoMotoClasica = 0.0;
        LocalDateTime fechaActual = LocalDateTime.now();

        for (Registro registro : registros) {
            LocalDateTime fechaIngreso = registro.getIngreso();
            if (fechaIngreso.toLocalDate().isEqual(fechaActual.toLocalDate()) && registro.getSalida() != null) {
                if (registro.getRegistroVehiculo() instanceof Carro){
                    dineroRecaudadoCarro += calcularTarifa(registro);
                } else if (registro.getRegistroVehiculo() instanceof Moto){
                    Moto moto = (Moto) registro.getRegistroVehiculo();
                    if (moto.getTipoMoto() == TipoMoto.CLASICA){
                        dineroRecaudadoMotoClasica += calcularTarifa(registro);
                    } else {
                        dineroRecaudadoMotoHibrida += calcularTarifa(registro);
                    }
                }
            
            }
        }
        double totalDineroRecaudado = dineroRecaudadoCarro + dineroRecaudadoMotoClasica +dineroRecaudadoMotoHibrida;
        System.out.println("Reporte de recaudo diario del parqueadero:");
        System.out.println("Carros: " + dineroRecaudadoCarro);
        System.out.println("Motos Clásicas: " + dineroRecaudadoMotoClasica);
        System.out.println("Motos Híbridas: " + dineroRecaudadoMotoHibrida);
        System.out.println("Total: " + totalDineroRecaudado);
    }


    public double calcularTarifa(Registro registro){
        LocalDateTime ingreso = registro.getIngreso();
        LocalDateTime salida = registro.getSalida();
        long horasEstacionadas = Duration.between(ingreso, salida).toHours();
        double tarifaHora = 0;

        if (registro.getRegistroVehiculo() instanceof Carro){
            tarifaHora = tarifa.getTarifaCarro();
        } else if (registro.getRegistroVehiculo() instanceof Moto) {
            Moto moto = (Moto) registro.getRegistroVehiculo();
            if (moto.getTipoMoto() == TipoMoto.CLASICA){
                tarifaHora = tarifa.getTarifaMotoClasica();
            } else {
                tarifaHora = tarifa.getTarifaMotoHibrida();
            }
        }
        double costoTotal = (horasEstacionadas) *tarifaHora;
        return costoTotal;
    }
}



    /*public double generarReporteDiario(LocalDate fecha) {
        double dineroRecaudado = 0.0;
        for (Registro registro : registros) {
            if (registro.getIngreso().toLocalDate().isEqual(fecha) && registro.getSalida() != null) {
                dineroRecaudado += registro.calcularValorEstacionamiento();
            }
        }
        return dineroRecaudado;
    }
}*/
>>>>>>> Stashed changes
