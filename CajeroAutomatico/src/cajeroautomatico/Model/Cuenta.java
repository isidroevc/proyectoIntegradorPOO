package cajeroautomatico.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cuenta extends Model {

    private int id;
    private int idCuentahabiente;
    private float saldo;
    private Date fechaCreacion;
    
    public Cuenta() {
        this.atributosBD = new String[]{
            "id",
            "idCuentahabiente",
            "saldo",
            "fechaCreacion"
        };
        this.tablaBD = "Cuenta";
    }

    public Cuenta(int id, int idCuentaHabiente, float saldo, Date fechaCreacion) {
        this.atributosBD = new String[]{
            "id",
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
        String command = "INTERT INTO " + this.tablaBD + " (";
        for (int i = 0, c = this.atributosBD.length; i < c; i++) {
            command += this.atributosBD[i];
            if (i < c - 1) {
                command += ", ";
            }
        }
        command += ") VALUES(" 
                + this.id
                + ", " 
                + this.idCuentahabiente + 
                ", " + this.saldo 
                + ", " 
                + formatoFecha.format(this.fechaCreacion) + ")";
        return command;
    }

    @Override
    public String getUpdateCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
