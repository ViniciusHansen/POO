package negocio;

import dados.*;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorFormasGeometricas {
    private List<FormaGeometrica> l = new ArrayList<>();

    public List<FormaGeometrica> getL() {
        return l;
    }

    public void setL(List<FormaGeometrica> l) {
        this.l = l;
    }

    /*
        public void escreverArquivo(){

        }
        public void lerArquivo(){

        }*/
    public void inserirTriangulo(TrianguloEquilatero t){
        l.add(t);
    }
    public void inserirQuadrado(Quadrado q){
        l.add(q);
    }
    public void inserirRetangulo(Retangulo r){
        l.add(r);
    }
    public void inserirCirculo(Circulo c){
        l.add(c);
    }
}
