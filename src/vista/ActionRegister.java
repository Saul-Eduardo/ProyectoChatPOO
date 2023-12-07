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
import java.net.*;

public class ActionRegister implements ActionListener {
    String textUser, textPass;
    FrameRegister frameR;
    JFrame acceptF;
    JButton accept;
    ControladorUsuario controlador;
    Socket socket;

    ActionRegister(){
    }

    ActionRegister( FrameRegister fr, Socket s ){
        frameR = fr;
        controlador = new ControladorUsuario();
        socket=s;
    }

    public void actionPerformed( ActionEvent ae ){
        JLabel m = new JLabel();
        m.setForeground( Color.red );
        if( ae.getSource() == frameR.getAcceptButton() ){
            textUser = frameR.getWriteUser().getText();
            textPass = frameR.getWritePass().getText();
            boolean usuarioExiste = controlador.registrarUsuario( textUser, textPass );
            // método que lleve los textos al código registrar
            if( usuarioExiste ){
                frameR.dispose();
                acceptFrame();
                System.out.println( "Se registró.\nUsuario: " + textUser + "\nPassword: " + textPass );
                acceptF.setVisible( true );
            }
        }else if( ae.getSource() == frameR.getCancelButton() ){
            System.out.println( "Se presionó cancelar el registro" );
            frameR.dispose();

        }else if( ae.getSource() == accept ){
            acceptF.dispose();
            FrameLogin f = new FrameLogin();
            //f.setExtendedState( 0 );
            f.setVisible(true);
        }
    }

    void acceptFrame(){
        acceptF = new JFrame();
        acceptF.setLayout( null );
        acceptF.setSize( 400, 200 );
        acceptF.setLocationRelativeTo( null );
        acceptF.setResizable( false );
        acceptF.setUndecorated( true );
        
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
    }
}
