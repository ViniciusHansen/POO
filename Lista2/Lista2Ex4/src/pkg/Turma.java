package pkg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Turma {
    private Scanner s = new Scanner(System.in);
    private List<Aluno> a = new ArrayList<Aluno>();

    public Aluno cadastrarAluno(){
        Aluno temp = new Aluno();
        System.out.println("Nome:");
        temp.setNome(s.next());
        System.out.println("Idade:");
        temp.setIdade(Integer.valueOf(s.next()));
        System.out.println("Notas[5]:");
        double notas[5];
        for(int i=0;i<5;i++)
            notas[i]=Double.valueOf(s.next());
        temp.setNotas(notas);
        return temp;
    }

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
    public List<Equipe<Aluno>> separarEmEquipes(List<Aluno> alunos){
        List<Equipe<Aluno>> listaFinal = new LinkedList<Equipe<Aluno>>();
        List<Aluno> al = alunos;
        int qtdAlunos = al.size();
        while(qtdAlunos > 4){
            Equipe<Aluno> team = new Equipe<Aluno>();
            List<Aluno> temp = new ArrayList<Aluno>();
            temp.add(al.get(0));
            al.remove(0);
            temp.add(al.get(1));
            al.remove(1);
            temp.add(al.get(qtdAlunos));
            al.remove(qtdAlunos);
            temp.add(al.get(qtdAlunos-1));
            al.remove(qtdAlunos-1);
            team.setAlunos(temp);
            team.setNome(s.next());
            listaFinal.add(team);
        }
        return listaFinal;
    }

    public List<Aluno> getA() {
        return a;
    }

    public static void main(String[] args) {
        Turma main = new Turma();

        main.adicionarAluno(main.cadastrarAluno());
        main.ordenaAlunosPorMedia();
        System.out.println(main.separarEmEquipes(main.getA()));


    }
}
