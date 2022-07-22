package consultorio.excepciones;

public class HorarioNoAsignadoException extends Exception {

    public HorarioNoAsignadoException() {

        super("EL HORARIO NO ESTA ASIGNADO");
    }

}
