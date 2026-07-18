package model;

public class Tour {

    private int id;
    private String nombre;
    private String destino;
    private double precio;
    private GuiaTuristico guia;

    public Tour(int id, String nombre, String destino, double precio, GuiaTuristico guia) {
        this.id = id;
        this.nombre = nombre;
        this.destino = destino;
        this.precio = precio;
        this.guia = guia;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDestino() {
        return destino;
    }

    public double getPrecio() {
        return precio;
    }

    public GuiaTuristico getGuia() {
        return guia;
    }

    public void setGuia(GuiaTuristico guia) {
        this.guia = guia;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", destino='" + destino + '\'' +
                ", precio=" + precio +
                ", guia=" + guia.getNombre() +
                '}';
    }
}
