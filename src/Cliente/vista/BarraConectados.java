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

public class BarraConectados extends JInternalFrame {
    private ArrayList<JButton> boton;
    private ArrayList<JLabel> userOnline;
    private ArrayList<String> nombre;
    private ArrayList<PanelPorUsuarioC> pane;
    BarraConectados(){
        setTitle( "Amigos conectados" );
        setBounds( 390, 0, 200, 300 );
        setResizable( false );
		setClosable( true );
        setLayout( new GridLayout( 6, 1 ) );
        setVisible( true );
        boton = new ArrayList<JButton>();
        nombre = new ArrayList<String>();
        pane = new ArrayList<PanelPorUsuarioC>();

        crearPanelUC( "Saul" );
        mostrarUC();
        crearPanelUC( "Raul" );
        mostrarUC();
        crearPanelUC( "Fatmagul" );
        mostrarUC();
        crearPanelUC( "Paul" );
        mostrarUC();
    }

    public void crearPanelUC( String nombre ){
        pane.add( new PanelPorUsuarioC( nombre ) );
    }

    public void mostrarUC(){
        for( int i = 0; i < pane.size(); i++ ){
            this.add( pane.get( i ) );
        }
    }
}
