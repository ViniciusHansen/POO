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
	
	
	//public Pessoa getPessoa(int i) {
	//	return pessoas[i];
	//}
	
}
