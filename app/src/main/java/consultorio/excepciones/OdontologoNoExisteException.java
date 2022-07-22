package consultorio.excepciones;

public class OdontologoNoExisteException extends RuntimeException {

    public OdontologoNoExisteException() {

        super("EL ODONTOLOGO NO EXISTE");

    }

}
