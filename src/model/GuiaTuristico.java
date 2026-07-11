package model;
public class GuiaTuristico extends Persona {

    private String idioma;

    public GuiaTuristico(int id, String nombre, String rol, String idioma) {
        super(id, nombre, rol);
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
                " | Idioma: " + idiomas
        );
    }
}