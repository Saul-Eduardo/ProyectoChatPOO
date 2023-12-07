package Cliente.controlador;

import java.util.ArrayList;
import Cliente.modelo.Usuario;
import Cliente.modelo.ArchivoUsuarios;
import java.io.*;
import java.util.*;
import java.net.*;

public class ControladorUsuario {
    private ArrayList<Usuario> listaUsuarios;
    public ArrayList<String> usuariosConectados;
    //private ArchivoUsuarios archivoUsuarios;
    private ArchivarSerializar arch;
    public ArrayList<Socket> sockets; 
    
    public ControladorUsuario(){
        this.usuariosConectados = new ArrayList<>();
        listaUsuarios = hidratar();
        sockets=new ArrayList<Socket>();
    }

    /*public ControladorUsuario(String rutaArchivo) {
        this.listaUsuarios = hidratar();
        this.usuariosConectados = new ArrayList<>();
        this.archivoUsuarios = new ArchivoUsuarios(rutaArchivo);
        cargarUsuariosDesdeArchivo();
    }*/
    
    public ArrayList<Usuario> hidratar(){
        ArrayList<Usuario> usuariosH =null;
        try{
            FileInputStream fis = new FileInputStream( "databaseusers.ser" );
            ObjectInputStream ois = new ObjectInputStream( fis );
            usuariosH = ( ArrayList<Usuario> ) ois.readObject();
            return usuariosH;
        }catch(FileNotFoundException sad){
           System.out.println("archivo no encontrado");
            // Generar un archivo serializado con un usuario predeterminado
            Usuario usuarioPredeterminado = new Usuario("hola", "hola");
            ArrayList<Usuario> usuariosNuevos = new ArrayList<>();
            usuariosNuevos.add(usuarioPredeterminado);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("databaseusers.ser"))) {
                oos.writeObject(usuariosNuevos);
                System.out.println("Nuevo archivo serializado.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Volver a intentar hidratar
            return hidratar();
        }catch(IOException ert){
            System.out.println("entrada o salida error");
        }catch(ClassNotFoundException dor){
            dor.printStackTrace();
        }
        return usuariosH;
    }
    
    /*private void cargarUsuariosDesdeArchivo() {
        listaUsuarios = archivoUsuarios.cargarUsuarios();
    }*/

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
    
    public ArrayList<Usuario> obtenerUsuarios() {
        return listaUsuarios;
    }
}

