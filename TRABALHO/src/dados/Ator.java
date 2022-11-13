package dados;

public class Ator {
	private int id;
	private String nome, dataNascimento, sexo;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Ator(String n, String nasc, String s){
		nome = n;
		dataNascimento = nasc;
		sexo = s;
	}
	public String toString() {
		return String.format("\nNome: %s \nData de Nascimento: %s \nSexo: %s \n",nome,dataNascimento,sexo);
	}
	
}
