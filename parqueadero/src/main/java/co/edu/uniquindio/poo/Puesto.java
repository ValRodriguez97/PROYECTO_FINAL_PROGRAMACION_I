package co.edu.uniquindio.poo;

public class Puesto {
    private Vehiculo vehiculo;
    private int i;
    private int j;

    public Puesto(int i, int j) {
        this.vehiculo = null;
        this.i = i;
        this.j = j;
    }

    public int getI(){
        return i;
    }    

    public int getJ (){
        return j;
    }

    public boolean noDisponible(){
        return vehiculo != null;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public void ocuparPuesto (Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    public void desocuparPuesto (){
        this.vehiculo = null;
    }



}
