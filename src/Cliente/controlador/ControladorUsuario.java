package Cliente.controlador;

import java.util.ArrayList;
import Cliente.modelo.Usuario;
import Cliente.modelo.ArchivoUsuarios;
import java.io.*;
import java.util.*;

public class ControladorUsuario {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<String> usuariosConectados;
    private ArchivoUsuarios archivoUsuarios;
    private ArchivarSerializar arch;
    
    public ControladorUsuario(){
        this.usuariosConectados = new ArrayList<>();
        listaUsuarios = new ArrayList<Usuario>();
    }

    public ControladorUsuario(String rutaArchivo) {
        //this.listaUsuarios = hidratar();
        this.usuariosConectados = new ArrayList<>();
        this.archivoUsuarios = new ArchivoUsuarios(rutaArchivo);
        cargarUsuariosDesdeArchivo();
    }
    
    /*public ArrayList<Usuario> hidratar(){
        FileInputStream fis = new FileInputStream( "databaseusers.ser" );
        ObjectInputStream ois = new ObjectInputStream( fis );
        ArrayList<Usuario> usuariosH = ( ArrayList<Usuario> ) ois.readObject();
        return usuariosH;
    }*/

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
        arch = new ArchivarSerializar( listaUsuarios );
        // Puedes agregar código para guardar la lista actualizada en el archivo aquí
        return true;
    }
    
    public boolean autenticar( String nombre ){
        for (Usuario usuario : listaUsuarios) {
            if (usuario.obtenerNombreUsuario().equals(nombre) ) {
                return true;  // Autenticación exitosa
            }
        }
        return false;
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

