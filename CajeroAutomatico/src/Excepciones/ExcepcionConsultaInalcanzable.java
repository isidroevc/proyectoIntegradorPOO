/**
 * ExcepcionConsultaInalcanzable.java
 * 
 * Se lanza cada y que una consulta a la base de datos falla.
 * 
 */
package Excepciones;


public class ExcepcionConsultaInalcanzable extends Exception {
    public ExcepcionConsultaInalcanzable  (String msg){
        super(msg);
    }
    
    public String getMensaje(){
        return super.getMessage();
    }
}
