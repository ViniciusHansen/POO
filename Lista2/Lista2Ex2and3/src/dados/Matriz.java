package dados;

import java.util.ArrayList;
import java.util.List;

public class Matriz<T> {
    private int linhas, colunas;
    private List<List<T>> matriz;

    public List<List<T>> getMatriz() {
        return matriz;
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Matriz(int linhas, int colunas){
        int i=0, j=0;
        this.linhas=linhas;
        this.colunas=colunas;
        this.matriz=new ArrayList<List<T>>();
        for(i=0;i<linhas;i++)
            matriz.add(new ArrayList<T>());
            for (j=0;j<colunas;j++)
                matriz.get(j).add(null);
    }
    public boolean set(T objeto, int i, int j){
        if(this.linhas>=i || this.colunas>=j)
            return false;
        matriz.get(i).set(j, objeto);
        return true;
    }
    public T get(int i, int j){
        if(this.linhas>=i || this.colunas>=j)
            return null;
        return matriz.get(i).get(j);
    }
    public List<T> getLinha(int linha){
        return matriz.get(linha);
    }
    public List<T> getColuna(int coluna){
        if(coluna>=this.colunas)
            return null;
        List<T> temp = new ArrayList<>();
        for (List<T> linha : matriz)
            temp.add(linha.get(coluna));
        return temp;
    }
    public List<T> getElementosQuadrante(Quadrante quadrante){
        int l,c;
        if (linhas%2==0){
            l = linhas / 2;
            c = colunas / 2;
        }else{
            l = (linhas / 2) + 1;
            c = (colunas / 2) + 1;
        }
        List<T> listaQuadrante = new ArrayList<T>();
        int i=0,j=0;
        switch (quadrante){
            case PRIMEIRO:
                for(i=0;i<l;i++)
                    for(j=0;j<c;j++)
                        listaQuadrante.add(matriz.get(i).get(j));
                break;
            case SEGUNDO:
                for(i=l;i<linhas;i++)
                    for(j=0;j<c;j++)
                        listaQuadrante.add(matriz.get(i).get(j));
                break;
            case TERCEIRO:
                for(i=0;i<l;i++)
                    for(j=c;j<colunas;j++)
                        listaQuadrante.add(matriz.get(i).get(j));
                break;
            case QUARTO:
                for(i=l;i<linhas;i++)
                    for(j=c;j<colunas;j++)
                        listaQuadrante.add(matriz.get(i).get(j));
                break;
        }
        return listaQuadrante;
    }
}
