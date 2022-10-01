package classes;

public class Main {
	
	public static void main(String[] args) {
		Revenda r1 = new Revenda();
		Revenda r2 = new Revenda("Revenda Central");
		
		r1.setCnpj("11111");
		r1.setNome("Revenda Leste");
		r2.setCnpj("11112");
		
		System.out.println("Revendas:");
		System.out.println(r1.getNome()+" "+r1.getCnpj());
		System.out.println(r2.getNome()+" "+r2.getCnpj());
		
		
		System.out.println();
		
		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente("05346836563");
		
		c1.setNome("fulano");
		c1.setCpf("78924365902456");
		c2.setNome("adalberto");
		
		System.out.println("Clientes: ");
		System.out.println(c1.getNome() +" " + c1.getCpf());
		System.out.println(c2.getNome()+" "+c2.getCpf());
	
		System.out.println();
		
		Carro ca1 = new Carro();
		Carro ca2 = new Carro("BWE-0374");
		
		ca1.setCor("Azul");
		ca1.setPlaca("LEN-0346");
		ca2.setCor("Branco");
		
		System.out.println("Carros: ");
		System.out.println(ca1.getPlaca()+" "+ca1.getCor());
		System.out.println(ca2.getPlaca()+" "+ca2.getCor());

		System.out.println();
		
		Moto m1 = new Moto();
		Moto m2 = new Moto("BBE-6384");
		
		m1.setCor("Preto");
		m1.setPlaca("LOG-0346");
		m2.setCor("Branco");
		
		System.out.println("Motos: ");
		System.out.println(m1.getPlaca()+" "+m1.getCor());
		System.out.println(m2.getPlaca()+" "+m2.getCor());

		System.out.println();
		
		Aluguel a1 = new Aluguel();
		Aluguel a2 = new Aluguel(12);
		
		a1.setCliente(c1);
		a1.setCarro(ca1);
		a1.setCodigoAluguel(15);
		
		a2.setCliente(c2);
		a2.setCarro(ca2);
		
		System.out.println("Alugueis:");
		System.out.println(a1.getCliente().getCpf()+" "+a1.getCarro().getPlaca());
		System.out.println(a2.getCliente().getCpf()+" "+a2.getCarro().getPlaca());

	}
}
