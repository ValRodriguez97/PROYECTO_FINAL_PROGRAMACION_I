package co.edu.uniquindio.poo;

public class Puesto {
    private int i;
    private int j;
    private Vehiculo vehiculo;

    /*
     * Método Constructor de la clase Puesto
     * 
     * @param i
     * @param j
     */
    public Puesto(int i, int j) {
        this.vehiculo = null;
        this.i = i;
        this.j = j;
    }

    /*
     * Método para obtener la posición i
     * 
     * @return i
     */
    public int getI(){
        return i;
    }    

    /*
     * Método para obtener la posición j
     * 
     *@return j
     */
    public int getJ (){
        return j;
    }

    /*
     * Método para comprobar la disponibilidad de un puesto
     * 
     * @return disponibilidad de un puesto
     */
    public boolean noDisponible(){
        return vehiculo != null;
    }

    /*
     * Método para obtener el vehiculo en un puesto
     * 
     * @return vehiculo
     */
    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    /*
     * Método para que un vehículo ocupe un puesto
     */
    public void ocuparPuesto (Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    /*
     * Método para que un vehículo desocupe un puesto
     */
    public void desocuparPuesto (){
        this.vehiculo = null;
    }



}
