package util;

import model.Persona;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoUtil {

    public static ArrayList<Persona> cargarPersonas(String archivo) {

        ArrayList<Persona> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] datos = linea.split(",");

                if (datos.length >= 3) {

                    int id = Integer.parseInt(datos[0].trim());
                    String nombre = datos[1].trim();
                    String rol = datos[2].trim();

                    Persona persona = new Persona(id, nombre, rol);

                    lista.add(persona);
                }
            }

        } catch (IOException e) {

            System.out.println("Error al leer el archivo: " + e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("Error en el formato de los datos.");

        }

        return lista;
    }
}