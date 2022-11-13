package dados;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Conteudo{
	private List<Episodio> episodios = new ArrayList<Episodio>();
	private int temporada;

	public Serie(String t, String gen, String desc, int a, int tempo) {
		super(t, gen, desc, a);
		this.temporada = tempo;
	}

	public List<Episodio> getEpisodios() {
		return episodios;
	}

	public void cadastrarEpisodio(Episodio ep) {
		episodios.add(ep);
	}

	public boolean removerEpisodio(Episodio ep) {
		int antes = episodios.size();
		episodios.remove(ep);
		if(antes == episodios.size())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Título: {} | Temporada: {} | Número de Episódios: {} | Descrição: {} | Gênero: {} | Ano: {} | Elenco Principal: {} | " +
				"Elenco Secundário: {}", titulo, temporada, episodios.size(), descricao, genero, ano, elencoPrincipal, elencoSecundario);
	}
}
