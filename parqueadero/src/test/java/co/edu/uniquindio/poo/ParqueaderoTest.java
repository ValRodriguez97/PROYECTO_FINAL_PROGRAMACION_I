package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ParqueaderoTest {
    @Test
    public void disponibilidadParqueadero() {
        var tarifa = new Tarifa(4000, 3000, 2000);
        var parqueadero = new Parqueadero("Las clinas", 5, 3, tarifa);
        assertTrue(parqueadero.disponibilidad(0, 0));
        assertTrue(parqueadero.ubicarVehiculo(0, 0, new Moto("351293", "YAMAHA", 
            new Propietario("James", "1037183721", "Calle 32 #21", "31218827"),
            TipoMoto.CLASICA, 320)));
        assertFalse(parqueadero.ubicarVehiculo(0, 0, new Moto("351293", "YAMAHA",           
            new Propietario("James", "1037183721", "Calle 32 #21", "31218827"),
            TipoMoto.CLASICA, 320)));
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
