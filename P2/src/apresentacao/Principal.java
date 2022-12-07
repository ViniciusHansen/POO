package apresentacao;

import dados.*;
import negocio.GerenciadorFormasGeometricas;

import java.util.Scanner;

public class Principal {
    public void menu() {
        System.out.println("Menu\n"
                + "1) cadastrar Quadradro\n"
                + "2) cadastrar Retangulo\n"
                + "3) cadastrar Circulo\n"
                + "4) cadastrar Triangulo\n"
                + "5) Exibir Area e Perimetro de uma Forma Geométrica\n"
                + "0) sair");
    }
    public void imprimeAreaPerimetro(FormaGeometrica f){
        System.out.println("Area: "+ f.calculaArea()+" | Perimetro: "+f.calculaPerimetro());
    }

    public static void main(String[] args) {
        int escolha;
        GerenciadorFormasGeometricas sist = new GerenciadorFormasGeometricas();
        Principal main = new Principal();
        Scanner s = new Scanner(System.in);
        do{
            main.menu();
            escolha = Integer.valueOf(s.next());
            switch (escolha){
                case 1:
                    System.out.println("lado:");
                    int lado = Integer.valueOf(s.next());
                    System.out.println("x:");
                    int x = Integer.valueOf(s.next());
                    System.out.println("y:");
                    int y = Integer.valueOf(s.next());
                    Quadrado quadrado = new Quadrado(x,y,lado);
                    sist.inserirQuadrado(quadrado);
                    System.out.println("Quadrado criado");
                    break;
                case 2:
                    System.out.println("base:");
                    int base = Integer.valueOf(s.next());
                    System.out.println("altura:");
                    int altura = Integer.valueOf(s.next());
                    System.out.println("x:");
                    x = Integer.valueOf(s.next());
                    System.out.println("y:");
                    y = Integer.valueOf(s.next());
                    Retangulo retangulo = new Retangulo(x,y,base,altura);
                    sist.inserirRetangulo(retangulo);
                    System.out.println("Retangulo criado");
                    break;
                case 3:
                    System.out.println("raio:");
                    int raio = Integer.valueOf(s.next());
                    Circulo circulo = new Circulo(raio);
                    sist.inserirCirculo(circulo);
                    System.out.println("Circulo criado");
                    break;
                case 4:
                    System.out.println("lado:");
                    int ladoTriangulo = Integer.valueOf(s.next());
                    System.out.println("x:");
                    x = Integer.valueOf(s.next());
                    System.out.println("y:");
                    y = Integer.valueOf(s.next());
                    TrianguloEquilatero triangulo = new TrianguloEquilatero(x,y,ladoTriangulo);
                    sist.inserirTriangulo(triangulo);
                    System.out.println("Triangulo criado");
                    break;
                case 5:
                    System.out.println("Escolha pelo indice:");
                    int i = 0;
                    for (FormaGeometrica fg: sist.getL()){
                        System.out.println(i +" " +fg);
                        i++;
                    }
                    int escolha2 = Integer.valueOf(s.next());
                    main.imprimeAreaPerimetro(sist.getL().get(escolha2));
                    break;
            }
        } while(escolha!= 0);

    }
}
