package pkg;

import java.util.ArrayList;
import java.util.List;

public class Equipe<T> {
    private String nome;

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    private List<Aluno> alunos = new ArrayList<Aluno>;

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
