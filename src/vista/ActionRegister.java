package vista;

/**
 *
 * @author zzeth
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import Cliente.controlador.ControladorUsuario;

public class ActionRegister implements ActionListener {
    JButton register, cancel;
    JTextField tfUser, tfPass;
    String textUser, textPass;
    FrameRegister frameR;
    JFrame acceptF;
    JButton accept;
    ControladorUsuario controlador;

    ActionRegister(){
    }

    ActionRegister( FrameRegister fr, JButton register, JButton cancel, JTextField user, JTextField pass ){
        frameR = fr;
        this.register = register;
        this.cancel = cancel;
        tfUser = user;
        tfPass = pass;
        controlador = new ControladorUsuario();
    }

    public void actionPerformed( ActionEvent ae ){
        frameR.msj = new JLabel();
        frameR.msj.setForeground( Color.red );
        if( ae.getSource() == register ){
            textUser = tfUser.getText();
            textPass = tfPass.getText();
            boolean usuarioExiste = controlador.registrarUsuario( textUser, textPass );
            // método que lleve los textos al código registrar
            if( usuarioExiste ){
                frameR.dispose();
                acceptFrame();
                JLabel msj = new JLabel( "¡Usuario registrado! Ya puedes iniciar sesión" );
                msj.setBounds( 68, 80, 258, 30 );
                msj.setForeground( Color.red );
                acceptF.add( msj );
                msj.updateUI();
                accept = new JButton( "Aceptar" );
                accept.setBounds( 150, 120, 100, 25 );
                accept.addActionListener( this );
                acceptF.add( accept );
                accept.updateUI();
                System.out.println( "Se registró.\nUsuario: " + textUser + "\nPassword: " + textPass );
                acceptF.setVisible( true );
            }
        }else if( ae.getSource() == cancel ){
            System.out.println( "Se presionó cancelar el registro" );
            frameR.dispose();

        }else if( ae.getSource() == accept ){
            acceptF.dispose();
            FrameLogin f = new FrameLogin();
            f.setExtendedState( 0 );
        }
    }

    void acceptFrame(){
        acceptF = new JFrame();
        acceptF.setLayout( null );
        acceptF.setSize( 400, 200 );
        acceptF.setLocationRelativeTo( null );
        acceptF.setResizable( false );
        acceptF.setUndecorated( true );
    }
}
