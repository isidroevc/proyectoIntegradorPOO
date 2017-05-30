package cajeroautomatico.Test;

import cajeroautomatico.Model.Transaccion;
import java.util.Date;

public class Pruebasssssss {

    public static void main(String[] args) {
        
        Transaccion tr=new Transaccion(1,1,10f,"Retiro",new Date());
        System.out.println(tr.getInsertCommand());
        System.out.println(tr.getUpdateCommand());
    }
    
}
