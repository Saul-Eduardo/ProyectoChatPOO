package Cliente.vista;
import Cliente.modelo.Usuario;
import java.io.*;
import java.util.ArrayList;


public class Iniciar {
    static String direccionIP=" ";
    
    public static void main( String[] zz ){
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("ingrese la direccion IP: ");
            direccionIP=br.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        FrameLogin iniciar = new FrameLogin();
    }
}