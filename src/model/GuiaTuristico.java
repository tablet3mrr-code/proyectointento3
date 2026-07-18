package model;

public class GuiaTuristico extends Persona {

    private String idioma;

    // Constructor antiguo (para mantener compatibilidad)
    public GuiaTuristico(int id, String nombre, String rol, String idioma) {
        super(id, nombre, rol);
        this.idioma = idioma;
    }

    // Nuevo constructor para la EFT
    public GuiaTuristico(int id, String nombre, String rol,
                         Rut rut,
                         Direccion direccion,
                         String telefono,
                         String email,
                         String idioma) {

        super(id, nombre, rol, rut, direccion, telefono, email);
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public void mostrarResumen() {

        System.out.println(
                "Guía Turístico -> ID: " + getId() +
                " | Nombre: " + getNombre() +
                " | Idioma: " + idioma
        );

    }

    @Override
    public String toString() {
        return super.toString() +
                " | Idioma: " + idioma;
    }
}