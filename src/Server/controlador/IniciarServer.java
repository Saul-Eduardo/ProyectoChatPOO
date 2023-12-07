/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server.controlador;

/**
 *
 * @author DELL
 */
public class IniciarServer {
    public static void main(String[] asd){
        Conexion server=new Conexion();
        server.start();
    }
}
