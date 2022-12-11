package dados;

public class Episodio {
    private int id, duracao;
    private String descricao;

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
