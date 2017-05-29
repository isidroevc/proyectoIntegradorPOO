package Excepciones;

public class CifraParaDepositoNoValidoException extends Exception{
    public CifraParaDepositoNoValidoException(String msg){
        super(msg);
    }
    
    public String getMensaje(){
        return super.getMessage();
    }
    
}
