package cajeroautomatico.Test;
import cajeroautomatico.BasesDeDatos.DBDemo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class IngresarCuentas {

    public static void main(String[] args) {
        String nombre,direccion,password, fecha;
        long telefono;
        String sql="";
        nombre=JOptionPane.showInputDialog("Ingresa el nombre");
        direccion=JOptionPane.showInputDialog("Ingresa la direccion");
        password=JOptionPane.showInputDialog("Ingresa la contraseÃ±a");
        telefono=Long.parseLong(JOptionPane.showInputDialog("Ingresa el telefono"));
        fecha=JOptionPane.showInputDialog("Fecha de nacimiento AAAA/MM/DD");
       
        Connection cn =DBDemo.getConexion();
        DBDemo.pruebaConexion();
       
       sql="INSERT INTO Cuentahabiente (nombre,direccion,nip,fechaNacimiento,telefono) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement psd=cn.prepareStatement(sql);
            psd.setString(1,nombre);
            psd.setString(2,direccion);
            psd.setString(3,password);
            psd.setString(4,fecha);
            psd.setString(5,String.valueOf(telefono));
            int n=psd.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null,"Registro Guardado con Exito");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
            
    }
    
}
