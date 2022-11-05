package pkg;

public class Multiplicacao extends Soma implements OperacaoInteira{
    public int executar(int v1, int v2) {
        int mult=0;
            for(int i=0;i<v2;i++)
                mult+=v1;
        return mult;
    }
}
