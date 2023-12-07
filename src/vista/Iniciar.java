package vista;
import java.io.*;

/**
 *
 * @author zzeth
 */
public class Iniciar {
    public static void main( String[] zz ){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String direccionIP=" ";
        try{
            System.out.println("ingrese la direccion IP: ");
            direccionIP=br.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        FrameLogin iniciar = new FrameLogin(); 
        iniciar.construirSocket(direccionIP);
        iniciar.setVisible(true);
    }
}