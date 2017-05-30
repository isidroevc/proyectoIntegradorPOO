package cajeroautomatico.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaccion extends Model{
    private int id;				
    private int idCuenta;			
    private float monto;
    private String tipo;
    private Date fecha;
    public Transaccion(){
        
    }
    public Transaccion(int id, int idCuenta, float monto, String tipo, Date fecha){
        this.atributosBD = new String[]{
            "id",
            "Cuenta_id",
            "monto",
            "tipo","fecha"
        };
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

     @Override
    public String getInsertCommand() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        String command = "INSERT INTO Transacciones " + " (";
        for (int i = 0, c = this.atributosBD.length; i < c; i++) {
            command += this.atributosBD[i];
            if (i < c - 1) {
                command += ", ";
            }
        }
        command += ") VALUES(" 
                + this.id
                + ", " 
                + this.idCuenta + 
                ", " + this.monto 
                + ", '"+ this.tipo  
                + "', '"
                + formatoFecha.format(this.fecha) + "');";
        return command;
    }
    @Override
    public String getUpdateCommand() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        
        String command="UPDATE Transacciones set monto="+this.monto+", tipo='"+this.tipo+"', fecha='"+formatoFecha.format(this.fecha)
                +"' where id="+this.id+";";
        
        return command;
    }


    
}
