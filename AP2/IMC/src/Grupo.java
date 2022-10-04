
public class Grupo {
	private int numeroPessoas = 0;
	private Pessoa pessoas[] = new Pessoa[5];
	
	public Grupo() {

	}
	public void setPessoa(Pessoa p) {
		if (this.numeroPessoas < 5) {
			pessoas[this.numeroPessoas] = p;
			this.numeroPessoas++;
		}
	}
	public Pessoa getPessoa(int i) {
		return pessoas[i];
	}
	
	
	public void sortIMC() {
		for(int j=0;j<this.pessoas.length;j++) {
			for(int k=0;k<(this.pessoas.length)-1;k++) {
				if (this.pessoas[k].getIMC() < this.pessoas[k + 1].getIMC()) {
					Pessoa aux = this.pessoas[k];
					this.pessoas[k] = this.pessoas[k + 1];
					this.pessoas[k + 1] = aux;
				}
			}
		}
	}
}