package dados;

public class TrianguloEquilatero extends FormaGeometrica{
    protected int lado;

    public TrianguloEquilatero(int x, int y, int lado){
        super();
        this.lado =lado;
    }

    public double calculaArea() {
        return (Math.sqrt(3) * lado * lado)/4;
    }

    @Override
    public String toString() {
        return "TrianguloEquilatero{" +
                "lado=" + lado +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public double calculaPerimetro() {
        return 3 * lado;
    }
}
