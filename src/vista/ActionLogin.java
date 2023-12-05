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

public class ActionLogin implements ActionListener {
    JButton login, register;
    String textUser, textPass;
    JTextField tfUser, tfPass;
    FrameLogin frameIS;
    
    ActionLogin(){
    }

    ActionLogin( FrameLogin fl, JButton login, JButton register, JTextField user, JTextField pass ){
        frameIS = fl;
        this.login = login;
        this.register = register;
        tfUser = user;
        tfPass = pass;
    }
    
    public void actionPerformed( ActionEvent ae ){
        if( ae.getSource() == login ){
            textUser = tfUser.getText();
            textPass = tfPass.getText();
            autenticar();
        }else if( ae.getSource() == register ){
            FrameRegister iniciar = new FrameRegister();
            //frameIS.setExtendedState( 1 );
            iniciar.setVisible( true );
            frameIS.dispose();
        }
    }
    
    // aquí va el código autenticar
    void autenticar(){
        frameIS.msjError = new JLabel();
        frameIS.msjError.setForeground( Color.red );
        boolean userExist = false; // en vez de true o false se llama al método autenticar, este debe retornar un valor booleano
        boolean passCorrect = true; // lo mismo

        if( userExist ){
            if( passCorrect ){
                //VentanaI ventana = new VentanaI();
                System.out.println( "Se ingresó\nUsuario: " + textUser + "\nPassword: " + textPass );
                frameIS.dispose();
            }else{
                frameIS.msjError.setText( "Contraseña incorrecta. Restan 2 intentos..." );
                frameIS.msjError.setBounds( 72, 130, 242, 30 );
                frameIS.add( frameIS.msjError );
                frameIS.msjError.updateUI();
                System.out.println( "No se ingresó\nContraseña: " + textPass + " incorrecta" );
            }
        }else{
            frameIS.msjError.setText( "Usuario no existente" );
            frameIS.msjError.setBounds( 140, 130, 120, 30 );
            frameIS.add( frameIS.msjError );
            frameIS.msjError.updateUI();
            System.out.println( "No se ingresó\nUsuario: " + textUser + " no existe" );
        }
    }
}
