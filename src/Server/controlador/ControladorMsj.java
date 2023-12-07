
package Server.controlador;
import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author DELL
 */
public class ControladorMsj extends Thread {
    ArrayList<Socket> clientes;
    ArrayList<String> nombresUsuarios;
    String nombreUsuario;
    Socket cliente;
    String msj;
    DataInputStream dis;
    DataOutputStream dos;
    
    ControladorMsj(){}
    
    ControladorMsj(String nu,Socket s,ArrayList<String> nus,ArrayList<Socket> c){
        nombreUsuario=nu;
        cliente=s;
        nombresUsuarios=nus;
        clientes=c;
        msj=" ";
    }
    
    public void run(){
        int senal=0;
        while(senal==0){
            try{
                dis=new DataInputStream(cliente.getInputStream());
                msj=dis.readUTF();
                if(msj.equals("ADIOS")){
                    msj=" se a desconectado...";
                    senal=1;
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            msj=nombreUsuario+": "+msj+"\n";
            for(Socket s:clientes){
                if(clientes.indexOf(s)!=nombresUsuarios.indexOf(nombreUsuario)){
                    try{
                        dos=new DataOutputStream(cliente.getOutputStream());
                        dos.writeUTF(msj);
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        nombresUsuarios.remove(nombreUsuario);
        clientes.remove(cliente);
    }
}
