
package cajeroautomatico.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Display {
  
    JFrame  ventana;
    JPanel  pantalla;
    JButton iniciarsesion;
    JButton registrar;
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
    ventana   = new JFrame();
    pantalla  = new JPanel();
    iniciarsesion = new JButton("Iniciar Sesion");
    registrar= new JButton("Registrarse");
    confirmar= new JButton("Aceptar");
    fondodepantalla = new JLabel();
    cuenta = new JLabel("Cuenta:");
    nip = new JLabel("NIP:");
    sesionfoto = new JLabel();
    ingresarc = new JTextField();
    ingresarn = new JTextField();
    }
    
    void pegar(){
        ventana.setSize(600,600);
        ventana.setTitle("Cholo Bank");
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        
        pantalla.setLayout(null);
        pantalla.setBounds(0,0,500,500);
        
        iniciarsesion.setBounds(290,350,140,20);
        iniciarsesion.setVisible(true);
        iniciarsesion.setFocusable(false);
        iniciarsesion.addActionListener(new ControladorBoton());
        
        cuenta.setBounds(300, 340, 110, 20);
        cuenta.setVisible(false);
        nip.setBounds(320, 370, 110, 20);
        nip.setVisible(false);
        
        ingresarc.setBounds(350,340,150,20);
        ingresarn.setBounds(350,370,150,20);
        ingresarc.setVisible(false);
        ingresarn.setVisible(false);
       
        registrar.setBounds(303,380,110,20);
        registrar.setVisible(true);
        registrar.setFocusable(false);
        registrar.addActionListener(new ControladorBoton());
        
        confirmar.setBounds(372,400,100,20);
        confirmar.setVisible(false);
        confirmar.setFocusable(false);
        confirmar.addActionListener(new ControladorBoton());
        
        sesionfoto.setBounds(200, 300, 115, 115);
        sesionfoto.setIcon(new ImageIcon( "src/cajeroautomatico/imagenes/sesionfoto.png"));
        sesionfoto.setVisible(false);
        
        fondodepantalla.setVisible(true);
        fondodepantalla.setBounds(0,0,600,600);
        fondodepantalla.setIcon(new ImageIcon( "src/cajeroautomatico/imagenes/cholobank.jpg"));
        
    }
    void lanzar(){
       
        pantalla.add(iniciarsesion);
        pantalla.add(registrar);
        pantalla.add(cuenta);
        pantalla.add(nip);
        pantalla.add(sesionfoto);
        pantalla.add(fondodepantalla);
        pantalla.add(confirmar);
        pantalla.add(ingresarc);
        pantalla.add(ingresarn);
        
        ventana.getContentPane().add(pantalla);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   class ControladorBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
               if (e.getSource() == iniciarsesion) {
                iniciarsesion.setVisible(false);
                registrar.setVisible(false);
                ventana.setTitle("Iniciar sesion");
                confirmar.setVisible(true);
                cuenta.setVisible(true);
                nip.setVisible(true);
                ingresarc.setVisible(true);
                ingresarn.setVisible(true);
                sesionfoto.setVisible(true);
                
                
                
            } 

                if (e.getSource()==registrar){  
            }
        
        } 
   }
   
}

