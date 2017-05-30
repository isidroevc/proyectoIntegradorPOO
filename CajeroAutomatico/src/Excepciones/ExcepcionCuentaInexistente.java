
package Excepciones;

public class ExcepcionCuentaInexistente extends Exception{
    public ExcepcionCuentaInexistente(String msg){
        super(msg);
    }
    
    public String getMensaje(){
        return super.getMessage();
    }
}
