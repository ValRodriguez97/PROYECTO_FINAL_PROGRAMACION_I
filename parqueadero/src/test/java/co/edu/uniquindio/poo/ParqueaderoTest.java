package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class ParqueaderoTest {
    @Test
    public void disponibilidadParqueadero() {
        var tarifa = new Tarifa(4000, 3000, 2000);
        var parqueadero = new Parqueadero("Las clinas", 5, 3, tarifa);
        assertTrue(parqueadero.disponibilidad(0, 0));
        assertTrue(parqueadero.ubicarVehiculo(0, 0, new Moto("351293", "YAMAHA", tarifa, propietario, TipoMoto.CLASICA,
            new Propietario("James", "1037183721", "Calle 32 #21", "31218827"),
            TipoMoto.CLASICA, 320)));
        assertFalse(parqueadero.ubicarVehiculo(0, 0, new Moto("351293", "YAMAHA", tarifa, propietario, TipoMoto.CLASICA,           
            new Propietario("James", "1037183721", "Calle 32 #21", "31218827"),
            TipoMoto.CLASICA, 320)));
    }

    @Test
    public void calcularTiempoEnParqueadero() {
        LocalDateTime entrada = LocalDateTime.of(2024, 5, 25, 10, 0);
        LocalDateTime salida = LocalDateTime.of(2024, 5, 25, 11, 30);
        int horas = Registro.calcularTiempo(entrada, salida);
        assertEquals(2, horas);  
    }

    @Test
    public void calcularTarifa() {
        Tarifa tarifa = new Tarifa(4000, 3000, 2000);
        Propietario propietario = new Propietario("James", "1037183721", "Calle 32 #21", "31218827");
        Vehiculo motoClasica = new Moto("XYZ789", "Honda", tarifa, propietario, TipoMoto.CLASICA, 200);
        Registro registro = new Registro(new Puesto(0, 0), motoClasica);
        registro.setIngreso(LocalDateTime.of(2024, 5, 25, 10, 0));
        registro.setSalida(LocalDateTime.of(2024, 5, 25, 11, 42));
        assertEquals(4000, registro.calcularTarifa()); 
    }

    @Test
    public void ubicarVehiculoEnPuestoNoDisponible() {
        Tarifa tarifa = new Tarifa(4000, 3000, 2000);
        Propietario propietario = new Propietario("James", "1037183721", "Calle 32 #21", "31218827");
        Vehiculo moto1 = new Moto("XYZ789", "Honda", tarifa, propietario, TipoMoto.CLASICA, 120);
        Vehiculo moto2 = new Moto("XYZ789", "Honda", tarifa, propietario, TipoMoto.CLASICA, 120);
        Parqueadero parqueadero = new Parqueadero("Las clinas", 5, 3, tarifa);
        assertTrue(parqueadero.ubicarVehiculo(0, 0, moto1));
        assertFalse(parqueadero.ubicarVehiculo(0, 0, moto2));
        assertTrue(parqueadero.ubicarVehiculo(0, 1, moto2));
    }

    @Test
    public void registroPuesto() {
        Tarifa tarifa = new Tarifa(4000, 3000, 2000);
        Propietario propietario = new Propietario("James", "1037183721", "Calle 32 #21", "31218827");
        Vehiculo moto = new Moto("XYZ789", "Honda", tarifa, propietario, TipoMoto.HIBRIDA, 120);
        
        assertThrows(AssertionError.class, () -> {
            new Registro(null, moto);
        });

        @Test
        public void registroVehiculo() {
            Puesto puesto = new Puesto(0, 0);
            assertThrows(AssertionError.class, () -> {
                new Registro(puesto, null);
            });
        }
}




    /*public void disponibilidadParqueadero (){
        var tarifa = new Tarifa(4000, 3000, 2000);
        var parqueadero = new Parqueadero("Las clinas", 5, 3, tarifa);
        assertTrue(parqueadero.disponibilidad(0, 0));
        parqueadero.ubicarVehiculo(0,0, new Moto("351293", "YAMAHA", 
        new Propietario("James", "1037183721", "Calle 32 #21", "31218827"),
         TipoMoto.CLASICA, 320));
         parqueadero.ubicarVehiculo(0,0, new Moto("351293", "YAMAHA", 
        new Propietario("James", "1037183721", "Calle 32 #21", "31218827"),
         TipoMoto.CLASICA, 320));
    }*/
