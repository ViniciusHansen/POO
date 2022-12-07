package dados;

public class Retangulo extends Quadrilatero{
    private int base, altura;

    public Retangulo(int x, int y, int base, int altura){
        super(x,y,base,altura,base,altura);//l1,l2,l3,l4
        this.base = base;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Retangulo{" +
                "base=" + base +
                ", altura=" + altura +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public double calculaArea() {
        return base * altura;
    }
}
