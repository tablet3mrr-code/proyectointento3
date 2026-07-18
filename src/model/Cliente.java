package model;

public class Cliente extends Persona {

    private int puntos;

    public Cliente(int id, String nombre, Rut rut,
                   Direccion direccion, int puntos) {

        super(id, nombre, rut, direccion);
        setPuntos(puntos);
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {

        if (puntos < 0) {
            throw new IllegalArgumentException(
                    "Los puntos no pueden ser negativos."
            );
        }

        this.puntos = puntos;
    }

    @Override
    public void mostrarResumen() {

        System.out.println(
                "Cliente -> "
                + getNombre()
                + " | RUT: " + getRut()
                + " | Puntos: " + puntos
        );
    }

    @Override
    public String toString() {

        return super.toString()
                + " | Puntos: "
                + puntos;
    }
}