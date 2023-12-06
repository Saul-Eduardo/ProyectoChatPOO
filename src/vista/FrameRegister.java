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
import java.net.*;

public class FrameRegister extends JFrame {
    public static final int width = 400;
    public static final int heigth = 400;
    private JLabel labelUser;
    private JTextField writeUser;
    private JTextField writePass;
    private JLabel labelPass;
    private JButton acceptButton;
    private JButton cancelButton;
    private ImageIcon registericon;
    private JLabel labelRL;
    private JLabel msj;
    int a = 25, b = 150, c = 20, d = 340, e = 23, f = 160, g = 160, h = 210, i = 145, j = 300;
    private Socket socket;
    
    FrameRegister(Socket s){
        setUndecorated( false );
        setLayout( null );
        setTitle( "Registro de usuario" );
        setSize( width, heigth );
        setResizable(false);
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        icons();
        labels();
        textFields();
        buttons();
        socket=s;
    }

    void icons(){
        registericon = new ImageIcon( "src/vista/avatarplus.png" );
        labelRL = new JLabel( registericon );
        labelRL.setBounds( 160, 40, 80, 80 );
        add( labelRL );
        labelRL.updateUI();
    }

    void labels(){
        labelUser = new JLabel( "Usuario:" );
        labelUser.setBounds( a, g, b, c );
        add( labelUser );
        labelUser.updateUI();

        labelPass = new JLabel( "Contraseña:" );
        labelPass.setBounds( a, h, b, c );
        add( labelPass );
        labelPass.updateUI();
    }

    void textFields(){
        writeUser = new JTextField();
        writeUser.setBounds( a, g+23, d, e );
        add( writeUser );
        //writeUser.updateUI();

        writePass = new JTextField();
        writePass.setBounds( a, h+23, d, e );
        add( writePass );
        //writePass.updateUI();
    }

    void buttons(){

        acceptButton = new JButton( "Registrar" );
        acceptButton.setBounds( 210, j, 100, 25 );
        add( acceptButton ); 
        acceptButton.updateUI();

        cancelButton = new JButton( "Cancelar" );
        cancelButton.setBounds( 70, j, 100, 25 );
        add( cancelButton );
        cancelButton.updateUI();

        ActionRegister opcion = new ActionRegister( this, socket );
        acceptButton.addActionListener( opcion );
        cancelButton.addActionListener( opcion );
    }
    
    public JTextField getWriteUser(){
        return writeUser;
    }
    
    public JTextField getWritePass(){
        return writePass;
    }
    
    public JButton getAcceptButton(){
        return acceptButton;
    }
    
    public JButton getCancelButton(){
        return cancelButton;
    }
    
}
