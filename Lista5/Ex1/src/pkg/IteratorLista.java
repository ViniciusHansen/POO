package pkg;

import java.util.List;

public class IteratorLista<T> implements Iterator<T>{
    private List<T> lista;
    private int atual;

    public IteratorLista(List<T> l){
        this.lista = l;
        atual = 0;
    }

    @Override
    public boolean hasNext() {
        return !lista.get(atual + 1).equals(null);
    }

    @Override
    public T next() {
        return lista.get(atual + 1);
    }

    @Override
    public void reset() {
        this.atual = 0;
    }
}
