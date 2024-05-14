package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;

public class ParqueaderoTest {

    @Test
    public void crearParqueadero(){
        var parqueadero = new Parqueadero("Carros y motos", 5, 5);
        var posicion = new Posicion(2, 3);
        var puesto = new Puesto("Abierto", posicion);
        parqueadero.añadirPuesto(puesto, posicion);
        
        //assertEquals(puesto.getPosicion(), parqueadero.getPuesto());
        System.out.println(parqueadero.getPuestos().length);
    }
}
