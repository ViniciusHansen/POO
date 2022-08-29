package negocio;
import Dados.Vet;

public class SistemaPetShop {

	private Vet vets[];
	private int quantidadeVeterinarios = 0;
	
	public SistemaPetShop(int tamVet) {
		vets = new Vet[tamVet];
	}
	
	public void cadastrarVeterinario(Vet vet) {
		if (quantidadeVeterinarios < vets.length) {
			vets[quantidadeVeterinarios] = vet;
			quantidadeVeterinarios++;
		}
	}

	public Vet[] getVeterinarios() {
		return vets;
	}

	public int getQuantVeterinarios() {
		return quantidadeVeterinarios;
	}
}
	/*
	public Vet getVet() {
		return vets[quantidadeVeterinarios];
	}
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
	
	public void cadastrarVeterinario() {
		int qtdVets= getQuantidadeVeterinarios();
		if (qtdVets < 50) {
			System.out.println("Nome do Vet: ");
			vets[qtdVets].setNome(scan.next());
			System.out.println("Salário do Vet: ");
			vets[qtdVets].setSalario(Float.valueOf(scan.next()));
			qtdVets++;
			setQuantidadeVeterinarios(qtdVets);
		}
		else {
			System.out.println("Lista de vets cheia!");
		}
		
	}
	
	public void mostrarVeterinarios() {
		if (quantidadeVeterinarios > 1) {
			System.out.println("Lista de Veterinários:");
			for(int i=0;i<quantidadeVeterinarios;i++) {
				System.out.printf("Veterinario %i: %s",i,vets[i].getNome());
			}
		}
		else {
			System.out.println("Nenhum Veterinario cadastrado");
			return;
		}
	}
	
	public void cadastrarEnderecoVeterinario() {
		System.out.println("Veterinarios já cadastrados:");
		mostrarVeterinarios();
		System.out.println("Escolha o índice do Vet que deseja cadastrar o endereço:");
		int i = scan.nextInt();
		System.out.println("rua:");
		Adress temp = new Adress();
		temp.setRua(scan.next());
		System.out.println("número:");
		temp.setNumero(scan.next());
		System.out.println("bairro:");
		temp.setBairro(scan.next());
		System.out.println("cidade:");
		temp.setCidade(scan.next());
		System.out.println("cep:");
		temp.setCep(scan.next());
		vets[i].setAdress(temp);
	}
	
	public void cadastrarAnimal() {
		System.out.println("Veterinarios já cadastrados:");
		mostrarVeterinarios();
		System.out.println("Escolha o índice do Vet que deseja cadastrar um novo animal:");
		int i = scan.nextInt();	
		if(vets[i].getQuantidadeAnimais() < 10) {
			System.out.println("nome:");
			Animal temp[] = new Animal[vets[i].getAnimaisLength()];
			temp[vets[i].getQuantidadeAnimais()].setNome(scan.next());
			System.out.println("espécie:");
			temp[vets[i].getQuantidadeAnimais()].setEspecie(scan.next());
			System.out.println("descrição:");
			temp[vets[i].getQuantidadeAnimais()].setDesc(scan.next());
			vets[i].setAnimais(temp);
		}
	}
	
	public int mostrarAnimais() {
		if (quantidadeVeterinarios > 0) {
			mostrarVeterinarios();
		}
		else {
			System.out.println("Nenhum Veterinario cadastrado");
			return -999;
		}
		System.out.println("Escolha um Veterianáio(pelo indice) para ver os animais que ele cuida:");
		int i = scan.nextInt();
		Animal animais[] = new Animal[vets[i].getAnimaisLength()];
		for(int j=0;j<vets[i].getAnimaisLength();j++) {
			animais = vets[i].getAnimais();
			System.out.printf("Animal %i: %s", j, animais[j].getNome());
		}
		return i;
	}
	
	public void cadastrarDono() {
		int a = mostrarAnimais();
		if (a < 0) {
			System.out.println("Nenhum animal cadastrado");
			return;
		}
		System.out.println("Escolha um Animal(pelo indice) para cadastrar um dono:");
		int b = scan.nextInt();
		Animal animais[] = new Animal[vets[a].getAnimaisLength()];
		animais = vets[a].getAnimais();
		Dono temp = new Dono();
		System.out.println("Nome do dono:");
		temp.setNome(scan.next());
		System.out.println("CPF do dono:");
		temp.setCpf(scan.next());
		animais[b].setDono(temp);
	}
	
	public void cadastrarEnderecoDono() {
		int a = mostrarAnimais();
		if (a < 0) {
			System.out.println("Nenhum animal cadastrado");
			return;
		}
		System.out.println("Escolha um Animal(pelo indice) para cadastrar um dono:");
		int b = scan.nextInt();
		Animal animais[] = new Animal[vets[a].getAnimaisLength()];
		animais = vets[a].getAnimais();
		Dono dono = new Dono();
		dono = animais[b].getDono();
		Adress temp = new Adress();
			
		System.out.printf("Nome do dono: %s\n CPF do dono: %s\n", dono.getNome(),dono.getCpf());
		System.out.println("Insira a Rua do dono:");
		temp.setRua(scan.next());
		System.out.println("Insira o número(da casa) do dono:");
		temp.setNumero(scan.next());
		System.out.println("Insira o bairro:");
		temp.setBairro(scan.next());
		System.out.println("Insira a cidade:");
		temp.setCidade(scan.next());
		System.out.println("Insira o estado:");
		temp.setEstado(scan.next());
		System.out.println("Insira o CEP:");
		temp.setCep(scan.next());
			
		dono.setAdress(temp);



		
	}
}

	*/