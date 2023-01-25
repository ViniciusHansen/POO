package dados;

public class Quadrado extends Quadrilatero{
    private int lado;

    @Override
    public String toString() {
        return "Quadrado{" +
                "lado=" + lado +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public Quadrado(int x, int y, int lado){
        super(x,y,lado,lado,lado,lado);
        this.lado = lado;
    }

    @Override
    public double calculaArea() {
        return 4*lado;
    }
}
