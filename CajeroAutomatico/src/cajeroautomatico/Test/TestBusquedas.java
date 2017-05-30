/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico.Test;

import Datos.Servidor;
import cajeroautomatico.Model.Cuenta;
import cajeroautomatico.Model.Cuentahabiente;
import cajeroautomatico.Model.Transaccion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TestBusquedas {

    
    public static void main(String[] args) {
        Servidor serv = new Servidor();
        Cuenta cuenta;
        try{
            Cuentahabiente usuario = serv.buscarCuentaHabiente(11);
            usuario.setNombre("Jose Luis Arvizu");
            serv.Modificar(usuario);
            usuario = serv.buscarCuentaHabiente(11);
            JOptionPane.showMessageDialog(null, usuario.getNombre());
            System.out.println(usuario.getNombre());
            
            System.out.println("Datos de cuenta\n==============================================================");
            cuenta = serv.buscarCuenta(8);
            System.out.println("Saldo cuenta: " + cuenta.getSaldo());
            cuenta.setSaldo(cuenta.getSaldo() - 500);
            serv.Modificar(cuenta);
            cuenta = serv.buscarCuenta(8);
            System.out.println("Nuevo saldo: " + cuenta.getSaldo());
            
            ArrayList<Transaccion> transacciones = serv.getTransacciones(8);
            System.out.println("Son " + transacciones.size() + " transacciones");
            for(Transaccion transaccion :  transacciones){
                System.out.println("Cuenta: " + transaccion.getIdCuenta() + " cuenta: " + transaccion.getTipo());
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
