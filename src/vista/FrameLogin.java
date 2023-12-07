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
import java.io.*;

public class FrameLogin extends JFrame {
    public static final int width = 400;
    public static final int heigth = 400;
    private JLabel labelUser;
    private JTextField writeUser;
    private JPasswordField writePass;
    private JLabel labelPass;
    private JButton acceptButton;
    private JButton registerButton;
    private ImageIcon loginicon;
    private JLabel labelLL;
    private Color fondo;
    private JLabel or;
    int a = 25, b = 150, c = 20, d = 200, e = 23, f = 160, g = 160, h = 210, i = 145;
    private JLabel msjError;
    private Socket cliente;
    private String direccionIP;
    
    FrameLogin(){
        setUndecorated( false );
        setLayout( null );
        setTitle( "Inicio de sesión" );
        setSize( width, heigth );
        setResizable( true );
        setLocationRelativeTo(null);
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        
        //setVisible( true );
        icons();
        labels();
        textFields();
        buttons();
    }
    
    public void construirSocket(String direccion){
        try{
            cliente=new Socket(direccion,4321);
            DataOutputStream dos=new DataOutputStream(cliente.getOutputStream());
            dos.writeUTF("a");
        }catch(IOException w){
            w.printStackTrace();
        }
    }
    
    void icons(){
        loginicon = new ImageIcon( "src/vista/avatar.png" );
        labelLL = new JLabel( loginicon );
        labelLL.setBounds( 160, 40, 80, 80 );
        add( labelLL );
        labelLL.updateUI();
    }

    void labels(){
        labelUser = new JLabel( "Ingresa tu usuario:" );
        labelUser.setBounds( a, g, b, c );
        add( labelUser );
        labelUser.updateUI();

        labelPass = new JLabel( "Ingresa tu contraseña:" );
        labelPass.setBounds( a, h, b, c );
        add( labelPass );
        labelPass.updateUI();

        or = new JLabel( "---------- o ----------" );
        or.setBounds( i+2, 295, 100, 20 );
        add( or );
        or.updateUI();
    }

    void textFields(){
        writeUser = new JTextField();
        writeUser.setBounds( f, g, d, e );
        add( writeUser );

        writePass = new JPasswordField();
        writePass.setBounds( f, h, d, e );
        add( writePass );
    }
    
    void buttons(){
        acceptButton = new JButton( "Ingresar" );
        acceptButton.setBounds( i, 250, 100, 25 );
        add( acceptButton ); 
        acceptButton.updateUI();

        registerButton = new JButton( "Registrarse" );
        registerButton.setBounds( i, 320, 100, 25 );
        add( registerButton );
        registerButton.updateUI();

        ActionLogin opcion = new ActionLogin( this, cliente );
        acceptButton.addActionListener( opcion );
        registerButton.addActionListener( opcion );
    }
    
    public JButton getAcceptButton(){
        return acceptButton;
    }
    
    public JButton getRegisterButton(){
        return registerButton;
    }
    
    public JTextField getWriteUser(){
        return writeUser;
    }
    
    public JTextField getWritePass(){
        return writePass;
    }
    
    public Socket getCliente(){
        return cliente;
    }
    
    public void setMsjError( JLabel jl ){
        msjError = jl;
        this.add( msjError );
        msjError.updateUI();
    }
    
    public void setdireccionIP(String direccion){
        direccionIP=direccion;
    }
    
}
