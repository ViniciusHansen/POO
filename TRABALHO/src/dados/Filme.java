package dados;

public class Filme extends Conteudo{
	private int duracao; //minutos

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public String toString() {
		return "Filme [duracao=" + duracao + "]";
	}
	
}
