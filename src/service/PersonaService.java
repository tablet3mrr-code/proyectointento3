package service;

import java.util.ArrayList;

import model.Persona;
import model.Registrable;
import model.GuiaTuristico;
import model.Vehiculo;

public class PersonaService {

    private ArrayList<Registrable> personas;

    public PersonaService(ArrayList<Registrable> personas) {
        this.personas = personas;
    }

    public void agregarEntidad(Registrable registrable) {
        personas.add(registrable);
    }

    public void mostrarPersonas() {

        for (Registrable registrable : personas) {

            registrable.mostrarResumen();

            if (registrable instanceof GuiaTuristico) {

                System.out.println(">> Esta entidad es un Guía Turístico.");

            } else if (registrable instanceof Vehiculo) {

                System.out.println(">> Esta entidad es un Vehículo.");

            } else if (registrable instanceof Persona) {

                System.out.println(">> Esta entidad es una Persona.");
            }

            System.out.println("--------------------------------");
        }
    }

    public Persona buscarPorId(int id) {

        for (Registrable registrable : personas) {

            if (registrable instanceof Persona) {

                Persona persona = (Persona) registrable;

                if (persona.getId() == id) {
                    return persona;
                }
            }
        }

        return null;
    }

    public ArrayList<Registrable> getPersonas() {
        return personas;
    }
}