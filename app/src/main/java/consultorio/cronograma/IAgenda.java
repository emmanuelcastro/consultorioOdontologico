package consultorio.cronograma;

import java.time.LocalDateTime;
import java.util.Map;

public interface IAgenda {

    public Map<Integer, Turno> getListaTurnos();

    public void definirNumeroDeTurnos(Integer cantidadDeTurnos);

    public Turno crearNuevoTurno(Integer indice, Turno turno);

    public void actualizarTurno(Integer indice, Turno turno);

    public Turno buscarPacientePorDni(Integer dni);

    public Turno buscarPacientePorFechaYHora(LocalDateTime fechaYHora);

    public boolean eliminarTurno(Turno turno);

    public Integer buscarTurno(Turno turno);

    public boolean modificarTurno(Turno turno, Turno turnoParaAgregar);

    public LocalDateTime calcularHoraDelTurno(Integer indice);

    public int cantidadDeTurnosPorAgenda();

    public int cantidadDeTurnosAsignados();

    public int cantidadDeTurnosDisponibles();

}
