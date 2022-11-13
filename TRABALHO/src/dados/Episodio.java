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
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String toString(){
		return String.format("\nEpisodio: %d \nDescrição: %s \nDuração: %d minutos \n",id,descricao,duracao);
	}
	
	
	
}
