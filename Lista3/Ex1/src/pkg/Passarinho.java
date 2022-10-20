package pkg;

public class Passarinho extends Animal{
    @Override
    public String emitirSom() {
        return this.getNome()+": piupiu";
    }
}
