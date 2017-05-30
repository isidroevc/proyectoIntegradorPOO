package Datos;

import Excepciones.ExcepcionErrorModificacion;
import Excepciones.ExcepcionRegistroIncompleto;
import cajeroautomatico.BasesDeDatos.DBDemo;
import cajeroautomatico.Model.Model;
import java.sql.Connection;
import java.sql.ResultSet;
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
    public void Registro(Model registro) throws ExcepcionRegistroIncompleto{
           
        Connection cn =DBDemo.getConexion();
        DBDemo.pruebaConexion();
        ResultSet setResultados = null;
        try {
           Statement s = cn.createStatement();
           s.execute(registro.getInsertCommand(),Statement.RETURN_GENERATED_KEYS);
           setResultados = s.getGeneratedKeys();
           setResultados.next();
           registro.setId(setResultados.getInt(1));
           setResultados.close();
           s.close();
           cn.close();
        } catch (SQLException ex) {
            throw new ExcepcionRegistroIncompleto("Error en: "+ex.getMessage());
        }
         
        
    }
    
}
