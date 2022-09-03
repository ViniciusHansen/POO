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
	