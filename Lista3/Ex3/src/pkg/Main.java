package pkg;

public class Main {
    public static void main(String[] args) {
        Digrafo dg = new Digrafo();
        Grafo g = new Grafo();

        dg.adicionarVertice();
        dg.adicionarVertice();
        dg.adicionarAresta(1,2);

        System.out.println(dg);
    }
}
