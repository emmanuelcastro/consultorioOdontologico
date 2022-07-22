package consultorio.excepciones;

public class TurnoExisteException extends RuntimeException {

    public TurnoExisteException() {

        super("EL TURNO YA EXISTE");

    }

}
