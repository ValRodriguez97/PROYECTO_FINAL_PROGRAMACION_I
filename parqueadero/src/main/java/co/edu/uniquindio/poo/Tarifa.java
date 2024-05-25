package co.edu.uniquindio.poo;

public class Tarifa {
    private double tarifaCarro;
    private double tarifaMotoHibrida;
    private double tarifaMotoClasica;
    private int valorHora;

    /*
     * Método Constructor de la clase Tarifa
     * 
     * @param valor hora
     */
    public Tarifa(double tarifaCarro, double tarifaMoroHibrida, double tarifaMotoClasica, int valorHora){
        this.tarifaCarro = tarifaCarro;
        this.tarifaMotoClasica = tarifaMotoClasica;
        this.tarifaMotoHibrida = tarifaMoroHibrida;
        this.valorHora = valorHora;
    }

    public double getTarifaCarro (){
        return tarifaCarro;
    }

    public double getTarifaMotoClasica (){
        return tarifaMotoClasica;
    }
    
    public double getTarifaMotoHibrida() {
        return tarifaMotoHibrida;
    }

    public void setTarifaMotoHibrida(double tarifaMotoHibrida) {
        this.tarifaMotoHibrida = tarifaMotoHibrida;
    }

    public int getValorHora() {
        return valorHora;
    }

    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return "Tarifa [valorHora=" + valorHora + "]";
    }
    
    public static void tarifaVehiculo (){

    }

    }

