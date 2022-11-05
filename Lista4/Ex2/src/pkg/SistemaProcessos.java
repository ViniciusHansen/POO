package pkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaProcessos {
    private List<Processo> processos = new ArrayList<Processo>();
    private List<Juiz> juizes = new ArrayList<Juiz>();
    private Random r = new Random();

    public void cadastrarProcesso(Processo p){
        processos.add(p);
    }
    public void cadastrarJuiz(Juiz j){
        juizes.add(j);
    }

    public List<Juiz> getJuizes() {
        return juizes;
    }

    public void distribuirProcessos() throws ProcessoSemJuizException, PilhaCheiaException{
        int rand=0,count=0;
        for( Processo p : processos){
            rand = r.nextInt(juizes.size());
            if (juizes.get(rand).getSizeProcessos() >= juizes.get(rand).getLimite()) {
                count++;
                continue;
            }
            try {
                juizes.get(rand).cadastrarProcesso(p);
                p.setTemJuiz(true);
            } catch (PilhaCheiaException e) {
                throw new PilhaCheiaException("Pilha cheia");
            }
        }
        if(count == juizes.size())
            throw new ProcessoSemJuizException("Processo sobrando");
    }
}
