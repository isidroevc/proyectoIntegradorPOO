package Datos;

import Excepciones.ExcepcionCeroTransacciones;
import Excepciones.ExcepcionConsultaInalcanzable;
import Excepciones.ExcepcionCuentaInexistente;
import Excepciones.ExcepcionErrorModificacion;
import Excepciones.ExcepcionRegistroIncompleto;
import Excepciones.ExcepcionUsuarioInexistente;
import cajeroautomatico.BasesDeDatos.DBDemo;
import cajeroautomatico.Model.Cuenta;
import cajeroautomatico.Model.Cuentahabiente;
import cajeroautomatico.Model.Model;
import cajeroautomatico.Model.Transaccion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Servidor implements ManejadorDeDatos {

    @Override
    public void Modificar(Model modificar) throws ExcepcionErrorModificacion {

        Connection cn = DBDemo.getConexion();
        DBDemo.pruebaConexion();

        try {
            Statement s = cn.createStatement();
            s.executeUpdate(modificar.getUpdateCommand());
            s.close();
            cn.close();
        } catch (SQLException ex) {
            throw new ExcepcionErrorModificacion("Error en: " + ex.getMessage());
        }
    }

    @Override
    public void Registro(Model registro) throws ExcepcionRegistroIncompleto {

        Connection cn = DBDemo.getConexion();
        DBDemo.pruebaConexion();
        ResultSet setResultados = null;
        try {
            Statement s = cn.createStatement();
            s.execute(registro.getInsertCommand(), Statement.RETURN_GENERATED_KEYS);
            setResultados = s.getGeneratedKeys();
            setResultados.next();
            registro.setId(setResultados.getInt(1));
            setResultados.close();
            s.close();
            cn.close();
        } catch (SQLException ex) {
            throw new ExcepcionRegistroIncompleto("Error en: " + ex.getMessage());
        }

    }

    public Cuentahabiente buscarCuentaHabiente(int id) throws ExcepcionConsultaInalcanzable,
            ExcepcionUsuarioInexistente {
        Connection cn = DBDemo.getConexion();
        DBDemo.pruebaConexion();
        ResultSet rs = null;
        Cuentahabiente usuario;
        SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");
        try {
            Statement s = cn.createStatement();
            s.executeQuery("SELECT * FROM Cuentahabiente WHERE id = " + id);
            rs = s.getResultSet();
            if (rs.next()) {
                usuario = new Cuentahabiente(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("nip"),
                        ff.parse(rs.getString("fechaNacimiento")),
                        rs.getLong("telefono"));
            } else {
                throw new ExcepcionUsuarioInexistente("Error, no existe la cuenta");
            }
            rs.close();
            s.close();
            cn.close();
        } catch (SQLException ex) {
            throw new ExcepcionConsultaInalcanzable("Error intentando obtener datos para usuario");
        } catch (ParseException ex) {
            throw new ExcepcionConsultaInalcanzable("Error intentando obtener datos para usuario");
        }
        return usuario;
    }

    public Cuenta buscarCuenta(int id) throws ExcepcionCuentaInexistente, ExcepcionConsultaInalcanzable {
        Connection cn = DBDemo.getConexion();
        DBDemo.pruebaConexion();
        ResultSet rs = null;
        Cuenta cuenta;
        SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");
        try {
            Statement s = cn.createStatement();
            s.executeQuery("SELECT * FROM Cuenta WHERE id = " + id);
            rs = s.getResultSet();
            if (rs.next()) {
                cuenta = new Cuenta(rs.getInt("id"),
                        rs.getInt("idCuentahabiente"),
                        rs.getFloat("saldo"),
                        ff.parse(rs.getString("fechaCreacion")));
            } else {
                throw new ExcepcionCuentaInexistente("Error, no existe la cuenta");
            }
            rs.close();
            s.close();
            cn.close();
        } catch (SQLException ex) {
            throw new ExcepcionConsultaInalcanzable("Error intentando obtener datos para cuenta");
        } catch (ParseException ex) {
            throw new ExcepcionConsultaInalcanzable("Error intentando obtener datos para cuenta");
        }
        return cuenta;
    }

    public ArrayList<Transaccion> getTransacciones(int cuenta_id) throws ExcepcionConsultaInalcanzable, ExcepcionCeroTransacciones {
        ArrayList<Transaccion> transacciones = new ArrayList<>();
        Connection cn = DBDemo.getConexion();
        DBDemo.pruebaConexion();
        ResultSet rs = null;
        SimpleDateFormat ff = new SimpleDateFormat("YYYY-MM-dd");
        try {
            Statement s = cn.createStatement();
            s.executeQuery("SELECT * FROM Transacciones WHERE Cuenta_id = " + cuenta_id);
            rs = s.getResultSet();
            while(rs.next()){
                transacciones.add(new Transaccion(rs.getInt("id"),
                                            rs.getInt("Cuenta_id"),
                                            rs.getFloat("monto"),
                                            rs.getString("tipo"),
                                            ff.parse(rs.getString("fecha"))));
            }
            if (!(transacciones.size() > 0)) {

                throw new ExcepcionCeroTransacciones("No hay transacciones para esta cuenta");
            }
            rs.close();
            s.close();
            cn.close();
        } catch (SQLException ex) {
            throw new ExcepcionConsultaInalcanzable("Error intentando obtener datos para transaccion");
        } catch (ParseException ex) {
            throw new ExcepcionConsultaInalcanzable("Error intentando obtener datos para transaccion");
        }
        return transacciones;
    }
}
