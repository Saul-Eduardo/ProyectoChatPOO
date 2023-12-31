/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server.controlador;
import java.io.*;
import java.net.*;
import Cliente.modelo.Usuario;
import Cliente.controlador.ControladorUsuario;
/**
 *
 * @author DELL
 */
public class Opciones extends Thread{
    Socket cliente;
    DataInputStream dis;
    ControladorUsuario usuarios;
    
    
    Opciones(){}
    
    Opciones(Socket c){
        cliente=c;
        usuarios=new ControladorUsuario();
    }
    
    public void run(){
        String op="";
        dis=null;
        try{
            dis=new DataInputStream(cliente.getInputStream());
            op=dis.readUTF();
        }catch(IOException e){
            e.printStackTrace();
        }
        if(op.equals("a")){  //EntrarServer
            DataOutputStream dos=null;
            String tipo=null;
            try{
               tipo=dis.readUTF();
               dos=new DataOutputStream(cliente.getOutputStream());
            }catch(IOException e){
                e.printStackTrace();
            }
            if(tipo.equals("iniciar")){  //inicar sesion
                try{
                    String nombre=dis.readUTF();
                    String contrasena=dis.readUTF();
                    boolean verificar=usuarios.autenticar(nombre);
                    boolean confirmar=usuarios.autenticarUsuario(nombre,contrasena);
                    if(verificar==false || confirmar==false){
                        dos.writeBoolean(verificar);
                        dos.writeBoolean(confirmar);
                    }else if(verificar==true && confirmar==true){
                        dos.writeBoolean(verificar);
                        dos.writeBoolean(confirmar);
                        iniciarConexion(nombre);
                    }
                    
                }catch(IOException s){
                    s.printStackTrace();
                }
            }else if(tipo.equals("registra")){  //registrarse
                try{
                    String nombre=dis.readUTF();
                    String contrasena=dis.readUTF();
                    boolean verificar=usuarios.registrarUsuario(nombre, contrasena); //llamamos el metodo de registro
                    if(verificar==false){
                        dos.writeBoolean(verificar);
                    }else if(verificar==true){
                        dos.writeBoolean(verificar);
                    }
                }catch(IOException s){
                    s.printStackTrace();
                }
            }
        }else if(op.equals("b")){  //EnviarArchivos
            //a
        }
    }
    
    public void iniciarConexion(String nombre){
        //enviar lista de usuarios conectados al cliente
        /*try{
            DataOutputStream dos=new DataOutputStream(cliente.getOutputStream());
            for(String n:usuarios.obtenerUsuariosConectados()){
                dos.writeUTF(n);
            }
        }catch(IOException e){
            e.printStackTrace();
        }*/
        //registrar el nombre del usuario a la lista de usuarios conectados
        usuarios.obtenerUsuariosConectados().add(nombre);
        usuarios.sockets.add(cliente);
        ChatServer chat=new ChatServer(nombre,cliente,usuarios.usuariosConectados,usuarios.sockets);
    }
}
