package cajeroautomatico.Test;

import cajeroautomatico.Model.Cuentahabiente;
import cajeroautomatico.Model.Transaccion;
import java.util.Date;

public class Pruebasssssss {

    public static void main(String[] args) {
        
        Cuentahabiente tr=new Cuentahabiente(3,"cholo","mi canton","1234k",new Date(),273648236);
        System.out.println(tr.getInsertCommand());
        System.out.println(tr.getUpdateCommand());
    }
    
}
