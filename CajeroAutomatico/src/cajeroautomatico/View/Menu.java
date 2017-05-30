package cajeroautomatico.View;

import Datos.Servidor;
import Excepciones.CifraParaDepositoNoValidoException;
import Excepciones.ExcepcionErrorModificacion;
import Excepciones.ExcepcionRegistroIncompleto;
import Excepciones.FondosInsuficientesException;
import cajeroautomatico.Model.Cuenta;
import cajeroautomatico.Model.Transaccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JFrame {

    private JPanel pantalla;
    private JButton Deposito;
    private JButton Retiro;
    private JButton Aceptar;
    private JLabel fondodepantalla;
    private JLabel Saldodisponible;
    private JLabel CantidadD;
    private JLabel CantidadR;
    private JTextField DigitosR;
    private JTextField DigitosD;

    private Cuenta cuenta;

    private boolean deposito;

    public Menu(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void mostrar() {
        crear();
        pegar();
        lanzar();
    }

    void crear() {
        pantalla = new JPanel();
        Deposito = new JButton("Depositar");
        Retiro = new JButton("Retirar");
        Aceptar = new JButton("Aceptar");
        fondodepantalla = new JLabel();
        Saldodisponible = new JLabel("Saldo disponible: $");
        DigitosD = new JTextField();
        DigitosR = new JTextField();
        CantidadR = new JLabel("Digite cantidad a retirar:");
        CantidadD = new JLabel("Digite cantidad a depositar:");
    }

    void pegar() {
        this.setSize(600, 600);
        this.setTitle("Cholo Bank");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        pantalla.setLayout(null);
        pantalla.setBounds(0, 0, 500, 500);

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

        Deposito.setBounds(260, 330, 100, 20);
        Deposito.setVisible(true);
        Deposito.setFocusable(false);
        Deposito.addActionListener(new ControladorBoton());

        Retiro.setBounds(260, 360, 100, 20);
        Retiro.setVisible(true);
        Retiro.setFocusable(false);
        Retiro.addActionListener(new ControladorBoton());

        Aceptar.setBounds(320, 360, 100, 20);
        Aceptar.setVisible(false);
        Aceptar.setFocusable(false);
        Aceptar.addActionListener(new ControladorBoton());

        fondodepantalla.setVisible(true);
        fondodepantalla.setBounds(0, 0, 600, 600);
        fondodepantalla.setIcon(new ImageIcon("src/cajeroautomatico/imagenes/cholobank.jpg"));

    }

    void lanzar() {

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

    public void mostrarDeposito() {
        DigitosD.setVisible(true);
        CantidadD.setVisible(true);
        Aceptar.setVisible(true);
        Deposito.setVisible(false);
        Retiro.setVisible(false);
    }

    public void mostrarRetiro() {
        DigitosR.setVisible(true);
        CantidadR.setVisible(true);
        Aceptar.setVisible(true);
        Deposito.setVisible(false);
        Retiro.setVisible(false);
    }

    public void mandarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    class ControladorBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Deposito) {
                mostrarDeposito();
                deposito = true;
            }
            if (e.getSource() == Retiro) {
                mostrarRetiro();
                deposito = false;
            }

            if (e.getSource() == Aceptar && deposito) {
                float cantidad;
                Servidor servidor = new Servidor();
                Transaccion transaccion;
                try {
                    cantidad = Float.parseFloat(DigitosD.getText());
                    if (cantidad < 100) {
                        throw new CifraParaDepositoNoValidoException("No hay fondos suficientes para retirar esa cantidad");
                    }
                    //Hacer el depósito
                    cuenta.setSaldo(cuenta.getSaldo() + cantidad);
                    servidor.Modificar(cuenta);
                    //Registrar la transacción
                    transaccion = new Transaccion(cuenta.getId(), cantidad, "Depósito", new Date());
                    servidor.Registro(transaccion);

                } catch (ExcepcionErrorModificacion ex) {
                    mandarMensaje("Error realizando depósito, inténtelo más tarde...");
                } catch (ExcepcionRegistroIncompleto ex) {
                    mandarMensaje("Error registrando transaccion, inténtelo más tarde...");
                } catch (CifraParaDepositoNoValidoException ex) {
                    mandarMensaje("El depósito debe ser mayor o igual a 100 pesos");
                }
            } else {
                float cantidad;
                Servidor servidor = new Servidor();
                Transaccion transaccion;
                try {
                    cantidad = Float.parseFloat(DigitosD.getText());
                    if (cantidad < cuenta.getSaldo()) {
                        throw new FondosInsuficientesException("No hay fondos suficientes para retirar esa cantidad");
                    }
                    //Hacer el depósito
                    cuenta.setSaldo(cuenta.getSaldo() - cantidad);
                    servidor.Modificar(cuenta);
                    //Registrar la transacción
                    transaccion = new Transaccion(cuenta.getId(), cantidad, "Retiro", new Date());
                    servidor.Registro(transaccion);

                } catch (ExcepcionErrorModificacion ex) {
                    mandarMensaje("Error realizando depósito, inténtelo más tarde...");
                } catch (ExcepcionRegistroIncompleto ex) {
                    mandarMensaje("Error registrando transaccion, inténtelo más tarde...");

                } catch (FondosInsuficientesException ex) {
                    mandarMensaje("Fondos insuficientes");
                }
            }
        }
    }
}
