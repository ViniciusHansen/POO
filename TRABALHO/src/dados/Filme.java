package dados;

public class Filme extends Conteudo{
	private int duracao; //minutos

	public Filme(String t, String gen, String desc, int a, int dur) {
		super(t, gen, desc, a);
		this.duracao = dur;
	}

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
