/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico.Test;

import cajeroautomatico.Model.Cuenta;
import cajeroautomatico.View.Menu;
public class TestMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu m = new Menu(new Cuenta());
        m.mostrar();
    }
    
}
