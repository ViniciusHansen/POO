package pkg;

public class Main {
    public static void main(String[] args) {
        TrianguloEquilatero te1 = new TrianguloEquilatero();
        te1.setLado(2);
        TrianguloEquilatero te2 = new TrianguloEquilatero();
        te2.setLado(6);
        Losango lo1 = new Losango();
        lo1.setd(2);
        lo1.setD(4);
        Losango lo2 = new Losango();
        lo2.setd(5);
        lo2.setD(8);
        Circulo ci1 = new Circulo();
        ci1.setRaio(2);
        Circulo ci2 = new Circulo();
        ci2.setRaio(8);

        System.out.println(te1);
        System.out.println(te2);
        System.out.println(lo1);
        System.out.println(lo2);
        System.out.println(ci1);
        System.out.println(ci2);
    }
}
