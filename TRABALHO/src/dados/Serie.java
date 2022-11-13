package dados;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Conteudo{
	private List<Episodio> episodios = new ArrayList<>();
	private int temporada;

	public Serie(String t, String gen, String desc, int a, int tempo) {
		super(t, gen, desc, a);
		this.temporada = tempo;
	}

	public Episodio getEpisodio(int id) {
		Episodio e = new Episodio();
		for(Episodio it : episodios)
			if(it.getId() == id)
				e = it;
		return e;
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
		return String.format("\nTítulo: %s \n Temporada: %d \n Episódios: %s \n Descrição: %s \n Gênero: %s \n Ano: %d \n Elenco Principal: %s \n" +
				"Elenco Secundário: %s\n", titulo, temporada, episodios, descricao, genero, ano, elencoPrincipal, elencoSecundario);
	}
}
