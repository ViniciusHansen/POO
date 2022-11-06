package pkg;

public abstract class Arquivo {
    protected String nome, extensao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public String getExtensao() {
        return extensao;
    }

    public Arquivo(String nome) throws NomeInvalidoException{
        if(nome.contains("\n") || nome.contains("[") || nome.contains("]") || nome.contains("(") || nome.contains(")") ||
                nome.contains("\'") || nome.contains("\"") || nome.length() < 10 || nome.length() > 256)
            throw new NomeInvalidoException("Nome Inválido");
        this.nome = nome;
    }
}
