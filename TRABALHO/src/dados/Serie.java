package dados;


public class Serie extends Conteudo {
    private int temporada;

    public Serie(String t, String gen, String desc, int a, int tempo) {
        super(t, gen, desc, a);
        this.temporada = tempo;
    }

    public Serie() {
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

}
