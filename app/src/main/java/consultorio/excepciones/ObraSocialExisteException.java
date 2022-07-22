package consultorio.excepciones;

public class ObraSocialExisteException extends RuntimeException {

  public ObraSocialExisteException() {

    super("LA OBRA SOCIAL YA SE ENCUENTRA REGISTRADA");
    
  }

}
