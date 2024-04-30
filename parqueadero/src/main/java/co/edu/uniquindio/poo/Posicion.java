package co.edu.uniquindio.poo;

public class Posicion {
    private final int i;
    private final int j;

    public Posicion(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public String toString() {
        return "Posicion [i=" + i + ", j=" + j + "]";
    }


}
