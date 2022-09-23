package dados;

import java.util.List;

public class Temporada {
	private List<Episodio> episodios;

	public List<Episodio> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(List<Episodio> episodios) {
		this.episodios = episodios;
	}

	public String toString() {
		return "Temporada [episodios=" + episodios + "]";
	}
	
	
}
