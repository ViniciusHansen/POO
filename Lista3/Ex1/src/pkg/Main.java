package pkg;

public class Main {
    public static void main(String[] args) {
        Animal dog1 = new Cachorro();
        dog1.setNome("Rex");
        Animal dog2 = new Cachorro();
        dog2.setNome("Jack");
        Animal cat1 = new Gato();
        cat1.setNome("Robert");
        Animal cat2 = new Gato();
        cat2.setNome("Tufs");
        Animal bird1 = new Passarinho();
        bird1.setNome("Roger");
        Animal bird2 = new Passarinho();
        bird2.setNome("Bob");
        System.out.println(dog1.emitirSom());
        System.out.println(cat2.emitirSom());
        System.out.println(bird2.emitirSom());
    }

}
