package apresentacao;

import dados.Matriz;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Scanner s = new Scanner(System.in);
    private Matriz<Integer> matrix = new Matriz<Integer>(5,5);

    public void addElementos(Matriz<Integer> m){
        int i=0,j=0;
        for(i=0;i<m.getLinhas();i++)
            for (j=0;j<m.getColunas();j++)
                m.set(Integer.valueOf(s.next()),i,j);
    }



}
