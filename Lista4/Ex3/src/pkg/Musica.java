package pkg;

public class Musica extends Arquivo{
    private int duracao;

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String toString() {
        String s = new String();
        s+="Nome: "+this.nome+"\n";
        s+="Extensão: "+this.extensao+"\n";
        s+="Duração: "+this.duracao+"\n";
        return s;
    }

    public Musica(String nome) throws NomeInvalidoException {
        super(nome);
        if(nome.contains("\n") || nome.contains("[") || nome.contains("]") || nome.contains("(") || nome.contains(")") ||
                nome.contains("\'") || nome.contains("\"") || nome.length() < 10 || nome.length() > 256)
            throw new NomeInvalidoException("Nome Inválido");
        this.nome = nome;
        this.extensao = ".mp3";

    }

}
