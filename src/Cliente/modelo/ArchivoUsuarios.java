package Cliente.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoUsuarios {
    private String rutaArchivo;

    public ArchivoUsuarios(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public ArrayList<Usuario> cargarUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
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
        return listaUsuarios;
    }

    // Método para guardar la lista de usuarios en el archivo (puede ser añadido según necesidad)
}


