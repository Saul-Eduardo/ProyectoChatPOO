
package Cliente.modelo;
import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable{
    private String nombreUsuario;
    private String contraseña;

    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public String obtenerNombreUsuario() {
        return nombreUsuario;
    }

    public String obtenerContraseña() {
        return contraseña;
    }

    // Otros métodos según sea necesario
}


