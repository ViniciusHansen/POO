package pkg;

public class Video extends Arquivo{
    private Qualidade qualidade;

    public Qualidade getQualidade() {
        return qualidade;
    }

    public void setQualidade(Qualidade qualidade) {
        this.qualidade = qualidade;
    }

    public String toString() {
        String s = new String();
        s+="Nome: "+this.nome+"\n";
        s+="Extensão: "+this.extensao+"\n";
        s+="Qualidade: "+this.qualidade+"\n";
        return s;
    }

    public Video(String nome) throws NomeInvalidoException {
        super(nome);
        if(nome.contains("\n") || nome.contains("[") || nome.contains("]") || nome.contains("(") || nome.contains(")") ||
                nome.contains("\'") || nome.contains("\"") || nome.length() < 10 || nome.length() > 256)
            throw new NomeInvalidoException("Nome Inválido");
        this.nome = nome;
        this.extensao = ".mp4";

    }
}
