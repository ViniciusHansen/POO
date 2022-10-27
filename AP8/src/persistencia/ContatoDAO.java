package persistencia;

import dados.Contato;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    }
}
