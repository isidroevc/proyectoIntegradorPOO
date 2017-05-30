/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico.Test;

import Datos.Servidor;
import Excepciones.ExcepcionRegistroIncompleto;
import cajeroautomatico.Model.Cuenta;
import cajeroautomatico.Model.Cuentahabiente;
import cajeroautomatico.Model.Transaccion;
import java.util.Date;

/**
 *
 * @author tharduz
 */
public class TesttInsersiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Servidor servidor = new Servidor();
            Cuentahabiente cuentahabiente = new Cuentahabiente("Juan José Estrada","17742","#303 Los Robles",new Date(),47725349);
            servidor.Registro(cuentahabiente);
            Cuenta cuenta = new Cuenta(cuentahabiente.getId(), 3507, new Date());
            servidor.Registro(cuenta);
            Transaccion transaccion = new Transaccion(cuenta.getId(), 359, "Depósito", new Date());
            servidor.Registro(transaccion);
        }catch(ExcepcionRegistroIncompleto ex){
            System.out.println("Error en: " + ex.getMensaje());
        }
        
    }
    
}
