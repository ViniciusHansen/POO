package apresentacao;

import dados.Matriz;
import dados.Quadrante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner s = new Scanner(System.in);

    public void addElementos(Matriz<Integer> m){
        int i=0,j=0;
        for(i=0;i<m.getLinhas();i++)
            for (j=0;j<m.getColunas();j++)
                m.set(Integer.valueOf(s.next()),i,j);
    }
    public int achaMenorValor(List<Integer> l){
        int menorValor = 9999999;
        for (int i : l)
            if(i<menorValor)
                menorValor = i;
        return menorValor;
    }
    public int menorValorParaQuadrantes(Matriz<Integer> m){
        List<Integer> l =new ArrayList<Integer>();
        int menorValor = achaMenorValor(m.getElementosQuadrante(Quadrante.PRIMEIRO));
        l.add(achaMenorValor(m.getElementosQuadrante(Quadrante.SEGUNDO)));
        l.add(achaMenorValor(m.getElementosQuadrante(Quadrante.TERCEIRO)));
        l.add(achaMenorValor(m.getElementosQuadrante(Quadrante.QUARTO)));
        for(int i : l)
            if(i<menorValor)
                menorValor = i;
        return menorValor;

    }
    public static void main(String[] args) {
        Main main = new Main();
        Matriz<Integer> matrix = new Matriz<Integer>(5,5);
        System.out.println("Digite os valores da matriz 5x5:");
        main.addElementos(matrix);
        System.out.println("Menor Valor:");
        System.out.println(main.menorValorParaQuadrantes(matrix));
    }

}
