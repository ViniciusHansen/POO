package dados;

public class Ator {
	private int id;
	private String nome, dataNascimento, sexo;

	public void setId(int id) {
		this.id = id;
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
