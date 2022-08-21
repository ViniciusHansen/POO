import java.util.Scanner;

public class SistemaPetShop {
	Scanner scan = new Scanner(System.in);
	private Vet vets[] = new Vet[50];
	private int quantidadeVeterinarios = 0;
	
	public Vet[] getVets() {
		return vets;
	}
	public void setVets(Vet[] vets) {
		this.vets = vets;
	}
	public int getQuantidadeVeterinarios() {
		return quantidadeVeterinarios;
	}
	public void setQuantidadeVeterinarios(int quantidadeVeterinarios) {
		this.quantidadeVeterinarios = quantidadeVeterinarios;
	}
	
	@SuppressWarnings("null")
	public void cadastrarVeterinario() {
		Vet v = null;
		System.out.println("Nome do Vet: ");
		v.setNome(scan.next());
		System.out.println("Salário do Vet: ");
		v.setSalario(Float.valueOf(scan.next()));
		if (this.getVets().length < 50) {
			vets[this.quantidadeVeterinarios] = v;
			this.quantidadeVeterinarios++;
		}
	}
	
	public void mostrarVeterinarios() {
		for(int i=0;i<quantidadeVeterinarios;i++) {
			System.out.printf("Veteninario %i: %s",i,vets[i].getNome());
		}
	}
	
	public void cadastrarEncercoVeterinario() {
		System.out.println("Veterinarios já cadastrados:");
		mostrarVeterinarios();
		System.out.println("Escolha o índice do Vet que deseja cadastrar o endereço:");
		int i = scan.nextInt();
		System.out.println("rua:");
		vets[i].adress.setRua(scan.next());
		System.out.println("número:");
		vets[i].adress.setNumero(scan.next());
		System.out.println("bairro:");
		vets[i].adress.setBairro(scan.next());
		System.out.println("cidade:");
		vets[i].adress.setCidade(scan.next());
		System.out.println("cep:");
		vets[i].adress.setCep(scan.next());
	}
	
	public void cadastrarAnimal() {
		System.out.println("Veterinarios já cadastrados:");
		mostrarVeterinarios();
		System.out.println("Escolha o índice do Vet que deseja cadastrar um novo animal:");
		int i = scan.nextInt();	
		if(vets[i].quantidadeAnimais < 10) {
			System.out.println("nome:");
			vets[i].animais[vets[i].quantidadeAnimais].setNome(scan.next());
			System.out.println("espécie:");
			vets[i].animais[vets[i].quantidadeAnimais].setEspecie(scan.next());
			System.out.println("descrição:");
			vets[i].animais[vets[i].quantidadeAnimais].setDesc(scan.next());
		}
	}
	
	public void mostrarAnimais() {
		
	}
	
	
}
