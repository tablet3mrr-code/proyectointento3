package model;

public class GuiaTuristico extends Persona {

    private String especialidad;

    public GuiaTuristico(int id, String nombre, Rut rut,
                         Direccion direccion, String especialidad) {

        super(id, nombre, rut, direccion);
        setEspecialidad(especialidad);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {

        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException(
                    "La especialidad no puede estar vacía."
            );
        }

        this.especialidad = especialidad.trim();
    }

    @Override
    public void mostrarResumen() {

        System.out.println(
                "Guía Turístico -> "
                + getNombre()
                + " | RUT: " + getRut()
                + " | Especialidad: " + especialidad
        );
    }

    @Override
    public String toString() {

        return super.toString()
                + " | Especialidad: "
                + especialidad;
    }
}