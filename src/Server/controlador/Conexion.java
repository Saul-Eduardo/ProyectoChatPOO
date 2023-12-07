/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server.controlador;
import java.net.*;
import java.io.*;
/**
 *
 * @author DELL
 */
public class Conexion extends Thread{
    ServerSocket server;
    
    public void run(){
        int op=0;
        try{
            server=new ServerSocket(4321);
            while(op==0){
                Socket cliente=server.accept();
                System.out.println("Cliente conectado.....");
                Opciones opc=new Opciones(cliente);
                opc.start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
