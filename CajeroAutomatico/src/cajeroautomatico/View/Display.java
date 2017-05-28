
package cajeroautomatico.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Display extends JFrame {
  
    JPanel  pantalla;
    JButton confirmar;
    JLabel sesionfoto;
    JLabel fondodepantalla;
    JLabel cuenta;
    JLabel nip;
    JTextField ingresarc;
    JTextField ingresarn;
    
    
public void mostrar(){
        crear();
        pegar();
        lanzar();
    }
    
    void crear(){
    pantalla  = new JPanel();
    confirmar= new JButton("Aceptar");
    fondodepantalla = new JLabel();
    cuenta = new JLabel("Cuenta:");
    nip = new JLabel("NIP:");
    sesionfoto = new JLabel();
    ingresarc = new JTextField();
    ingresarn = new JTextField();
    }
    
    void pegar(){
        this.setSize(600,600);
        this.setTitle("Cholo Bank");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        pantalla.setLayout(null);
        pantalla.setBounds(0,0,500,500);
        
        cuenta.setBounds(300, 340, 110, 20);
        cuenta.setVisible(true);
        nip.setBounds(320, 370, 110, 20);
        nip.setVisible(true);
        
        ingresarc.setBounds(350,340,150,20);
        ingresarn.setBounds(350,370,150,20);
        ingresarc.setVisible(true);
        ingresarn.setVisible(true);
        
        confirmar.setBounds(372,400,100,20);
        confirmar.setVisible(true);
        confirmar.setFocusable(false);
        confirmar.addActionListener(new ControladorBoton());
        
        sesionfoto.setBounds(200, 300, 115, 115);
        sesionfoto.setIcon(new ImageIcon( "src/cajeroautomatico/imagenes/sesionfoto.png"));
        sesionfoto.setVisible(true);
        
        
        fondodepantalla.setVisible(true);
        fondodepantalla.setBounds(0,0,600,600);
        fondodepantalla.setIcon(new ImageIcon( "src/cajeroautomatico/imagenes/cholobank.jpg"));
        
    }
    void lanzar(){
       
        
        pantalla.add(cuenta);
        pantalla.add(nip);
        pantalla.add(sesionfoto);
        pantalla.add(confirmar);
        pantalla.add(ingresarc);
        pantalla.add(ingresarn);
        pantalla.add(fondodepantalla);
        this.getContentPane().add(pantalla);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   class ControladorBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
               if (e.getSource() == confirmar) {
                
                
                
                
                
            } 

         
        
        } 
   }
   
}

