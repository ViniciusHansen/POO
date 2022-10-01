package pkg;

import java.util.Arrays;

public class Aluno {
    private String nome;
    private int idade;
    private double notas[5];

    public double calcularMedia(){

    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", notas=" + Arrays.toString(notas) +
                '}';
    }
}
