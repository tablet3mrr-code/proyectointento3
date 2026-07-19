package model;
public class Vehiculo implements Registrable {

    private String patente;
    private String modelo;

    public Vehiculo(String patente, String modelo) {
        this.patente = patente;
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void mostrarResumen() {
        System.out.println(
                "Vehículo -> Modelo: " + modelo +
                " | Patente: " + patente
        );
    }
}