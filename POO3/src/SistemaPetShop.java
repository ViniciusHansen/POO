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
	
	public int mostrarAnimais() {
		mostrarVeterinarios();
		System.out.println("Escolha um Veterianáio(pelo indice) para ver os animais que ele cuida:");
		int i = scan.nextInt();
		for(int j=0;j<vets[i].animais.length;j++) {
			System.out.printf("Animal %i: %s", j, vets[i].animais[j].getNome());
		}
		return i;
	}
	
	public void cadastrarDono() {
		int a = mostrarAnimais();
		System.out.println("Escolha um Animal(pelo indice) para cadastrar um dono:");
		int b = scan.nextInt();
		System.out.println("Nome do dono:");
		vets[a].animais[b].dono.setNome(scan.next());
		System.out.println("CPF do dono:");
		vets[a].animais[b].dono.setCpf(scan.next());

	}
	
	public void cadastrarEnderecoDono() {
		int a = mostrarAnimais();
		System.out.println("Escolha um Animal(pelo indice) para cadastrar um dono:");
		int b = scan.nextInt();
		for (int i=0;i<vets[a].quantidadeAnimais;i++) {
			System.out.printf("Nome do dono: %s\n CPF do dono: %s\n", vets[a].animais[b].dono.getNome(),vets[a].animais[b].dono.getCpf());
			System.out.println("Insira a Rua do dono:");
			vets[a].animais[b].dono.adress.setRua(scan.next());
			System.out.println("Insira o número(da casa) do dono:");
			vets[a].animais[b].dono.adress.setNumero(scan.next());
			System.out.println("Insira o bairro:");
			vets[a].animais[b].dono.adress.setBairro(scan.next());
			System.out.println("Insira a cidade:");
			vets[a].animais[b].dono.adress.setCidade(scan.next());
			System.out.println("Insira o estado:");
			vets[a].animais[b].dono.adress.setEstado(scan.next());
			System.out.println("Insira o CEP:");
			vets[a].animais[b].dono.adress.setCep(scan.next());




		}
	}
}
