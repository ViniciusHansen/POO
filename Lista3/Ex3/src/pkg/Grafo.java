package pkg;

public class Grafo extends Digrafo{
    public void adicionarAresta(int i, int j) {
        super.ma2.get(i).set(j,1);
        super.ma2.get(j).set(i,1);
    }
}
