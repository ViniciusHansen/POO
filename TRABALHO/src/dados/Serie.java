package dados;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Conteudo {
    private List<Episodio> episodios = new ArrayList<>();
    private int temporada;

    public Serie(String t, String gen, String desc, int a, int tempo) {
        super(t, gen, desc, a);
        this.temporada = tempo;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public Serie(){}
    public Episodio getEpisodio(int id) {
        Episodio e = new Episodio();
        for (Episodio it : episodios)
            if (it.getId() == id)
                e = it;
        return e;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public String getEpisodiosString() {
        String eps = new String();
        for (Episodio e : episodios)
            eps += e.toString();
        return eps;
    }

    @Override
    public String toString() {
        return String.format("• Título: %s \n• Temporada: %d  \n• Descrição: %s \n• Gênero: %s \n• Ano: %d \n\n‣ Episódios: %s \n\n‣ Elenco Principal: %s \n\n‣" +
                " Elenco Secundário: %s\n", titulo, temporada, descricao, genero, ano, this.getEpisodiosString(), this.getElenco1(), this.getElenco2());
    }
}
