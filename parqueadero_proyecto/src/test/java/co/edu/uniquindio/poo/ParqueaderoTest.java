package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class ParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    //vale, puedes ir colocando lo de los LOG? es en cada prueba 
    @Test
    public void disponibilidadParqueadero() {
        LOG.info("Inicio Test");
        var tarifa = new Tarifa(4000, 3000, 2000);
        var parqueadero = new Parqueadero("Las clinas", 5, 3, tarifa);
        var propietario = new Propietario("James", "1037183721", "Calle 32 #21", "31218827");
        var vehiculo = new Moto("JAB123", "YAMAHA", propietario, TipoMoto.CLASICA, 300);
        parqueadero.disponibilidad(0, 0);
        assertTrue(parqueadero.disponibilidad(0, 0)); 
        parqueadero.ubicarVehiculo(0, 0, vehiculo);
        assertFalse(parqueadero.disponibilidad(0, 0));
    }

    @Test
    public void calcularTarifa() {
        Parqueadero parqueadero = new Parqueadero("Las ", 3, 5, new Tarifa(4000, 3000, 2000));
        Vehiculo motoClasica = new Moto("XYZ789", "Honda", new Propietario("James", "1037183721", "Calle 32 #21", "31218827")
        , TipoMoto.CLASICA, 200);
        parqueadero.ubicarVehiculo(0, 0, motoClasica); 
        Registro registro = new Registro(parqueadero.getPuestos()[0][0], motoClasica); 
        registro.setIngreso(LocalDateTime.of(2024, 5, 25, 10, 0));
        registro.setSalida(LocalDateTime.of(2024, 5, 25, 11, 42));
        assertEquals(4000, parqueadero.calcularTarifa(registro)); 
    }

    @Test
    public void ubicarVehiculoEnPuestoNoDisponible() {
        Tarifa tarifa = new Tarifa(4000, 3000, 2000);
        Parqueadero parqueadero = new Parqueadero("Las clinas", 5, 3, tarifa);
        Propietario propietario = new Propietario("James", "1037183721", "Calle 32 #21", "31218827");
        Vehiculo moto1 = new Moto("XYZ789", "Honda", propietario, TipoMoto.CLASICA, 120);
        Vehiculo moto2 = new Moto("XYZ789", "Honda", propietario, TipoMoto.CLASICA, 120);
        assertTrue(parqueadero.ubicarVehiculo(0, 0, moto1));
        assertFalse(parqueadero.ubicarVehiculo(0, 0, moto2));
        assertTrue(parqueadero.ubicarVehiculo(0, 1, moto2));
    }

    @Test
    public void registroPuesto() {
        Propietario propietario = new Propietario("James", "1037183721", "Calle 32 #21", "31218827");
        Vehiculo moto = new Moto("XYZ789", "Honda",propietario, TipoMoto.HIBRIDA, 120);
        
        assertThrows(AssertionError.class, () -> {
            new Registro(null, moto);
        });
    }

    @Test
    public void registroVehiculoNulo() {
        Tarifa tarifa = new Tarifa(3000, 1000, 4000);
        Parqueadero parqueadero = new Parqueadero("Las colinas", 5, 5, tarifa);
        assertThrows(Throwable.class, ()-> parqueadero.ubicarVehiculo(0, 0, null));
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

        parqueadero.registrarSalidaVehiculo(carro, LocalDateTime.of(2024, 5, 27, 11, 42));
        parqueadero.registrarSalidaVehiculo(motoClasica, LocalDateTime.of(2024, 5, 27, 11, 42));
        parqueadero.registrarSalidaVehiculo(motoHibrida, LocalDateTime.of(2024, 5, 27, 11, 42));
        //Registro registro = new Registro(parqueadero.getPuestos()[1][1], carro); 
        //registro.setIngreso(LocalDateTime.of(2024, 5, 25, 10, 0));

        parqueadero.generarReporteDiario();
    }  

    @Test 
    public void generarReporteMensual(){
        var tarifa = new Tarifa(3000, 2000, 3000);
        Parqueadero parqueadero = new Parqueadero("Las colinas", 4, 4, tarifa);
        Vehiculo carro = new Carro("ABC123", "ModeloCarro", new Propietario("Valen", "1094898396", "15", "315678987"));
        Vehiculo motoClasica = new Moto("DEF456", "ModeloMotoClasica", new Propietario("marta", "193894", "16", "283719410407"), TipoMoto.CLASICA, 100.0);
        Vehiculo motoHibrida = new Moto("GHI789", "ModeloMotoHibrida", new Propietario("Raquel","2940107947170","13","3148660808"), TipoMoto.HIBRIDA, 120.0);

        parqueadero.ubicarVehiculo(1, 1, carro);
        parqueadero.ubicarVehiculo(2, 2, motoClasica);
        parqueadero.ubicarVehiculo(3, 3, motoHibrida);

        parqueadero.registrarSalidaVehiculo(carro, LocalDateTime.of(2024, 5, 27, 11, 42));
        parqueadero.registrarSalidaVehiculo(motoClasica, LocalDateTime.of(2024, 5, 27, 11, 42));
        parqueadero.registrarSalidaVehiculo(motoHibrida, LocalDateTime.of(2024, 5, 27, 11, 42));

        parqueadero.generarReporteMensual(5, 2024);
    }
      
    @Test 
    public void tarifaMayor(){
   
        Tarifa tarifa = new Tarifa(0, 0, 0);
        assertTrue(tarifa.getTarifaCarro() >= 0, "La tarifa del carro debe ser mayor a 0");
        assertTrue(tarifa.getTarifaMotoClasica()>=0, "La tarifa de la moto clasica debe ser mayor a 0");
        assertTrue(tarifa.getTarifaMotoHibrida()>=0, "La tarifa de la moto hibrida debe ser mayor a 0");

    }    

    @Test
    public void datosCompletosPorpietario(){
        Propietario propietario = new Propietario("Valentina", "109489839", "M15-16", "3127659191");
     
        assertEquals(propietario, propietario);

    }

    @Test
    public void registrarSalidaVehiculo() {
 
        Tarifa tarifa = new Tarifa(4000, 3000, 2000);
        Parqueadero parqueadero = new Parqueadero("Las clinas", 5, 3, tarifa);
        Propietario propietario = new Propietario("James", "1037183721", "Calle 32 #21", "31218827");
        Vehiculo moto = new Moto("JAB123", "YAMAHA", propietario, TipoMoto.CLASICA, 300);
    
        Puesto[][] puestos = new Puesto[5][3];
           for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                puestos[i][j] = new Puesto(i, j);
            }
           
            }
        parqueadero.setPuestos(puestos);
        parqueadero.ubicarVehiculo(0, 0, moto);
        
        parqueadero.registrarSalidaVehiculo(moto, LocalDateTime.of(2024, 5, 27, 11, 42));
  
        assertTrue(parqueadero.getPuestos()[0][0].desocuparPuesto(moto), "desocupar puesto");
        assertEquals(moto,parqueadero.getPuestos()[0][0].getVehiculo());
        System.out.println("la salida del vehiculo se ha registrado correctamnete");
  
    }
    @Test
    public void testIdentificarPropietario() {
        Tarifa tarifa = new Tarifa(200,500,600);
        Parqueadero parqueadero = new Parqueadero("la 59",5,7,tarifa);
        Propietario propietario = new Propietario("maya","12345678388","w23","3156783456");
        Carro carro = new Carro("KMl73", "bmw", propietario);

        parqueadero.ubicarVehiculo(0, 0, carro);
        assertEquals(propietario, parqueadero.identificarPropietario(0, 0));

        
    }

 }