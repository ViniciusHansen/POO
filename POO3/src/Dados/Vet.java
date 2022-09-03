package Dados;


public class Vet {
	private String nome;
	private float salario;
	private Adress adress;
	private Animal animais[];
	private int quantidadeAnimais;
	
	public Vet(int tamAnimais) {
		animais = new Animal[tamAnimais]; 
	}
	
	public void cadastrarAnimal(Animal animal) {
		if (quantidadeAnimais < animais.length) {
			animais[quantidadeAnimais] = animal;
			quantidadeAnimais++;
		}
	}
	
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
	public Animal getAnimal(int x) {
		return animais[x];
	}
	public int getAnimaisLength() {
		return animais.length;
	}
	public void setAnimais(Animal[] animais) {
		this.animais = animais;
	}
	public void setAnimal(Animal animal, int x) {
		this.animais[x]=animal;
	}
	public int getQuantidadeAnimais() {
		return quantidadeAnimais;
	}
	public void setQuantidadeAnimais(int quantidadeAnimais) {
		this.quantidadeAnimais = quantidadeAnimais;
	}
	
	public String toString() {
		return "Nome: "+nome+" Salário: "+salario;
	}
	
}
