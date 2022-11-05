package pkg;

public class Juiz {
    private String nome;
    private Pilha<Processo> processos;

    public Juiz(int limite){
        processos = new Pilha<Processo>(limite);
    }

    @Override
    public String toString() {
        String s = new String();
        for(Processo p : processos.getElementos()){
            s += p.toString()+"\n";
        }
        return s;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void cadastrarProcesso(Processo p) throws PilhaCheiaException{
        if(processos.getSize() > processos.getLimite())
            throw new PilhaCheiaException("Limite excedido");
        processos.inserir(p);

    }
    public int getLimite(){
        return processos.getLimite();
    }
    public int getSizeProcessos(){
        return processos.getSize();
    }
}
