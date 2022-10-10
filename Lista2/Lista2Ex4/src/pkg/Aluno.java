package pkg;

import java.util.Arrays;

public class Aluno {
    private String nome;
    private int idade;
    private double notas[5];

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double calcularMedia(){
        double somaNotas = 0.0;
        for(double i : notas)
            somaNotas+=i;
        return somaNotas/=5;
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
