package consultorio.excepciones;

public class NombreIncorrectoException extends RuntimeException {

    public NombreIncorrectoException() {

        super("Los Campos De Nombres No Deben Contener Numeros");

    }

}
