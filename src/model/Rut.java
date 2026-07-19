package model;
import exception.RutInvalidoException;


public class Rut {

    private String numero;

    public Rut(String numero) throws RutInvalidoException {
        setNumero(numero);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws RutInvalidoException {

        if (!esValido(numero)) {
            throw new RutInvalidoException(
                    "El formato del RUT no es válido: " + numero
            );
        }

        this.numero = limpiarRut(numero);
    }

    private boolean esValido(String rut) {

        if (rut == null || rut.isBlank()) {
            return false;
        }

        String rutLimpio = limpiarRut(rut);

        return rutLimpio.matches("\\d{7,8}-[0-9K]");
    }

    
    private String limpiarRut(String rut) {

        return rut.replace(".", "")
                  .replace(" ", "")
                  .toUpperCase();
    }

    @Override
    public String toString() {
        return numero;
    }
}