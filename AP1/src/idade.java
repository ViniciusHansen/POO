import java.util.Scanner;

public class idade {
	
	public static void main(String argv[]) {
		String pessoas[] = new String[5];
        int idade[] = new int[5], aux=0;
        String aux2;
        Scanner scan = new Scanner(System.in); //declara objeto da classe Scanner (Aloca memória)

        for(int i=0;i<pessoas.length;i++){
            System.out.println("Insira o nome da pessoa:");
            pessoas[i] = scan.next();
            System.out.println("Insira a idade da pessoa:");
            idade[i] = scan.nextInt();
        }
        scan.close();
		for(int j=0;j<pessoas.length;j++) {
			for(int k=0;k<(pessoas.length)-1;k++) {
				if (idade[k] < idade[k + 1]) {
					aux = idade[k];
					idade[k] = idade[k + 1];
					idade[k + 1] = aux;
					
					aux2 = pessoas[k];
					pessoas[k] = pessoas[k+1];
					pessoas[k+1] = aux2;
				}
			}
		}
		for(int i=0;i<pessoas.length;i++) {
			System.out.println(pessoas[i]+": "+idade[i]+" anos");
		}
		
	}
}
