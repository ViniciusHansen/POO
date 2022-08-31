import java.util.Random;
import java.util.random.*;
package pooLista1;

public class Main {
	
	public static void main(String[] args) {
		Revenda r1 = new Revenda();
		Revenda r2 = new Revenda("Revenda Central");
		
		r1.setCnpj("11111");
		r2.setCnpj("11112");
		
		
		if(r1.equals(r2)) {
			System.out.println("São iguais");
		}
		else {
			System.out.println("São diferentes");
		}
		
		Random r = new Random();
		
		//4) sorteador.getPessoas[r.nextInt(sorteador.getPessoas.length)];
	}
}
