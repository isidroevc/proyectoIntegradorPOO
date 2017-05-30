package cajeroautomatico.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cuenta extends Model {
    private int idCuentahabiente;
    private float saldo;
    private Date fechaCreacion;
    
    public Cuenta() {
        this.atributosBD = new String[]{
            "idCuentahabiente",
            "saldo",
            "fechaCreacion"
        };
        this.tablaBD = "Cuenta";
    }

    public Cuenta(int id, int idCuentaHabiente, float saldo, Date fechaCreacion) {
        this.atributosBD = new String[]{
            "idCuentahabiente",
            "saldo",
            "fechaCreacion"
        };
        this.tablaBD = "Cuenta";
        this.id = id;
        this.idCuentahabiente = idCuentaHabiente;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
    }
    public Cuenta(int idCuentaHabiente, float saldo, Date fechaCreacion) {
        this.atributosBD = new String[]{
            "idCuentahabiente",
            "saldo",
            "fechaCreacion"
        };
        this.tablaBD = "Cuenta";
       
        this.idCuentahabiente = idCuentaHabiente;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
    }
    

    public void setIdCuentahabiente(int idCuentahabiente) {
        this.idCuentahabiente = idCuentahabiente;
    }

    public int getIdCuentahabiente() {
        return idCuentahabiente;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public String getInsertCommand() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        String command = "INSERT INTO " + this.tablaBD + " (";
        for (int i = 0, c = this.atributosBD.length; i < c; i++) {
            command += this.atributosBD[i];
            if (i < c - 1) {
                command += ", ";
            }
        }
        command += ") VALUES('" 
                + this.idCuentahabiente + 
                "', '" + this.saldo 
                + "', '" 
                + formatoFecha.format(this.fechaCreacion) + "');";
        return command;
    }

    @Override
    public String getUpdateCommand() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        String command = "UPDATE " + this.tablaBD + " SET idCuentahabiente = '" + idCuentahabiente + "', saldo = '" + saldo 
                        + "', fechaCreacion = '" + formatoFecha.format(fechaCreacion) + "' where id = '" + id 
                        + "'; " ;
                        
        return command;
    }

}
