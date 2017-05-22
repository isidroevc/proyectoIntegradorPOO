package cajeroautomatico.Model;

import java.util.Date;

public class Cuenta {
    int id;
    int idCuentahabiente;
    float saldo;
    Date fechaCreacion;
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

    
}
