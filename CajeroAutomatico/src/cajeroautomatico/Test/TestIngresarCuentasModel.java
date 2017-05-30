package cajeroautomatico.Test;

import Datos.ManejadorDeDatos;
import Datos.Servidor;
import cajeroautomatico.Model.Model;
import cajeroautomatico.Model.Transaccion;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class TestIngresarCuentasModel {

    public static void main(String[] args) {
        int id=Integer.parseInt(JOptionPane.showInputDialog("ingresa id")); 
        int idCuenta=id; 
        float monto=Float.parseFloat(JOptionPane.showInputDialog("monto a ingresar")); 
        String tipo=JOptionPane.showInputDialog("Tipo de transaccion "); 
        
        Date fecha=new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        formatoFecha.format(fecha);
        Transaccion tr=new Transaccion(id,idCuenta,monto,tipo,fecha);
        
        try{
        Servidor serv=new Servidor();
        serv.Registro(tr);
        }catch(Exception e){
            
        }
    }
    
}
