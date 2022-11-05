package pkg;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        List<OperacaoInteira> l = new LinkedList<OperacaoInteira>();
        Soma soma = new Soma();
        Multiplicacao mult = new Multiplicacao();
        Mod mod = new Mod();
        MDC mdc = new MDC();
        l.add(soma);
        l.add(mult);
        l.add(mdc);
        l.add(mod);
        int a = r.nextInt(100);
        int b = r.nextInt(100);
        System.out.println(a);
        System.out.println(b);
        for(OperacaoInteira op : l)
            System.out.println(op.executar(a,b));
    }
}
