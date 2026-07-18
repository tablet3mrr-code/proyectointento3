package util;

import exception.RutInvalidoException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Cliente;
import model.Direccion;
import model.GuiaTuristico;
import model.Persona;
import model.Proveedor;
import model.Rut;

public class ArchivoUtil {

    public static ArrayList<Persona> cargarPersonas(String archivo) {

        ArrayList<Persona> lista = new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader(archivo))) {

            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {

                numeroLinea++;

                if (linea.isBlank()) {
                    continue;
                }

                try {

                    Persona persona = convertirLineaEnPersona(linea);

                    if (persona != null) {
                        lista.add(persona);
                    }

                } catch (RutInvalidoException
                         | IllegalArgumentException e) {

                    System.out.println(
                            "Error en la línea "
                                    + numeroLinea
                                    + ": "
                                    + e.getMessage()
                    );
                }
            }

            System.out.println(
                    "Personas cargadas correctamente: "
                            + lista.size()
            );

        } catch (IOException e) {

            System.out.println(
                    "Error al leer el archivo: "
                            + e.getMessage()
            );
        }

        return lista;
    }

    private static Persona convertirLineaEnPersona(String linea)
            throws RutInvalidoException {

        String[] datos = linea.split(";");

        if (datos.length != 8) {
            throw new IllegalArgumentException(
                    "La línea debe contener 8 datos separados por punto y coma."
            );
        }

        String tipo = datos[0].trim().toUpperCase();
        int id = Integer.parseInt(datos[1].trim());
        String nombre = datos[2].trim();
        Rut rut = new Rut(datos[3].trim());

        String calle = datos[4].trim();
        String ciudad = datos[5].trim();
        String region = datos[6].trim();

        Direccion direccion = new Direccion(
                calle,
                ciudad,
                region
        );

        String datoEspecifico = datos[7].trim();

        switch (tipo) {

            case "CLIENTE":

                int puntos = Integer.parseInt(datoEspecifico);

                return new Cliente(
                        id,
                        nombre,
                        rut,
                        direccion,
                        puntos
                );

            case "GUIA":

                return new GuiaTuristico(
                        id,
                        nombre,
                        rut,
                        direccion,
                        datoEspecifico
                );

            case "PROVEEDOR":

                return new Proveedor(
                        id,
                        nombre,
                        rut,
                        direccion,
                        datoEspecifico
                );

            default:

                throw new IllegalArgumentException(
                        "Tipo de persona desconocido: " + tipo
                );
        }
    }
}