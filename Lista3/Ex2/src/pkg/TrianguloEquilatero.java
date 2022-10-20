package pkg;

import static java.lang.Math.sqrt;

public class TrianguloEquilatero extends FormaGeometrica{
    public int calculaArea() {
        return (int) ((sqrt(3)/4)*medida1*medida1);
    }

    public int calculaPerimetro() {
        return 3*medida1;
    }

    public void setLado(int v){
        super.medida1=v;
        super.medida2=v;
    }

    public String toString() {
        return "Medida 1: "+super.medida1+" | Medida 2: "+super.medida2 +" | Area: "+calculaArea()+" | Perimetro: "+calculaPerimetro();
    }
}
