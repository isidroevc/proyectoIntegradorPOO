/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico.Test;

import cajeroautomatico.Model.Cuenta;
import java.util.Date;

/**
 *
 * @author tharduz
 */
public class TestCuenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta c = new Cuenta(1,1,2500,new Date());
        System.out.println(c.getInsertCommand());
    }
    
}
