package pkg;

public class Cachorro extends Animal{
    @Override
    public String emitirSom() {
        return this.getNome()+": auau";
    }
}
