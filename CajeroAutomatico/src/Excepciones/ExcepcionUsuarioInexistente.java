/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author tharduz
 */
public class ExcepcionUsuarioInexistente extends Exception{
    public ExcepcionUsuarioInexistente(String msg){
        super(msg);
    }
    
    public String getMensaje(){
        return super.getMessage();
    }
}
