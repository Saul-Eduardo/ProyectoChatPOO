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

public class AccionMenu implements ActionListener {
    POOMessenger poom;

    AccionMenu(){}

    AccionMenu( POOMessenger poom ){
        this.poom = poom;
    }

    public void actionPerformed( ActionEvent ae ){
        if( ae.getSource() == poom.getDesconectarse() ){
            poom.dispose();
            FrameLogin f = new FrameLogin();
        }
    }
}
