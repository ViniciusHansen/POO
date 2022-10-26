package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class EditorTexto {
    public List<String> leTexto(String caminho){
        List<String> l = new LinkedList<String>();
        FileReader arq;
        BufferedReader lerArq;
        try{
            arq = new FileReader(caminho);
            lerArq = new BufferedReader(arq);
            String s = lerArq.readLine();
            while(s!=null){
                l.add(s);
                s = lerArq.readLine();
            }
            arq.close();
        }
        catch (Exception e){
            System.err.println("Erro arq");
            System.exit(0);
        }
        return l;
    }
    public void gravaTexto(String caminho, List<String> dados){
        FileWriter arq;
        try{
            arq = new FileWriter(caminho);
            for(int i=0;i< dados.size();i++)
                arq.write(dados.get(i) + "\n");
            arq.close();

        } catch (Exception e) {
            System.out.println("Erro arq");
            System.exit(0);
        }
    }
}
