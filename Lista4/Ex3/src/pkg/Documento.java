package pkg;

public class Documento extends Arquivo{
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String toString() {
        String s = new String();
        s+="Nome: "+this.nome+"\n";
        s+="Extensão: "+this.extensao+"\n";
        s+="Conteúdo: "+this.texto+"\n";
        return s;
    }

    public Documento(String nome) throws NomeInvalidoException {
        super(nome);
        if(nome.contains("\n") || nome.contains("[") || nome.contains("]") || nome.contains("(") || nome.contains(")") ||
        nome.contains("\'") || nome.contains("\"") || nome.length() < 10 || nome.length() > 256)
            throw new NomeInvalidoException("Nome Inválido");
        this.nome = nome;
        this.extensao = ".txt";

    }
}
