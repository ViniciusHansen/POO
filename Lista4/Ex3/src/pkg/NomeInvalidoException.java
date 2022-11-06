package pkg;

public class NomeInvalidoException extends Exception{
    public NomeInvalidoException(){

    }
    public NomeInvalidoException(String msg){
        super(msg);
    }
}
