package persistencia;

import dados.Contato;
import java.util.*;

public class ContatoDAO {
    private ArquivoContatoDAO ac = new ArquivoContatoDAO();

    public void insert(Contato c){
        ac.salvaContato(c);
    }
    public void delete(Contato c){
        List<Contato> cs = new ArrayList<Contato>();
        cs.remove(c);
        ac.salvaContatos(cs);
    }
    public Map<Character, List<Contato>> getALL(){
       Map<Character,List<Contato>> c = new HashMap<Character,List<Contato>>();
            for (char i = 65; i < 91; i++) {
                List<Contato> l = new LinkedList<Contato>();
                c.put(i, l);
            }
            for (Contato contato : ac.leContatos()) {
                char inicial = contato.getNome().toUpperCase().charAt(0);
                c.get(inicial).add(contato);
        }

        return c;
    }
}
