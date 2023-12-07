package Cliente.vista;

/**
 *
 * @author zzeth
 */
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.net.*;

public class Chat extends JInternalFrame {
    private JTextArea msjsChat;
    private JScrollPane scrollChat;
    private JPanel chat;
    private JTextField escribir;
    private JButton enviar;
    private JButton enviarArch;
    private JPanel enviarMsjs;
    private String nombreE = "X0";
    private Send funcionEnviar;
    private Socket socket;
    
    Chat(){}

    Chat(Socket s){
        socket=s;
        setTitle( "Chat grupal" );
        setLayout( new BorderLayout() );
        setSize( 390, 300 );
        setResizable( false );
		setClosable( false );
        setVisible( true );
        mensajes();
        escribirMsj();
        add( chat, BorderLayout.NORTH  );
        add( enviarMsjs, BorderLayout.SOUTH );
        updateUI();
    }

    void mensajes(){
        chat = new JPanel( new GridLayout( 1, 1 ) );
        msjsChat = new JTextArea( 15, 5 );
        msjsChat.setEditable( false );
        scrollChat = new JScrollPane( msjsChat );
        chat.add( scrollChat );
    }

    void escribirMsj(){
        enviarMsjs = new JPanel( new BorderLayout() );
        escribir = new JTextField( 24 );
        enviar = new JButton( "Enviar" );
        ImageIcon clipicon = new ImageIcon( "src/vista/clip.png" );
        enviarArch = new JButton( clipicon );
        enviarArch.setToolTipText("Enviar archivo");
        enviarMsjs.add( escribir, BorderLayout.WEST );
        enviarMsjs.add( enviarArch, BorderLayout.CENTER );
        enviarMsjs.add( enviar, BorderLayout.EAST );

        funcionEnviar = new Send( this,socket );
        escribir.addKeyListener( funcionEnviar );
        enviar.addActionListener( funcionEnviar );
        enviarArch.addActionListener( funcionEnviar );
    }

    public JButton getEnviar(){
        return enviar;
    }
    
    public JButton getEnviarArch(){
        return enviarArch;
    }

    public JTextField getEscribir(){
        return escribir;
    }

    public JTextArea getMsjsChat(){
        return msjsChat;
    }

    public String getNombreE(){
        return nombreE;
    }

    public void setNombreE( String n ){
        nombreE = n;
    }
}
