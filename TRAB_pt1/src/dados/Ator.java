package dados;

public class Ator {
	private int id;
	private String nome, dataNascimento;
	private char sexo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String toString() {
		return "Ator [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + "]";
	}
	
}
