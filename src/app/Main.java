package app;

import exception.RutInvalidoException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Direccion;
import model.GuiaTuristico;
import model.Persona;
import model.Registrable;
import model.Rut;
import model.Vehiculo;
import service.PersonaService;
import util.ArchivoUtil;

public class Main {

    public static void main(String[] args) {

        ArrayList<Persona> listaPersonas =
                ArchivoUtil.cargarPersonas("data/personas.txt");

        ArrayList<Registrable> entidades = new ArrayList<>();

        entidades.addAll(listaPersonas);

        PersonaService servicio =
                new PersonaService(entidades);

        int opcion = 0;

        do {

            try {

                opcion = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "LLANQUIHUE TOUR\n\n"
                                + "1. Agregar Guía Turístico\n"
                                + "2. Agregar Vehículo\n"
                                + "3. Mostrar registros\n"
                                + "4. Salir"
                        )
                );

                switch (opcion) {

                    case 1:

                        agregarGuia(servicio);

                        break;

                    case 2:

                        agregarVehiculo(servicio);

                        break;

                    case 3:

                        mostrarRegistros(servicio);

                        break;

                    case 4:

                        JOptionPane.showMessageDialog(
                                null,
                                "Sistema cerrado"
                        );

                        break;

                    default:

                        JOptionPane.showMessageDialog(
                                null,
                                "Opción inválida"
                        );
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Debe ingresar una opción numérica.",
                        "Dato inválido",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        } while (opcion != 4);
    }

    public static void agregarGuia(PersonaService servicio) {

        try {

            int id = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Ingrese ID del guía"
                    )
            );

            String nombre = JOptionPane.showInputDialog(
                    "Ingrese nombre"
            );

            String rutTexto = JOptionPane.showInputDialog(
                    "Ingrese RUT, por ejemplo: 12.345.678-5"
            );

            String calle = JOptionPane.showInputDialog(
                    "Ingrese calle y número"
            );

            String ciudad = JOptionPane.showInputDialog(
                    "Ingrese ciudad"
            );

            String region = JOptionPane.showInputDialog(
                    "Ingrese región"
            );

            String especialidad = JOptionPane.showInputDialog(
                    "Ingrese especialidad del guía"
            );

            Rut rut = new Rut(rutTexto);

            Direccion direccion = new Direccion(
                    calle,
                    ciudad,
                    region
            );

            GuiaTuristico guia = new GuiaTuristico(
                    id,
                    nombre,
                    rut,
                    direccion,
                    especialidad
            );

            servicio.agregarEntidad(guia);

            JOptionPane.showMessageDialog(
                    null,
                    "Guía agregado correctamente"
            );

        } catch (RutInvalidoException e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "RUT inválido",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "El ID debe ser un número entero.",
                    "Dato inválido",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (IllegalArgumentException e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Dato inválido",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void agregarVehiculo(PersonaService servicio) {

        try {

            String patente = JOptionPane.showInputDialog(
                    "Ingrese patente"
            );

            String modelo = JOptionPane.showInputDialog(
                    "Ingrese modelo del vehículo"
            );

            Vehiculo vehiculo = new Vehiculo(
                    patente,
                    modelo
            );

            servicio.agregarEntidad(vehiculo);

            JOptionPane.showMessageDialog(
                    null,
                    "Vehículo agregado correctamente"
            );

        } catch (IllegalArgumentException e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Dato inválido",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void mostrarRegistros(PersonaService servicio) {

        String mensaje = "";

        for (Registrable r : servicio.getPersonas()) {

            mensaje += obtenerResumen(r);
            mensaje += "\n-----------------\n";
        }

        if (mensaje.isBlank()) {
            mensaje = "No existen registros.";
        }

        JOptionPane.showMessageDialog(
                null,
                mensaje
        );
    }

    public static String obtenerResumen(Registrable r) {

        if (r instanceof GuiaTuristico) {

            GuiaTuristico guia = (GuiaTuristico) r;

            return "GUÍA TURÍSTICO\n"
                    + "ID: " + guia.getId()
                    + "\nNombre: " + guia.getNombre()
                    + "\nRUT: " + guia.getRut()
                    + "\nDirección: " + guia.getDireccion()
                    + "\nEspecialidad: "
                    + guia.getEspecialidad();

        } else if (r instanceof Vehiculo) {

            Vehiculo vehiculo = (Vehiculo) r;

            return "VEHÍCULO\n"
                    + "Modelo: " + vehiculo.getModelo()
                    + "\nPatente: " + vehiculo.getPatente();

        } else if (r instanceof Persona) {

            Persona persona = (Persona) r;

            return "PERSONA\n"
                    + persona.toString();
        }

        return "Entidad desconocida";
    }
}