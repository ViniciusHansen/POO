
public class Pessoa {
	private String nome;
	private int idade;
	private float altura;
	private float massa;
	
	public float getIMC() {
		return this.massa/(this.altura*this.altura);
	}
	public Pessoa(){
		
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return this.idade;
	}
	public void setIdade(int idade) {
		this.idade=idade;
	}
	public float getAltura() {
		return this.altura;
	}
	public void setAltura(float altura) {
		this.altura=altura;
	}
	public float getMassa() {
		return this.massa;
	}
	public void setMassa(float massa) {
		this.massa=massa;
	}
	
	
}

