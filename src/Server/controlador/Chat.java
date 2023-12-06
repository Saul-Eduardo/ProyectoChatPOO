
package Server.controlador;
import java.net.*;
import java.io.*;
import java.util.*;

public class Chat{
    ArrayList<Socket> clientes;
    ArrayList<String> nombresUsuarios;
    String nombreUsuario;
    Socket cliente;
    
    Chat(){}
    
    Chat(String nu,Socket s,ArrayList<String> nus,ArrayList<Socket> c){
        nombreUsuario=nu;
        cliente=s;
        nombresUsuarios=nus;
        clientes=c;
        iniciar();
    }
    
    public void iniciar(){
        ControladorMsj usuario=new ControladorMsj(nombreUsuario,cliente,nombresUsuarios,clientes);
        usuario.start();
    }
}
