package pkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaArquivos {
    private Map<String, List<Arquivo>> diretorios = new HashMap<String, List<Arquivo>>();

    public SistemaArquivos(){
        List<Arquivo> l1 = new ArrayList<Arquivo>();
        List<Arquivo> l2 = new ArrayList<Arquivo>();
        diretorios.put("Documentos",l1);
        diretorios.put("Downloads",l2);
    }

    public void criarDocumento(String nome, String dir, String texto) throws NomeInvalidoException{
        try{
            Documento doc = new Documento(nome);
            doc.setTexto(texto);
            diretorios.get(dir).add(doc);
        }catch (NomeInvalidoException e){
            throw new NomeInvalidoException("Nome Inválido");
        }
    }
    public void criarMusica(String nome, String dir, int duracao) throws NomeInvalidoException{
        try {
            Musica musica = new Musica(nome);
            musica.setDuracao(duracao);
            diretorios.get(dir).add(musica);
        }catch (NomeInvalidoException e){
            throw new NomeInvalidoException("Nome Inválido");
        }
    }
    public void criarVideo(String nome, String dir, Qualidade qualidade) throws NomeInvalidoException {
        try {
            Video video = new Video(nome);
            video.setQualidade(qualidade);
            diretorios.get(dir).add(video);
        }catch (NomeInvalidoException e){
            throw new NomeInvalidoException("Nome Inválido");
        }
    }

    public String toString() {
        String s = new String();
        for(String nome_dir : diretorios.keySet()){
            s+= nome_dir+":\n";
            for(Arquivo a : diretorios.get(nome_dir)){
                s+= a.getNome() + a.getExtensao() + "\n";
                if(a instanceof Musica){
                    s+= "Duração: " + ((Musica) a).getDuracao() + "\n";
                }
                if (a instanceof Video){
                    s+= "Qualidade: " + ((Video) a).getQualidade() + "\n";
                }
            }
            s+="\n";
        }
        return s;
    }
}
