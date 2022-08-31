package negocio;
import Dados.Vet;

public class SistemaPetShop {

	private Vet vets[];
	private int quantidadeVeterinarios;
	
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
	
	public void setVeterinario(Vet vet, int x) {
		vets[x] = vet;
	}

	public int getQuantVeterinarios() {
		return quantidadeVeterinarios;
	}
}
	/*
	

	
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