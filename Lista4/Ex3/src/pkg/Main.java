package pkg;

public class Main {
    public static void main(String[] args) {
        SistemaArquivos sist = new SistemaArquivos();

        try {
            sist.criarMusica("Imagine Dragons - Amsterdan","Downloads",267);
            sist.criarDocumento("Lista4_POO","Documentos","asdasdasd");
            sist.criarVideo("Gameplay_minecraft","Downloads",Qualidade.hd_1024p);
            sist.criarDocumento("Notas-udesc","Documentos","0,0,0,0");
            sist.criarMusica("Imagine Dragons - Bones", "Downloads", 238);
        }catch (NomeInvalidoException e){
            System.out.println("Nome Inválido");
        }
        System.out.println(sist.toString());
    }
}
