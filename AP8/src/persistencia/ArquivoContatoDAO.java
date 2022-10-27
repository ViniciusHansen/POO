package persistencia;

import dados.Contato;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArquivoContatoDAO {
    private EditorTexto editor = new EditorTexto();
    private final String caminho = "files/contatos.csv";

    private String toCSV(Contato c){
        return c.getNome() + "," + c.getTelefone();
    }
    private Contato fromCSV(String s){
        String a[] = s.split(",");
        Contato contato = new Contato();
        contato.setNome(a[0]);
        contato.setTelefone(a[1]);
        return contato;
    }
    public List<Contato> leContatos(){
        List<Contato> lc = new LinkedList<Contato>();
        for(String linha : editor.leTexto(caminho))
            lc.add(fromCSV(linha));
        return lc;
    }
    public void salvaContatos(List<Contato> cs){
        List<String> lc = new LinkedList<String>();
        for(Contato contato : cs)
            lc.add(toCSV(contato));
        editor.gravaTexto(caminho,lc);
    }
    public void salvaContato(Contato contato){
        editor.gravaTexto(caminho,toCSV(contato));
    }
}
