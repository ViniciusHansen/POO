package dados;

import java.util.List;

public class Serie extends Conteudo{
	private List<Episodio> episodios;

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
	
	public String toString() {
		return "Serie [episodios=" + episodios + "]";
	}
	

	
	
}
