package cajeroautomatico.Model;

import java.util.Date;

public class Cuentahabiente {
    private int id;			       
    private String nombre;		       
    private String direccion;	       
    private String pass;		       
    private Date fechaDeNacimiento;	       
    private long telefono;

    public Cuentahabiente() {
    }

    public Cuentahabiente(int id, String nomb, String dir, String pass, Date fechaDeNac, long tel) {
        this.id = id;
        this.nombre = nomb;
        this.direccion = dir;
        this.pass = pass;
        this.fechaDeNacimiento = fechaDeNac;
        this.telefono = tel;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
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

    
}
