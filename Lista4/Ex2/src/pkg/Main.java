package pkg;

public class Main {
    public static void main(String[] args) {
        SistemaProcessos sist = new SistemaProcessos();
        Juiz j1 = new Juiz(5);
        j1.setNome("Luiz");
        Juiz j2 = new Juiz(5);
        j2.setNome("Robert");
        Juiz j3 = new Juiz(5);
        j3.setNome("João");

        sist.cadastrarJuiz(j1);
        sist.cadastrarJuiz(j2);
        sist.cadastrarJuiz(j3);

        Processo p1 = new Processo(1);
        Processo p2 = new Processo(2);
        Processo p3 = new Processo(3);
        Processo p4 = new Processo(4);
        Processo p5 = new Processo(5);
        Processo p6 = new Processo(6);
        Processo p7 = new Processo(7);
        Processo p8 = new Processo(8);
        Processo p9 = new Processo(9);
        Processo p10 = new Processo(10);
        Processo p11 = new Processo(11);
        Processo p12 = new Processo(12);
        Processo p13 = new Processo(13);
        Processo p14 = new Processo(14);
        Processo p15 = new Processo(15);
        Processo p16 = new Processo(16);
        Processo p17 = new Processo(17);
        Processo p18 = new Processo(18);

        sist.cadastrarProcesso(p1);
        sist.cadastrarProcesso(p2);
        sist.cadastrarProcesso(p3);
        sist.cadastrarProcesso(p4);
        sist.cadastrarProcesso(p5);
        sist.cadastrarProcesso(p6);
        sist.cadastrarProcesso(p7);
        sist.cadastrarProcesso(p8);
        sist.cadastrarProcesso(p9);
        sist.cadastrarProcesso(p10);
        sist.cadastrarProcesso(p11);
        sist.cadastrarProcesso(p12);
        sist.cadastrarProcesso(p13);
        sist.cadastrarProcesso(p14);
        sist.cadastrarProcesso(p15);
        sist.cadastrarProcesso(p16);
        sist.cadastrarProcesso(p17);
        sist.cadastrarProcesso(p18);

        try {
            sist.distribuirProcessos();
        }catch (ProcessoSemJuizException ps){
            System.out.println("Processo sobrando");
        }catch (PilhaCheiaException pc){
            System.out.println("Tentou adicionar elem em uma pilha cheia");
        }
        for(Juiz j : sist.getJuizes()) {
            System.out.println(j.getNome());
            System.out.println(j);
        }
    }
}
