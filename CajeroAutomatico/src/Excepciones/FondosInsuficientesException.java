package Excepciones;

public class FondosInsuficientesException extends Exception{
    public FondosInsuficientesException(String msg){
        super(msg);
    }
    
    public String getMensaje(){
        return super.getMessage();
    }
    
}