package cajeroautomatico.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cuentahabiente extends Model{	       
    private String nombre;		       
    private String direccion;	       
    private String pass;		       
    private Date fechaDeNacimiento;	       
    private long telefono;

    public Cuentahabiente() {
         this.atributosBD = new String[]{
            "nombre",
            "direcion",
            "password",
            "telefono",
            "fechaNacimiento"
        };
        this.tablaBD = "Cuentahabiente";
    }

    public Cuentahabiente(int id, String nomb, String dir, String pass, Date fechaDeNac, long tel) {
        this.atributosBD = new String[]{
            "nombre",
            "direcion",
            "password",
            "telefono",
            "fechaNacimiento"
        };
        this.tablaBD = "Cuentahabiente";
        this.id = id;
        this.nombre = nomb;
        this.direccion = dir;
        this.pass = pass;
        this.fechaDeNacimiento = fechaDeNac;
        this.telefono = tel;
    }
    public Cuentahabiente(String nomb, String dir, String pass, Date fechaDeNac, long tel) {
        this.atributosBD = new String[]{
            "nombre",
            "direccion",
            "nip",
            "telefono",
            "fechaNacimiento"
        };
        this.tablaBD = "Cuentahabiente";
        this.nombre = nomb;
        this.direccion = dir;
        this.pass = pass;
        this.fechaDeNacimiento = fechaDeNac;
        this.telefono = tel;
    }
    

    public void setNombre(String nomb) {
        this.nombre = nomb;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setDireccion(String dir) {
        this.direccion = dir;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String getPass() {
        return pass;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setTelefono(long tel) {
        this.telefono = tel;
    }

    public long getTelefono() {
        return telefono;
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
        command += ") VALUES('"+this.nombre+"', '"+this.pass+"','"+this.direccion+"','"+this.telefono
                +"','"+formatoFecha.format(this.fechaDeNacimiento)+
                "');";
         return command;
    }

    @Override
    public String getUpdateCommand() {
         SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        String command = "UPDATE " + this.tablaBD + " SET nombre= '"+nombre 
                        + "', nip = " + pass 
                        + ", fechanacimiento = '" + formatoFecha.format(fechaDeNacimiento) + "' where id="+id+";" ;
                        
        return command;
    }

    
}
