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

   /* @Test
    public void testDisponibilidadPuesto(){
        LOG.info("Inicio test para probar la disponibilidad de los puestos");
        var parqueadero = new Parqueadero("Parqueadero 24 horas", 5, 5);
        parqueadero.disponibilidadPuesto;
        for (int i = 0; i < p.getPuestos; i++){
            for (int j = 0; j <)
        }
        assertEquals("Disponible", parqueadero.getPuestos()[i][j].getDisponibilidad());
        LOG.info("Fin test para probar la disponibilidad de los puestos");
    }*/