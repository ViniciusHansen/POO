package pkg;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Digrafo dg = new Digrafo();
        Grafo g = new Grafo();

        dg.adicionarVertice();
        dg.adicionarVertice();
        dg.adicionarVertice();
        dg.adicionarVertice();
        dg.adicionarVertice();
        dg.adicionarVertice();
        dg.adicionarAresta(0,1);
        dg.adicionarAresta(1,3);
        dg.adicionarAresta(2,0);

        System.out.println(dg.toString());

        g.adicionarVertice();
        g.adicionarVertice();
        g.adicionarVertice();
        g.adicionarVertice();
        g.adicionarVertice();
        g.adicionarVertice();
        g.adicionarAresta(0,1);
        g.adicionarAresta(1,3);
        g.adicionarAresta(2,0);
        System.out.println(g.toString());
    }
}
