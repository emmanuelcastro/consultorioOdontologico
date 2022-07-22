package consultorio.excepciones;

public class OdontologoExisteException extends RuntimeException {

    public OdontologoExisteException() {

        super("EL ODONTOLOGO YA EXISTE");

    }

}
