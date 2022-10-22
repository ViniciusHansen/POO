package pkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Digrafo {
    protected Map<Integer, List<Integer>> ma2 = new HashMap<Integer,List<Integer>>();

    public void adicionarVertice(){
        int index = ma2.size();
        for(Integer key : ma2.keySet()) {
            ma2.get(key).add(0);
        }
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<index;i++)
            l.add(0);
        l.add(0);
        ma2.put(index,l);
    }

    public Map<Integer, List<Integer>> getMa2() {
        return ma2;
    }

    public void adicionarAresta(int i, int j){
        ma2.get(i).set(j,1);
    }
    public String toString(){
        String m = new String();
        for(List<Integer> lista : ma2.values())
            m+= lista.toString()+"\n";
        return m;
    }
}
