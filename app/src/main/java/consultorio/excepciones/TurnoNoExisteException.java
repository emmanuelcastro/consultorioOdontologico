package consultorio.excepciones;

public class TurnoNoExisteException extends RuntimeException {

    public TurnoNoExisteException() {

        super("EL TURNO NO EXISTE");

    }

}
