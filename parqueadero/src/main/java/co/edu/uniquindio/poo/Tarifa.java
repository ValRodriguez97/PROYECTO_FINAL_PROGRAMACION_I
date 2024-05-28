package co.edu.uniquindio.poo;

public class Tarifa {
    private final double valorHora;

    public Tarifa(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getValorHora() {
        return valorHora;
    }

    @Override
    public String toString() {
        return "Tarifa [valorHora=" + valorHora + "]";
    }


}
