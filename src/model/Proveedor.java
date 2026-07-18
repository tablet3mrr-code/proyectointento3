package model;

public class Proveedor extends Persona {

    private String servicio;

    public Proveedor(int id, String nombre, Rut rut,
                     Direccion direccion, String servicio) {

        super(id, nombre, rut, direccion);
        setServicio(servicio);
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {

        if (servicio == null || servicio.isBlank()) {
            throw new IllegalArgumentException(
                    "El servicio no puede estar vacío."
            );
        }

        this.servicio = servicio.trim();
    }

    @Override
    public void mostrarResumen() {
        System.out.println(
                "Proveedor -> "
                        + getNombre()
                        + " | RUT: " + getRut()
                        + " | Servicio: " + servicio
        );
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Servicio: "
                + servicio;
    }
}