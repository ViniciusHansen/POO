package dados;

import java.util.Arrays;

public class Imobiliaria {
	private String nome;
	private Imovel imoveis[];
	private int quantImoveis;
	
	
	public Imobiliaria(int quantImoveis) {
		imoveis = new Imovel[quantImoveis];
	}

	public int getQuantImoveis() {
		return quantImoveis;
	}

	public void setQuantImoveis(int quantImoveis) {
		this.quantImoveis = quantImoveis;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Imovel[] getImoveis() {
		return imoveis;
	}

	public void setImoveis(Imovel[] imoveis) {
		this.imoveis = imoveis;
	}

	public void adicionaImovel(Imovel imovel) {
		quantImoveis++;
		imoveis[quantImoveis] = imovel;
	}
	
	public Imovel[] filtrarPorArea(float x) {
		Imovel[] imoveis = this.getImoveis();
		Imovel[] imoveisMaiores = new Imovel[quantImoveis];
		int count=0;
		for(int i=0;i<imoveis.length;i++) {
			if(imoveis[i].areaImovel()>x) {
				imoveisMaiores[count]=imoveis[i];
				count++;
			}
		}
		for(int i=0;i<imoveisMaiores.length;i++) {
			for(int j=0;j<(imoveisMaiores.length)-1;j++) {
				Imovel aux = imoveisMaiores[i];
				imoveisMaiores[i] = imoveisMaiores[i+1];
				imoveisMaiores[i+1] = aux;
			}
		}
		return imoveisMaiores;
	}
	
	public String toString() {
		String imoveisStr[] = new String[quantImoveis];
		for(int i=0;i<quantImoveis;i++) {
			imoveisStr[i] = imoveis[i].toString();
		}
		return "Imobiliaria [nome=" + nome + ", imoveis=" + Arrays.toString(imoveisStr) + "]";
	}
	
	
	
}
