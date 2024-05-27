package co.edu.uniquindio.poo;

public class Tarifa {
    private double tarifaCarro;
    private double tarifaMotoHibrida;
    private double tarifaMotoClasica;
    
    /*
     * Método Constructor de la clase Tarifa
     * 
     * @param tarifa carro
     * @param tarifa moto hibrida
     * @param tarifa moto clásica
     */
    public Tarifa(double tarifaCarro, double tarifaMoroHibrida, double tarifaMotoClasica){
        assert tarifaCarro >= 0: "La tarifa para carros debe ser mayor o igual a cero";
        assert tarifaMoroHibrida >= 0: "La tarifa para motos híbridas debe ser mayor o igual a cero";
        assert tarifaMotoClasica >= 0: "La tarifa para motos clásicas debe ser mayor o igual a cero";
        this.tarifaCarro = tarifaCarro;
        this.tarifaMotoClasica = tarifaMotoClasica;
        this.tarifaMotoHibrida = tarifaMoroHibrida;
    }

    /*
     * Método para obtener la tarifa  por hora de un carro
     * 
     * @return tarifa carro
     */
    public double getTarifaCarro (){
        return tarifaCarro;
    }

    /*
     * Método para obtener la tarifa por hora de una moto clásica
     * 
     * @return tarifa moto clásica
     */
    public double getTarifaMotoClasica (){
        return tarifaMotoClasica;
    }
    
    /*
     * Método para obtener la tarifa por hora de una moto hibrida
     * 
     * @return tarifa moto hibrida
     */
    public double getTarifaMotoHibrida() {
        return tarifaMotoHibrida;
    }

    /*
     * Método para establecer la tarifa por hora de un carro
     * 
     * @param nueva tarifa carro
     */
    public void setTarifaCarro (double tarifaCarro){
        this.tarifaCarro = tarifaCarro;
    }

    /*
     * Método para establecer la tarifa por hora de una moto hibrida 
     * 
     * @param nueva tarifa moto hibrida
     */
    public void setTarifaMotoHibrida(double tarifaMotoHibrida) {
        this.tarifaMotoHibrida = tarifaMotoHibrida;
    }

    /*
     * Método para establecer la tarifa por hora de una moto clasica
     * 
     * @param nueva tarifa moto clasica 
     */
    public void setTarifaMotoClasica (double tarifaMotoClasica){
        this.tarifaMotoClasica = tarifaMotoClasica;
    }

    @Override
    public String toString() {
        return "Tarifa [tarifaCarro=" + tarifaCarro + ", tarifaMotoHibrida=" + tarifaMotoHibrida
                + ", tarifaMotoClasica=" + tarifaMotoClasica + "]";
    }
}