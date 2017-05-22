package cajeroautomatico.Model;

import java.util.Date;

public class Transaccion {
    int id;				
    int idCuenta;			
    float monto;
    String tipo;
    Date fecha;
    public Transaccion(){
        
    }
    public Transaccion(int id, int idCuenta, float monto, String tipo, Date fecha){
        this.id=id;
        this.idCuenta=idCuenta;
        this.monto=monto;
        this.tipo=tipo;
        this.fecha=fecha;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getMonto() {
        return monto;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    
}
