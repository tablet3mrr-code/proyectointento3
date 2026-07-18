package model;

public class Persona implements Registrable {

    private int id;
    private String nombre;
    private String rol;

    // Nuevos atributos (composición)
    private Rut rut;
    private Direccion direccion;
    private String telefono;
    private String email;

    // Constructor antiguo (para mantener compatibilidad)
    public Persona(int id, String nombre, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    // Nuevo constructor
    public Persona(int id, String nombre, String rol, Rut rut,
                   Direccion direccion, String telefono, String email) {

        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.rut = rut;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void mostrarResumen() {
        System.out.println(toString());
    }

    @Override
    public String toString() {

        String datos = "ID: " + id +
                " | Nombre: " + nombre +
                " | Rol: " + rol;

        if (rut != null) {
            datos += " | Rut: " + rut;
        }

        if (direccion != null) {
            datos += " | Dirección: " + direccion;
        }

        if (telefono != null) {
            datos += " | Teléfono: " + telefono;
        }

        if (email != null) {
            datos += " | Email: " + email;
        }

        return datos;
    }
}