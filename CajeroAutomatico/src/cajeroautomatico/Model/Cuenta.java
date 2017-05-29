package cajeroautomatico.Model;

import java.util.Date;

public class Cuenta extends Model{
    private int id;
    private int idCuentahabiente;
    private float saldo;
    private Date fechaCreacion;
    public Cuenta(){
        
    }
    public Cuenta(int id, int idCuentaHabiente, float saldo, Date fechaCreacion){
        this.id=id;
        this.idCuentahabiente=idCuentaHabiente;
        this.saldo=saldo;
        this.fechaCreacion=fechaCreacion;
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
        String command = "INTERT INTO " + this.tablaBD + "(";
        for(int i = 0, c = this.atributosBD.length; i < c; i++){
            
        }
    }

    @Override
    public String getUpdateCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
