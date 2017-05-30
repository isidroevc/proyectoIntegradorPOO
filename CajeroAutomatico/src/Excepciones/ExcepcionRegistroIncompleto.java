/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

public class ExcepcionRegistroIncompleto extends Exception{
    public ExcepcionRegistroIncompleto(String msg){
        super(msg);
    }
    
    public String getMensaje(){
        return super.getMessage();
    }
}
