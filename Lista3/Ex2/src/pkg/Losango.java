package pkg;

import static java.lang.Math.sqrt;

public class Losango extends FormaGeometrica{
    public int calculaArea() {
        return (medida1*medida2)/2;
    }
    public int calculaPerimetro() {
        return (int) (4*(sqrt((medida1*medida1/4) + (medida2*medida2/4))));
    }
    public void setD(int d){
        super.medida1=d;
    }
    public void setd(int d){
        super.medida2=d;
    }
    public String toString(){
        return "Medida 1: "+super.medida1+" | Medida 2: "+super.medida2 +" | Area: "+calculaArea()+" | Perimetro: "+calculaPerimetro();
    }
}
