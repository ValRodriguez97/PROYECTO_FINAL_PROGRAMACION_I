package co.edu.uniquindio.poo;

<<<<<<< Updated upstream
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

>>>>>>> Stashed changes
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

    @Test
public void generarReporteDiario() {
    var tarifa = new Tarifa(3000, 2000, 3000);
    Parqueadero parqueadero = new Parqueadero("Las colinas", 4, 4, tarifa);
    Vehiculo carro = new Carro("ABC123", "ModeloCarro", new Propietario("Valen", "1094898396", "15", "315678987"));
    Vehiculo motoClasica = new Moto("DEF456", "ModeloMotoClasica", new Propietario("marta", "193894", "16", "283719410407"), TipoMoto.CLASICA, 100.0);
    Vehiculo motoHibrida = new Moto("GHI789", "ModeloMotoHibrida", new Propietario("Raquel","2940107947170","13","3148660808"), TipoMoto.HIBRIDA, 120.0);
    
    parqueadero.ubicarVehiculo(1, 1, carro);
    parqueadero.ubicarVehiculo(2, 2, motoClasica);
    parqueadero.ubicarVehiculo(3, 3, motoHibrida);
 

    parqueadero.registrarSalidaVehiculo(carro);
    parqueadero.generarReporteDiario();


    /*Puesto puesto1 = new Puesto(1, 1);
    Puesto puesto2 = new Puesto(2, 2);
    Puesto puesto3 = new Puesto(3, 3);
    
    Registro registroCarro = new Registro(puesto1, carro);
    Registro registroMotoClasica = new Registro(puesto2, motoClasica);
    Registro registroMotoHibrida = new Registro(puesto3, motoHibrida);
    
 
    registroCarro.setIngreso(LocalDateTime.of(2024, 5, 26, 8, 0)); // Por ejemplo, ingresa a las 8:00 AM
    registroMotoClasica.setIngreso(LocalDateTime.of(2024, 5, 26, 9, 0)); // Por ejemplo, ingresa a las 9:00 AM
    registroMotoHibrida.setIngreso(LocalDateTime.of(2024, 5, 26, 10, 0)); // Por ejemplo, ingresa a las 10:00 AM
    
  
    registroCarro.setSalida(LocalDateTime.of(2024, 5, 26, 12, 0)); // Por ejemplo, sale a las 12:00 PM
    registroMotoClasica.setSalida(LocalDateTime.of(2024, 5, 26, 11, 0)); // Por ejemplo, sale a las 11:00 AM
    registroMotoHibrida.setSalida(LocalDateTime.of(2024, 5, 26, 13, 0)); // Por ejemplo, sale a las 1:00 PM
    
 
    ArrayList<Registro> registros = new ArrayList<>();
    registros.add(registroCarro);
    registros.add(registroMotoClasica);
    registros.add(registroMotoHibrida);
    
  
    Parqueadero parqueadero = new Parqueadero("La 50", 3, 4, new Tarifa(4000, 3000, 2000)); // Pasar la tarifa correctamente
    parqueadero.getRegistros().addAll(registros);
    

    LocalDate fecha = LocalDate.of(2024, 5, 26); // Fecha específica para generar el reporte
    Collection<Double> reporteDiario = parqueadero.generarReporteDiario(fecha); // Obtener el reporte diario para la fecha específica
    
   
    assertEquals(0.0, reporteDiario.stream().findFirst().orElse(0.0), "Cantidad recaudada para Carro incorrecta");
    assertEquals(200.0, reporteDiario.stream().skip(1).findFirst().orElse(0.0), "Cantidad recaudada para Moto Clásica incorrecta"); // Suponiendo una tarifa de $100 por hora
    assertEquals(240.0, reporteDiario.stream().skip(2).findFirst().orElse(0.0), "Cantidad recaudada para Moto Híbrida incorrecta"); // Suponiendo una tarifa de $120 por hora*/
}
}
