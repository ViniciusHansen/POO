package dados;

public class Circulo extends FormaGeometrica{
    private double pi = 3.1415927;
    private int raio;

    public Circulo(int raio){
        super();
        this.raio = raio;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "pi=" + pi +
                ", raio=" + raio +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public double calculaPerimetro() {
        return 2 * pi * raio;
    }

    @Override
    public double calculaArea() {
        return pi * raio * raio;
    }
}
