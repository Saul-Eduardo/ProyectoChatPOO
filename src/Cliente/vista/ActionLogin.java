package Cliente.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import Cliente.controlador.ControladorUsuario;
import java.net.*;
import java.io.*;

public class ActionLogin implements ActionListener {
    String textUser, textPass;
    FrameLogin frameIS;
    Socket socket;
    
    ActionLogin(){}

    ActionLogin( FrameLogin fl, Socket s){
        frameIS = fl;
        socket=s;
    }
    
    public void actionPerformed( ActionEvent ae ){
        if( ae.getSource() == frameIS.getAcceptButton() ){
            textUser = frameIS.getWriteUser().getText();
            textPass = frameIS.getWritePass().getText();
            autenticar();
        }else if( ae.getSource() == frameIS.getRegisterButton() ){
            FrameRegister iniciar = new FrameRegister(socket);
            iniciar.setVisible( true );
            frameIS.dispose();
        }
    }
    
    void autenticar(){
        JLabel me = new JLabel();
        me.setForeground( Color.red );
        boolean userExist = false;
        boolean passCorrect = false;
        try{
            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
            DataInputStream dis=new DataInputStream(socket.getInputStream());
            dos.writeUTF("iniciar");
            dos.writeUTF(textUser);
            dos.writeUTF(textPass);
            userExist=dis.readBoolean();
            passCorrect=dis.readBoolean();
        }catch(IOException e){
            e.printStackTrace();
        }
        if( userExist ){
            if( passCorrect ){
                POOMessenger p = new POOMessenger();
                p.getChat().setNombreE( textUser );
                System.out.println( "Se ingresó\nUsuario: " + textUser + "\nPassword: " + textPass );
                frameIS.dispose();
            }else{
                me.setText( "Contraseña incorrecta. Restan 2 intentos..." );
                me.setBounds( 72, 130, 242, 30 );
                frameIS.setMsjError( me );
                System.out.println( "No se ingresó\nContraseña: " + textPass + " incorrecta" );
            }
        }else{
            me.setText( "Usuario no existente" );
            me.setBounds( 140, 130, 120, 30 );
            frameIS.setMsjError( me );
            System.out.println( "No se ingresó\nUsuario: " + textUser + " no existe" );
        }
    }
}
