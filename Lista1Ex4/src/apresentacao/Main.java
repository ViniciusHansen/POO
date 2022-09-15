package apresentacao;

import dados.Pessoa;
import dados.Sorteador;

public class Main {
	public static void main(String[] args) {
		Sorteador s = new Sorteador();

		Pessoa p1 = new Pessoa();
		p1.setCpf("234234");
		p1.setNome("asdasdasd");
		s.addPessoa(p1);
		
		Pessoa p2 = new Pessoa();
		p2.setCpf("678678");
		p2.setNome("3256847");
		s.addPessoa(p2);

		Pessoa p3 = new Pessoa();
		p3.setCpf("67asdasdasd8678");
		p3.setNome("325fdsgdfgdfg6847");
		s.addPessoa(p3);
		
		Pessoa escolhido = s.sortearProximo();
		System.out.println(escolhido);
	}
}
