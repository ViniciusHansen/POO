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

	@Override
	public String toString() {
		return String.format("Título: {} | Descrição: {} | Gênero: {} | Ano: {} | Duração: {} | Elenco Principal: {} | " +
				"Elenco Secundário: {}", titulo, descricao, genero, ano, duracao, elencoPrincipal, elencoSecundario);
	}
}
