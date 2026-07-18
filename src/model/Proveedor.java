package model;

public class Proveedor extends Persona {

    private String servicio;

    // Constructor antiguo
    public Proveedor(int id, String nombre, String rol, String servicio) {
        super(id, nombre, rol);
        this.servicio = servicio;
    }

    // Nuevo constructor
    public Proveedor(int id,
                     String nombre,
                     String rol,
                     Rut rut,
                     Direccion direccion,
                     String telefono,
                     String email,
                     String servicio) {

        super(id, nombre, rol, rut, direccion, telefono, email);
        this.servicio = servicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public void mostrarResumen() {

        System.out.println(
                "Proveedor -> ID: " + getId() +
                " | Nombre: " + getNombre() +
                " | Servicio: " + servicio
        );

    }

    @Override
    public String toString() {
        return super.toString() +
                " | Servicio: " + servicio;
    }
}