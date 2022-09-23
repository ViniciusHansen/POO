package dados;

import java.util.List;

public class Serie extends Conteudo{
	private List<Temporada> temporadas;

	public List<Temporada> getTemporadas() {
		return temporadas;
	}

	public String toString() {
		return "Serie [temporadas=" + temporadas + "]";
	}

	
	
}
