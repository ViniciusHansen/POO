package pkg;

public class Processo {
    private int id;
    private String nome;
    private boolean temJuiz;

    public Processo(){

    }

    public boolean TemJuiz() {
        return temJuiz;
    }

    public void setTemJuiz(boolean temJuiz) {
        this.temJuiz = temJuiz;
    }

    @Override
    public String toString() {
        return "Processo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Processo(int id){
        this.id=id;
    }
}
