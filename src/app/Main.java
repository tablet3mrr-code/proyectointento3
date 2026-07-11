package app;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Persona;
import model.Registrable;
import model.GuiaTuristico;
import model.Vehiculo;

import service.PersonaService;
import util.ArchivoUtil;

public class Main {

    public static void main(String[] args) {


        ArrayList<Persona> listaPersonas =
                ArchivoUtil.cargarPersonas("personas.csv");


        ArrayList<Registrable> entidades = new ArrayList<>();

        entidades.addAll(listaPersonas);


        PersonaService servicio =
                new PersonaService(entidades);


        int opcion;


        do {

            opcion = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "LLANQUIHUE TOUR\n\n" +
                            "1. Agregar Guía Turístico\n" +
                            "2. Agregar Vehículo\n" +
                            "3. Mostrar registros\n" +
                            "4. Salir"
                    )
            );


            switch(opcion) {


                case 1:

                    int id =
                    Integer.parseInt(
                    JOptionPane.showInputDialog("Ingrese ID del guía")
                    );


                    String nombre =
                    JOptionPane.showInputDialog("Ingrese nombre");


                    String idioma =
                    JOptionPane.showInputDialog("Ingrese idioma");


                    GuiaTuristico guia =
                    new GuiaTuristico(
                            id,
                            nombre,
                            "Guía Turístico",
                            idioma
                    );


                    servicio.agregarEntidad(guia);


                    JOptionPane.showMessageDialog(
                            null,
                            "Guía agregado correctamente"
                    );

                    break;



                case 2:


                    String patente =
                    JOptionPane.showInputDialog(
                            "Ingrese patente"
                    );


                    String modelo =
                    JOptionPane.showInputDialog(
                            "Ingrese modelo del vehículo"
                    );


                    Vehiculo vehiculo =
                    new Vehiculo(
                            patente,
                            modelo
                    );


                    servicio.agregarEntidad(vehiculo);


                    JOptionPane.showMessageDialog(
                            null,
                            "Vehículo agregado correctamente"
                    );


                    break;



                case 3:


                    String mensaje = "";


                    for(Registrable r : servicio.getPersonas()) {

                        mensaje += obtenerResumen(r);
                        mensaje += "\n-----------------\n";

                    }


                    JOptionPane.showMessageDialog(
                            null,
                            mensaje
                    );


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


        } while(opcion != 4);


    }



    public static String obtenerResumen(Registrable r) {


        if(r instanceof GuiaTuristico) {

            GuiaTuristico guia = (GuiaTuristico) r;

            return "GUÍA TURÍSTICO\n" +
                    "Nombre: " + guia.getNombre() +
                    "\nIdioma: " + guia.getIdioma();

        }


        else if(r instanceof Vehiculo) {


            Vehiculo v = (Vehiculo) r;

            return "VEHÍCULO\n" +
                    "Modelo: " + v.getModelo() +
                    "\nPatente: " + v.getPatente();

        }


        else if(r instanceof Persona) {


            return "PERSONA\n" +
                    r.toString();

        }


        return "Entidad desconocida";

    }

}