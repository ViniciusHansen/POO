package dados;

public class Episodio {
    private int id, duracao, numeroEpisodio, serieID;

    public int getSerieID() {
        return serieID;
    }

    public void setSerieID(int serieID) {
        this.serieID = serieID;
    }

    private String descricao;

    public int getDuracao() {
        return duracao;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }


    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return String.format("\n- Episodio: %d \n- Descrição: %s \n- Duração: %d minutos \n", id, descricao, duracao);
    }
}
