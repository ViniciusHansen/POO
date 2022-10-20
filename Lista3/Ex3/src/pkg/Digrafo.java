package pkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Digrafo {
    protected Map<Integer, List<Integer>> ma2 = new HashMap<Integer,List<Integer>>();

    public void adicionarVertice(){
        int index = ma2.size();
        for(Map.Entry<Integer,List<Integer>> entrada : ma2.entrySet()){
            List<Integer> ls=entrada.getValue();
            ls.add(0);
            entrada.setValue(ls);
        }
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<index;i++)
            l.add(0);
        ma2.put(index,l);
    }
    public void adicionarAresta(int i, int j){
        ma2.get(i).set(j,1);
    }
    //public String toString(){
    //    return "";
    //}
}
