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

public class Send implements ActionListener, KeyListener {
    String text, sender;
    JLabel textPrint;
    int n = 1;
    Chat c;
    Socket socket;

    Send(){
    }

    Send( Chat c,Socket s ){
        this.c = c;
        socket=s;
    }
    
    public void actionPerformed( ActionEvent ae ){
        if( ae.getSource() == c.getEnviar() ){
            text = c.getEscribir().getText();
            enviar(text);
            c.getMsjsChat().append( c.getNombreE() + ": "+ text + "\n" );
            System.out.println( text );
            c.getEscribir().setText( "" );
        }else if( ae.getSource() == c.getEnviarArch() ){
            JFileChooser f = new JFileChooser();
            int seleccion = f.showOpenDialog( c );
            if ( seleccion == JFileChooser.APPROVE_OPTION ){
                File archivo = f.getSelectedFile();
            }
        }      
    }

    public void keyReleased( KeyEvent ke ){
        if( ke.getKeyCode() == KeyEvent.VK_ENTER ){
            text = c.getEscribir().getText();
            enviar(text);
            c.getMsjsChat().append( c.getNombreE() + ": "+ text + "\n" );
            System.out.println( text );
            c.getEscribir().setText( "" );
        }
    }
    public void keyPressed( KeyEvent ke ){
    }

    public void keyTyped( KeyEvent ke ){
    }
    
    public void enviar(String msj){
        try{
            DataOutputStream salida=new DataOutputStream(socket.getOutputStream());
            salida.writeUTF(msj);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
