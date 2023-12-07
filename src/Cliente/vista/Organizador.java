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

public class Organizador extends JPanel {
    private Chat chat;
    private BarraConectados barraConect;
    private String nombreE;
    Organizador(){
        setLayout( null );
        chat = new Chat();
        add( chat );
        barraConect = new BarraConectados();
        add( barraConect );
    }

    public void setNombreE( String n ){
        chat.setNombreE( n );
    }
    
    public Chat getChat(){
        return chat;
    }
}
