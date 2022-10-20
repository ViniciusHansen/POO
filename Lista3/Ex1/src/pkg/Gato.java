package pkg;

public class Gato extends Animal{
    @Override
    public String emitirSom() {
        return this.getNome()+": miau";
    }
}
