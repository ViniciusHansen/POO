
public class Main {
	public static void main(String argv[]) {
		Grupo g = new Grupo();
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Cabral");
		p1.setAltura(1.69f);
		p1.setIdade(19);
		p1.setMassa(57f);
		//System.out.printf("IMC de %s: %.2f", p1.getNome(), p1.getIMC());
		g.setPessoa(p1);
		
		Pessoa p2= new Pessoa();
		p2.setNome("Vinícius");
		p2.setAltura(1.76f);
		p2.setIdade(19);
		p2.setMassa(71f);
		g.setPessoa(p2);
		
		Pessoa p3 = new Pessoa();
		p3.setNome("Maurício");
		p3.setAltura(1.70f);
		p3.setIdade(19);
		p3.setMassa(60f);
		g.setPessoa(p3);
		
		Pessoa p4 = new Pessoa();
		p4.setNome("Lívia");
		p4.setAltura(1.64f);
		p4.setIdade(21);
		p4.setMassa(60f);
		g.setPessoa(p4);
		
		Pessoa p5 = new Pessoa();
		p5.setNome("JP");
		p5.setAltura(1.76f);
		p5.setIdade(21);
		p5.setMassa(69f);
		g.setPessoa(p5);
		
		g.sortIMC();
		
		for(int i=0;i<5;i++) {
			System.out.println("Nome: "+g.getPessoa(i).getNome());
			//System.out.println("Altura: "+g.getPessoa(i).getAltura());
			//System.out.println("Idade: "+g.getPessoa(i).getIdade());
			//System.out.println("Massa: "+g.getPessoa(i).getMassa());
			System.out.println("IMC: "+g.getPessoa(i).getIMC());
			System.out.println();


		}
	}
}
