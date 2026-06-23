package app;
import java.util.ArrayList;
import java.util.Scanner;
import model.Persona;
import service.PersonaService;
import util.ArchivoUtil;

public class Main {

    public static void main(String[] args) {
        
        ArrayList<Persona> personas =
                ArchivoUtil.cargarPersonas("personas.csv");

        PersonaService servicio =
                new PersonaService(personas);

        Scanner teclado = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("LISTADO DE COLABORADORES");
        System.out.println("================================");

        servicio.mostrarPersonas();

        System.out.println("\n================================");
        System.out.println("BUSQUEDA POR ID");
        System.out.println("================================");

        System.out.print("Ingrese el ID que desea buscar: ");
        int idBuscado = teclado.nextInt();

        Persona encontrada = servicio.buscarPorId(idBuscado);

        if (encontrada != null) {

            System.out.println("\nColaborador encontrado:");
            System.out.println(encontrada);

        } else {

            System.out.println("\nNo existe un colaborador con ese ID.");
        }

        teclado.close();
    }
}