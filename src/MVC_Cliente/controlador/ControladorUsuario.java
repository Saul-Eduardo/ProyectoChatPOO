
package MVC_Cliente.controlador;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import MVC_Cliente.modelo.Usuario;

public class ControladorUsuario {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<String> usuariosConectados;

    public ControladorUsuario(String rutaArchivo) {
        this.listaUsuarios = new ArrayList<>();
        this.usuariosConectados = new ArrayList<>();
        cargarUsuariosDesdeArchivo(rutaArchivo);
    }

    private void cargarUsuariosDesdeArchivo(String rutaArchivo) {
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                // Formato de Usuario "nombreUsuario,contraseña" 
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombreUsuario = partes[0];
                    String contraseña = partes[1];
                    listaUsuarios.add(new Usuario(nombreUsuario, contraseña));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
