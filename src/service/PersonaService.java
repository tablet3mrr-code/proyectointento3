package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import model.Persona;
import model.Cliente;
import model.Registrable;
import model.GuiaTuristico;
import model.Proveedor;
import model.Reserva;
import model.Tour;
import model.Vehiculo;

public class PersonaService {

    private ArrayList<Registrable> personas;
    private HashMap<Integer, Tour> tours;
    private Stack<Reserva> historialReservas;

    public PersonaService(ArrayList<Registrable> personas) {
        this.personas = personas;
        this.tours = new HashMap<>();
        this.historialReservas = new Stack<>();
    }

    public void agregarEntidad(Registrable registrable) {
        personas.add(registrable);
    }

    public void mostrarPersonas() {

        for (Registrable registrable : personas) {

            registrable.mostrarResumen();

            if (registrable instanceof GuiaTuristico) {

                System.out.println(">> Esta entidad es un Guía Turístico.");

            } else if (registrable instanceof Proveedor) {

                System.out.println(">> Esta entidad es un Proveedor.");

            } else if (registrable instanceof Cliente) {

                System.out.println(">> Esta entidad es un Cliente.");

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

    // ===========================
    // MÉTODOS PARA TOURS
    // ===========================

    public void agregarTour(Tour tour) {
        tours.put(tour.getId(), tour);
    }

    public Tour buscarTour(int id) {
        return tours.get(id);
    }

    public void mostrarTours() {

        if (tours.isEmpty()) {
            System.out.println("No existen tours registrados.");
            return;
        }

        for (Tour tour : tours.values()) {
            System.out.println(tour);
        }
    }

    // ===========================
    // MÉTODOS PARA RESERVAS
    // ===========================

    public void registrarReserva(Reserva reserva) {
        historialReservas.push(reserva);
    }

    public void mostrarHistorialReservas() {

        if (historialReservas.isEmpty()) {
            System.out.println("No existen reservas.");
            return;
        }

        for (Reserva reserva : historialReservas) {
            System.out.println(reserva);
        }
    }

    // ===========================
    // FILTROS
    // ===========================

    public void mostrarClientes() {

        for (Registrable registrable : personas) {

            if (registrable instanceof Cliente) {
                registrable.mostrarResumen();
            }

        }
    }

    public void mostrarGuias() {

        for (Registrable registrable : personas) {

            if (registrable instanceof GuiaTuristico) {
                registrable.mostrarResumen();
            }

        }
    }

    public void mostrarProveedores() {

        for (Registrable registrable : personas) {

            if (registrable instanceof Proveedor) {
                registrable.mostrarResumen();
            }

        }
    }

    public ArrayList<Registrable> getPersonas() {
        return personas;
    }

    public HashMap<Integer, Tour> getTours() {
        return tours;
    }

    public Stack<Reserva> getHistorialReservas() {
        return historialReservas;
    }
}