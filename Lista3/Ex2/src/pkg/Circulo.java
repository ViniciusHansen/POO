package pkg;

public class Circulo extends FormaGeometrica{
    public int calculaArea() {
        return (int) (3.14 * medida1 * medida1);
    }
    public int calculaPerimetro() {
        return (int) (3.14 * medida2);
    }
    public void setRaio(int r){
        super.medida1=r;//raio
        super.medida2=2*r;//diametro
    }
    public String toString(){
        return "Medida 1: "+super.medida1+" | Medida 2: "+super.medida2 +" | Area: "+calculaArea()+" | Perimetro: "+calculaPerimetro();
    }
}
