package vista;

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

public class Send implements ActionListener, KeyListener {
String text, sender;
    JLabel textPrint;
    int n = 1;
    Chat c;

    Send(){
    }

    Send( Chat c ){
        this.c = c;
        c.setNombreE( "Luis xd" );
    }
    
    public void actionPerformed( ActionEvent ae ){
        if( ae.getSource() == c.getEnviar() ){
            text = c.getEscribir().getText();
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
            c.getMsjsChat().append( c.getNombreE() + ": "+ text + "\n" );
            System.out.println( text );
            c.getEscribir().setText( "" );
        }
    }
    public void keyPressed( KeyEvent ke ){
    }

    public void keyTyped( KeyEvent ke ){
    }
}
