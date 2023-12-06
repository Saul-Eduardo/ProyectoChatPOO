
package Cliente.controlador;
import java.io.*;
import java.util.*;
import Cliente.modelo.Usuario;
/**
 *
 * @author zzeth
 */
public class ArchivarSerializar {
    static int cont = 0;
    FileOutputStream users;
    ObjectOutputStream oUsers;
    Usuario usuario;

	ArchivarSerializar(){
	}
	
	ArchivarSerializar( ArrayList<Usuario> u ){
		try{
			users = new FileOutputStream("databaseusers.ser");
			oUsers = new ObjectOutputStream( users );
		}catch( IOException e ){
			System.out.println("ErrorA: Archivar");
		}
		serializar( u );
	}

	void serializar( ArrayList<Usuario> u ){
		try{
			oUsers.writeObject( u );
			oUsers.close();
			users.close();

		}catch( IOException e ){
			System.out.println( "Error: Serialización" );
		}
	}
}
