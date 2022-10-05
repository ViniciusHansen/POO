package pkg;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private List<Aluno> a = new ArrayList<Aluno>();

    public void adicionarAluno(Aluno aluno){
        a.add(aluno);
    }
    private void ordenaAlunosPorMedia(){
        for (int i = 0; i < a.size(); i++)
            for (int j = 0; j < a.size()-1; j++)
                if (a.get(j).calcularMedia() > a.get(j+1).calcularMedia()) {
                    Aluno temp = a.get(j);
                    a.set(j,a.get(j+1));
                    a.set(j+1,temp);
                }
    }
    public List<Equipe<Aluno>> separarEmEquipes(){
        //o método sepa-
        //rarEmEquipes(), que retorna uma lista de equipes contendo 3 ou 4 alunos, estes agrupa-
        //dos levando em consideração a média. Agrupe os alunos pegando um ou dois elementos do
        //começo da lista ordenada por média e um ou dois alunos do final da lista
    }
}
