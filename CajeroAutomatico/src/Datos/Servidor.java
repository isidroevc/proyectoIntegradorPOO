package Datos;

import Excepciones.ExcepcionErrorModificacion;
import Excepciones.ExcepionRegistroIncompleto;
import cajeroautomatico.BasesDeDatos.DBDemo;
import cajeroautomatico.Model.Model;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Servidor implements ManejadorDeDatos {
    
    @Override
    public void Modificar(Model modificar) throws ExcepcionErrorModificacion{
           
        Connection cn =DBDemo.getConexion();
        DBDemo.pruebaConexion();
       
        try {
           Statement s = cn.createStatement();
           s.executeUpdate(modificar.getUpdateCommand());
           s.close();
           cn.close();
        } catch (SQLException ex) {
            throw new ExcepcionErrorModificacion("Error en: "+ex.getMessage());
        }
    }   
    @Override
    public void Registro(Model registro) throws ExcepionRegistroIncompleto{
           
        Connection cn =DBDemo.getConexion();
        DBDemo.pruebaConexion();
       
        try {
           Statement s = cn.createStatement();
           s.execute(registro.getInsertCommand());
           s.close();
           cn.close();
        } catch (SQLException ex) {
            throw new ExcepionRegistroIncompleto("Error en: "+ex.getMessage());
        }
         
        
    }
    
}
