package service;
import java.util.ArrayList;
import model.Persona;

public class PersonaService {

    private ArrayList<Persona> personas;

    public PersonaService(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public void mostrarPersonas() {

        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }

    public Persona buscarPorId(int id) {

        for (Persona persona : personas) {

            if (persona.getId() == id) {
                return persona;
            }
        }

        return null;
    }
}