
public class Main {
	public static void main(String argv[]) {
		Grupo g = new Grupo();
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Cabral");
		p1.setAltura(1.69f);
		p1.setIdade(19);
		p1.setMassa(57f);
		System.out.printf("IMC de %s: %.2f", p1.getNome(), p1.getIMC());
		g.setPessoa(p1);
		
		//preencher o resto das pessoas
		
		g.sortIMC();
		
		for(int i=0;i<5;i++) {
			System.out.println("Nome: "+g.getPessoa(i).getNome());
			System.out.println("Altura: "+g.getPessoa(i).getAltura());
			System.out.println("Idade: "+g.getPessoa(i).getIdade());
			System.out.println("Massa: "+g.getPessoa(i).getMassa());
			System.out.println("IMC: "+g.getPessoa(i).getIMC());
			System.out.println();


		}
	}
}
