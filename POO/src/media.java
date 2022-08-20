import java.util.Scanner;

public class media {

    public static void main(String argv[]) {
        float valores[] = new float[5], temp=0, media=0;
        Scanner scan = new Scanner(System.in); //declara objeto da classe Scanner (Aloca memória)

        for(int i=0;i<valores.length;i++){
            System.out.println("Insira o Valor:");
            valores[i] = Float.valueOf(scan.next());
            //valores[i] = scan.nextFloat();
        }
        scan.close();
        for(int j=0;j<valores.length;j++){
            temp+=valores[j];
        }
        media=temp/5;
        System.out.println("Média:"+media);
    }

}
