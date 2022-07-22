package consultorio.excepciones;

public class DniIncorrectoException extends RuntimeException {

    public DniIncorrectoException() {

        super("EL FORMATE DEL DNI NO ES CORRECTO");

    }

}
