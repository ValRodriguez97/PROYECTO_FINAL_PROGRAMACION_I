package co.edu.uniquindio.poo;

public class Tarifa {
    private double tarifaCarro;
    private double tarifaMotoHibrida;
    private double tarifaMotoClasica;

    /*
     * Método Constructor de la clase Tarifa
     * 
     * @param valor hora
     */
    public Tarifa(double tarifaCarro, double tarifaMoroHibrida, double tarifaMotoClasica){
        this.tarifaCarro = tarifaCarro;
        this.tarifaMotoClasica = tarifaMotoClasica;
        this.tarifaMotoHibrida = tarifaMoroHibrida;
    }

    public double getTarifaCarro (){
        return tarifaCarro;
    }

    public double getTarifaMotoClasica (){
        return tarifaMotoClasica;
    }
    

    @Override
    public String toString() {
        return "Tarifa [valorHora=" + valorHora + "]";
    }
    
    public static void tarifaVehicul0 (){

    }

    }

