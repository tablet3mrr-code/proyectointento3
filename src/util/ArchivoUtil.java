package util;
import model.Persona;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoUtil {

    public static ArrayList<Persona> cargarPersonas(String archivo) {

        ArrayList<Persona> lista = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(archivo));

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String rol = datos[2];

                Persona persona = new Persona(id, nombre, rol);

                lista.add(persona);
            }

            br.close();

        } catch (IOException e) {

            System.out.println("Error al leer el archivo");

        } catch (NumberFormatException e) {

            System.out.println("Error en el formato de datos");
        }

        return lista;
    }
}