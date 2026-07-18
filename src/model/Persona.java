package model;

/**
 * Clase base para representar a una persona del sistema.
 */
public abstract class Persona implements Registrable {

    private int id;
    private String nombre;
    private Rut rut;
    private Direccion direccion;

    public Persona(int id, String nombre, Rut rut, Direccion direccion) {
        setId(id);
        setNombre(nombre);
        setRut(rut);
        setDireccion(direccion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "El ID debe ser mayor que cero."
            );
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }
        this.nombre = nombre.trim();
    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        if (rut == null) {
            throw new IllegalArgumentException(
                    "El RUT no puede ser nulo."
            );
        }
        this.rut = rut;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        if (direccion == null) {
            throw new IllegalArgumentException(
                    "La dirección no puede ser nula."
            );
        }
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Nombre: " + nombre
                + " | RUT: " + rut
                + " | Dirección: " + direccion;
    }
}