package Cliente.controlador;
import java.io.*;
import java.util.*;
import Cliente.modelo.Usuario;
/**
 *
 * @author zzeth
 */
public class Hidratar {
    FileInputStream users;
    ObjectInputStream oUsers;
    Usuario usuario;
    ArrayList<Usuario> usuarios;
    
    Hidratar(){
        try{
            users = new FileInputStream("databaseusers.ser");  
            oUsers = new ObjectInputStream( users );
	}catch( Exception e ){
            System.out.println( "Error: Base de datos" );
	}
        
    }
}
