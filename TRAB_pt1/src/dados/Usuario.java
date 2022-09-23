package dados;

public class Usuario {
	private int id;
	private String dataNascimento, nome, senha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String toString() {
		return "Usuario [id=" + id + ", dataNascimento=" + dataNascimento + ", nome=" + nome + ", senha=" + senha + "]";
	}
	
	
}
