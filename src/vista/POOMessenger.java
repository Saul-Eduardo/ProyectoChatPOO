/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

public class POOMessenger extends JFrame {
    private Organizador org;
    private JMenuBar barraConfiguracion;
    private JMenu conf, confNombre, confAmigos;
    private JMenuItem cambiarNombre, addAmigo, elimAmigo, listaAmigos, desconectarse;
    private String nombreE;
    private Chat c;

    POOMessenger(){
        setLocationRelativeTo( null );
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable( false );
        setLayout( new GridLayout( 1, 1 ) );
        setTitle( "POOMessenger" );
        setSize( 604, 359 );

        org = new Organizador();
        add( org );
        c = org.getChat();
        
        menu();
        setJMenuBar( barraConfiguracion );
        barraConfiguracion.updateUI();
    }

    void menu(){
        barraConfiguracion = new JMenuBar();
        conf = new JMenu( "Ajustes");
        barraConfiguracion.add( conf );

        confAmigos = new JMenu( "Amigos" );
        conf.add( confAmigos );

        listaAmigos = new JMenuItem( "Lista de amigos" );
        addAmigo = new JMenuItem( "Añadir amigo" );
        confAmigos.add( addAmigo );
        elimAmigo = new JMenuItem( "Eliminar amigo" );
        confAmigos.add( elimAmigo );

        desconectarse = new JMenuItem( "Desconectarse" );
        conf.add( desconectarse );

        AccionMenu accion = new AccionMenu( this );
        desconectarse.addActionListener( accion );
    }
    
    public Chat getChat(){
        return c;
    }

    public JMenuItem getDesconectarse(){
        return desconectarse;
    }

    public JMenuItem getCambiarNombre(){
        return cambiarNombre;
    }

    public JMenuItem getAddAmigo(){
        return addAmigo;
    }

    public JMenuItem getElimAmigo(){
        return elimAmigo;
    }

    public JMenuItem getListaAmigos(){
        return listaAmigos;
    }

    public void setNombreE( String n ){
        //nombreE = n;
        org.setNombreE( n );
    }
}
