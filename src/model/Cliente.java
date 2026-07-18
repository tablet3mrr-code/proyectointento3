package model;

public class Cliente extends Persona {

    private int puntos;

    // Constructor antiguo
    public Cliente(int id, String nombre, String rol, int puntos) {
        super(id, nombre, rol);
        this.puntos = puntos;
    }

    // Nuevo constructor
    public Cliente(int id, String nombre, String rol,
                   Rut rut,
                   Direccion direccion,
                   String telefono,
                   String email,
                   int puntos) {

        super(id, nombre, rol, rut, direccion, telefono, email);
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public void mostrarResumen() {

        System.out.println(
                "Cliente -> ID: " + getId() +
                " | Nombre: " + getNombre() +
                " | Puntos: " + puntos
        );

    }

    @Override
    public String toString() {
        return super.toString() +
                " | Puntos: " + puntos;
    }
}