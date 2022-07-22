package consultorio.excepciones;

public class PacienteNoExisteException extends RuntimeException {

    public PacienteNoExisteException() {

        super("EL PACIENTE NO EXISTE");

    }
}
