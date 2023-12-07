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

public class PanelPorUsuarioC extends JPanel {
    private ImageIcon useronlineicon;
    private JLabel etiquetaUC;
    private String nombre;

    PanelPorUsuarioC(){
        setLayout( new BorderLayout() );
        useronlineicon = new ImageIcon( "src/cliente/vista/online.png" );
    }

    PanelPorUsuarioC( String nombre ){
        setLayout( new BorderLayout() );
        useronlineicon = new ImageIcon( "src/cliente/vista/online.png" );
        this.nombre = nombre;
        etiquetaUC = new JLabel( nombre, useronlineicon, 0 );
        add( etiquetaUC, BorderLayout.WEST );
    }

    public JLabel getEtiquetaUC(){
        return etiquetaUC;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre( String n ){
        nombre = n;
    }

    //para usar este método primero deben usar el setNombre;
    public void crearEtiquetaUC(){
        etiquetaUC = new JLabel( nombre, useronlineicon, 0 );
        add( etiquetaUC, BorderLayout.WEST );
    }   
}
