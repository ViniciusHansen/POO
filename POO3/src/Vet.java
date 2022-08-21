
public class Vet {
	private String nome;
	private float salario;
	public Adress adress;
	public Animal animais[] = new Animal[10];
	public int quantidadeAnimais;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public Animal[] getAnimais() {
		return animais;
	}
	public void setAnimais(Animal[] animais) {
		this.animais = animais;
	}
	public int getQuantidadeAnimais() {
		return quantidadeAnimais;
	}
	public void setQuantidadeAnimais(int quantidadeAnimais) {
		this.quantidadeAnimais = quantidadeAnimais;
	}
	
	
	
}
