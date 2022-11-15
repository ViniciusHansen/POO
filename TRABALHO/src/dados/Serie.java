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

	public String getEpisodios(){
		String eps = new String();
		for(Episodio e : episodios)
			eps += e.toString();
		return eps;
	}

	@Override
	public String toString() {
		return String.format("• Título: %s \n• Temporada: %d  \n• Descrição: %s \n• Gênero: %s \n• Ano: %d \n\n‣ Episódios: %s \n\n‣ Elenco Principal: %s \n\n‣" +
				" Elenco Secundário: %s\n", titulo, temporada, descricao, genero, ano, this.getEpisodios(), this.getElenco1(), this.getElenco2());
	}
}
