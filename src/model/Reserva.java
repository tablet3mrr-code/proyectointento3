package model;

public class Reserva {

    private int id;
    private Cliente cliente;
    private Tour tour;
    private String fecha;

    public Reserva(int id, Cliente cliente, Tour tour, String fecha) {
        this.id = id;
        this.cliente = cliente;
        this.tour = tour;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Tour getTour() {
        return tour;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {

        return "Reserva{" +
                "id=" + id +
                ", cliente=" + cliente.getNombre() +
                ", tour=" + tour.getNombre() +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}