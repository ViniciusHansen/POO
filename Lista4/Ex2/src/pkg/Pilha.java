package pkg;

import java.util.ArrayList;
import java.util.List;

public class Pilha<T> {
    private int limite;
    private List<T> elementos = new ArrayList<T>();

    public Pilha (int limite){
        this.limite = limite;
    }
    public void inserir(T e) throws PilhaCheiaException{
    if(this.elementos.size() >= this.limite)
        throw new PilhaCheiaException("Pilha cheia");
    elementos.add(e);
    }
    public void remover() throws PilhaVaziaException{
        if(this.elementos.size()<1)
            throw new PilhaVaziaException("Pilha vazia");
        elementos.remove(elementos.size()-1);
    }

    public int getLimite() {
        return limite;
    }

    public int getSize(){
        return this.elementos.size();
    }

    public List<T> getElementos() {
        return elementos;
    }
}
