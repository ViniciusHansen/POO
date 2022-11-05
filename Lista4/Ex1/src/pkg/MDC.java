package pkg;

public class MDC implements OperacaoInteira {

    public int mod(int v1, int v2) {
        int p,q;
        q = v1 / v2;
        p = q * v2;
        return v1 - p;
    }

    public int executar(int v1, int v2) {
        int resto;
        while (v2 != 0) {
            resto = mod(v1, v2);
            v1 = v2;
            v2 = resto;
        }
        return v1;
    }
}