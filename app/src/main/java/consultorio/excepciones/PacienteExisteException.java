package consultorio.excepciones;

public class PacienteExisteException extends RuntimeException {

    public PacienteExisteException() {

        super("EL PACIENTE YA EXISTE");

    }
}
