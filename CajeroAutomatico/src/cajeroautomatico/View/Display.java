package cajeroautomatico.View;

import Datos.Servidor;
import Excepciones.ExcepcionConsultaInalcanzable;
import Excepciones.ExcepcionCuentaInexistente;
import Excepciones.ExcepcionUsuarioInexistente;
import cajeroautomatico.Model.Cuenta;
import cajeroautomatico.Model.Cuentahabiente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Display extends JFrame {

    private JPanel pantalla;
    private JButton confirmar;
    private JLabel sesionfoto;
    private JLabel fondodepantalla;
    private JLabel cuenta;
    private JLabel nip;
    private JTextField ingresarc;
    private JTextField ingresarn;

    public void mostrar() {
        crear();
        pegar();
        lanzar();
    }

    void crear() {
        pantalla = new JPanel();
        confirmar = new JButton("Aceptar");
        fondodepantalla = new JLabel();
        cuenta = new JLabel("Cuenta:");
        nip = new JLabel("NIP:");
        sesionfoto = new JLabel();
        ingresarc = new JTextField();
        ingresarn = new JTextField();
    }

    void pegar() {
        this.setSize(600, 600);
        this.setTitle("Cholo Bank");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        pantalla.setLayout(null);
        pantalla.setBounds(0, 0, 500, 500);

        cuenta.setBounds(300, 340, 110, 20);
        cuenta.setVisible(true);
        nip.setBounds(320, 370, 110, 20);
        nip.setVisible(true);

        ingresarc.setBounds(350, 340, 150, 20);
        ingresarn.setBounds(350, 370, 150, 20);
        ingresarc.setVisible(true);
        ingresarn.setVisible(true);

        confirmar.setBounds(372, 400, 100, 20);
        confirmar.setVisible(true);
        confirmar.setFocusable(false);
        confirmar.addActionListener(new ControladorBoton());

        sesionfoto.setBounds(200, 300, 115, 115);
        sesionfoto.setIcon(new ImageIcon("src/cajeroautomatico/imagenes/sesionfoto.png"));
        sesionfoto.setVisible(true);

        fondodepantalla.setVisible(true);
        fondodepantalla.setBounds(0, 0, 600, 600);
        fondodepantalla.setIcon(new ImageIcon("src/cajeroautomatico/imagenes/cholobank.jpg"));

    }

    void lanzar() {

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
    
    private void mandarMensaje(String s){
        JOptionPane.showMessageDialog(null, s);
    }
    
    class ControladorBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Servidor servidor = new Servidor();
            Cuenta cuenta;
            Cuentahabiente cuentahabiente;
            String pass;
            int idCuenta;
            if (e.getSource() == confirmar) {
                try{
                    //Validar que el numero de cuenta sea un número.
                    idCuenta = Integer.parseInt(ingresarc.getText());
                    System.out.println("Cuenta: " + idCuenta);
                    cuenta = servidor.buscarCuenta(idCuenta);
                    cuentahabiente = servidor.buscarCuentaHabiente(cuenta.getIdCuentahabiente());
                    pass = ingresarn.getText();
                    if(pass.equals(cuentahabiente.getPass())){
                        mandarMensaje("Ha ingresado con éxito");
                        setVisible(false);
                        
                        //Desplegar el otro frame
                        Menu m = new Menu(cuenta);
                        m.mostrar();
                    }
                }catch(ExcepcionCuentaInexistente ex){
                    mandarMensaje("Verifique los datos ingresados");
                    
                } catch (ExcepcionConsultaInalcanzable ex) {
                    mandarMensaje("Servicio no disponible, intentelo más tarde");
                    System.exit(1);
                } catch (ExcepcionUsuarioInexistente ex) {
                   mandarMensaje("Verifique los datos ingresados");
                   
                }
            }

        }
    }

}
