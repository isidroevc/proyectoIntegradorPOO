
package cajeroautomatico.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Menu extends JFrame {
    
    JPanel  pantalla;
    JButton Deposito;
    JButton Retiro;
    JButton Aceptar;
    JLabel fondodepantalla;
    JLabel Saldodisponible;
    JLabel CantidadD;
    JLabel CantidadR;
    JTextField DigitosR;
    JTextField DigitosD;
    
    
    
public void mostrar(){
        crear();
        pegar();
        lanzar();
    }
    
    void crear(){
    pantalla  = new JPanel();
    Deposito= new JButton("Depositar");
    Retiro= new JButton("Retirar");
    Aceptar= new JButton("Aceptar");
    fondodepantalla = new JLabel();
    Saldodisponible = new JLabel("Saldo disponible: $");
    DigitosD= new JTextField();
    DigitosR= new JTextField();
    CantidadR = new JLabel("Digite cantidad a retirar:");
    CantidadD = new JLabel("Digite cantidad a depositar:");
    }
    
    void pegar(){
        this.setSize(600,600);
        this.setTitle("Cholo Bank");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        pantalla.setLayout(null);
        pantalla.setBounds(0,0,500,500);
        
        Saldodisponible.setBounds(275, 300, 110, 20);
        Saldodisponible.setVisible(true);
        
        CantidadR.setBounds(260, 330, 150, 20);
        CantidadR.setVisible(false);
        
        CantidadD.setBounds(260, 330, 170, 20);
        CantidadD.setVisible(false);
        
        DigitosD.setBounds(420, 330, 110, 20);
        DigitosD.setVisible(false);
        
        DigitosR.setBounds(400, 330, 110, 20);
        DigitosR.setVisible(false);
       
        Deposito.setBounds(260,330,100,20);
        Deposito.setVisible(true);
        Deposito.setFocusable(false);
        Deposito.addActionListener(new ControladorBoton());
       
        Retiro.setBounds(260,360,100,20);
        Retiro.setVisible(true);
        Retiro.setFocusable(false);
        Retiro.addActionListener(new ControladorBoton());
        
        Aceptar.setBounds(320,360,100,20);
        Aceptar.setVisible(false);
        Aceptar.setFocusable(false);
        Aceptar.addActionListener(new ControladorBoton());
        
        fondodepantalla.setVisible(true);
        fondodepantalla.setBounds(0,0,600,600);
        fondodepantalla.setIcon(new ImageIcon( "src/cajeroautomatico/imagenes/cholobank.jpg"));
        
    }
    void lanzar(){
       
        
        pantalla.add(Saldodisponible);
        pantalla.add(Deposito);
        pantalla.add(Retiro);
        pantalla.add(Aceptar);
        pantalla.add(CantidadR);
        pantalla.add(CantidadD);
        pantalla.add(DigitosR);
        pantalla.add(DigitosD);
        pantalla.add(fondodepantalla);
        this.getContentPane().add(pantalla);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   class ControladorBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
               if (e.getSource() == Deposito) {
                DigitosD.setVisible(true);
                CantidadD.setVisible(true);
                Aceptar.setVisible(true);
                Deposito.setVisible(false);
                Retiro.setVisible(false);
                
                
            } 
                if (e.getSource() == Retiro) {
                DigitosR.setVisible(true);
                CantidadR.setVisible(true);
                Aceptar.setVisible(true);
                Deposito.setVisible(false);
                Retiro.setVisible(false);
                
                
            } 

         
        
        } 
   }
}
