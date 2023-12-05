
package Cliente.controlador;


import java.util.ArrayList;
import Cliente.modelo.Usuario;
import Cliente.modelo.ArchivoUsuarios;

public class ControladorUsuario {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<String> usuariosConectados;
    private ArchivoUsuarios archivoUsuarios;

    public ControladorUsuario(String rutaArchivo) {
        this.listaUsuarios = new ArrayList<>();
        this.usuariosConectados = new ArrayList<>();
        this.archivoUsuarios = new ArchivoUsuarios(rutaArchivo);
        cargarUsuariosDesdeArchivo();
    }

    private void cargarUsuariosDesdeArchivo() {
        listaUsuarios = archivoUsuarios.cargarUsuarios();
    }

    public boolean registrarUsuario(String nombreUsuario, String contraseña) {
        // Verificar si el usuario ya existe
        for (Usuario usuario : listaUsuarios) {
            if (usuario.obtenerNombreUsuario().equals(nombreUsuario)) {
                return false; 
            }
        }

        // Crear un nuevo usuario y agregarlo a la lista
        Usuario nuevoUsuario = new Usuario(nombreUsuario, contraseña);
        listaUsuarios.add(nuevoUsuario);
        // Puedes agregar código para guardar la lista actualizada en el archivo aquí
        return true;
    }

    public boolean autenticarUsuario(String nombreUsuario, String contraseña) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.obtenerNombreUsuario().equals(nombreUsuario) && usuario.obtenerContraseña().equals(contraseña)) {
                // Agregar el usuario a la lista de conectados
                usuariosConectados.add(nombreUsuario);
                return true;  // Autenticación exitosa
            }
        }
        return false;  // Autenticación fallida
    }

    public void cerrarSesionUsuario(String nombreUsuario) {
        // Eliminar al usuario de la lista de conectados al cerrar sesión
        usuariosConectados.remove(nombreUsuario);
    }

    // Getter de la lista de usuarios conectados
    public ArrayList<String> obtenerUsuariosConectados() {
        return usuariosConectados;
    }
}

