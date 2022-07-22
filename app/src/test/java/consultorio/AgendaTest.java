package consultorio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import consultorio.DatosAnexos.ObraSocial;
import consultorio.cronograma.IAgenda;
import consultorio.cronograma.Turno;
import consultorio.excepciones.PacienteNoExisteException;
import consultorio.excepciones.TurnoNoExisteException;
import consultorio.persona.Odontologo;
import consultorio.persona.Paciente;
import utils.Generator;

public class AgendaTest {

    private ObraSocial obraSocial;
    private Paciente paciente, paciente2;
    private LocalDateTime horarioDisponible;
    private LocalDateTime fechaYHoraDelTurnoDelPaciente;
    private LocalDateTime fechaYHoraDelTurnoDelPaciente2;
    private Turno turno, turno2;
    private Odontologo odontologo, odontologo2;
    private IAgenda agenda, agenda2, agenda3;
    private String horaDeEntrada, horaDeEntrada2, horaDeEntrada3;

    @Before

    public void variables() { // CREACION DE INSTANCIAS

        obraSocial = new ObraSocial("OSEP", 11122);

        paciente = new Paciente("Gabriel", "Sanchez", 39881765, "Dolor de Muela", obraSocial);
        paciente2 = new Paciente("Juan", "Olima", 25993456, "Quitar Muela Del Juicio", obraSocial);

        fechaYHoraDelTurnoDelPaciente = LocalDateTime.parse("2021-01-01T08:00:00");
        fechaYHoraDelTurnoDelPaciente2 = LocalDateTime.parse("2021-01-01T11:00:00");

        turno = new Turno(fechaYHoraDelTurnoDelPaciente, paciente);
        turno2 = new Turno(fechaYHoraDelTurnoDelPaciente2, paciente2);

        horaDeEntrada = "2021-01-01T08:00:00";
        horaDeEntrada2 = "2021-01-01T09:00:00";
        horaDeEntrada3 = "2021-01-01T10:00:00";

        odontologo = Generator.crearOdontologo("Luis", "Olima", 22244423, 4456, horaDeEntrada, 5);
        odontologo2 = Generator.crearOdontologo("Ruben", "Farias", 33344423, 2202, horaDeEntrada2, 10);

        agenda = odontologo.getAgenda();
        agenda2 = odontologo2.getAgenda();

    }



    @Test

    public void definirNumeroDeTurnos() {

        agenda.definirNumeroDeTurnos(odontologo.getCantidadDeTurnosDiarios());

        Integer turnosEsperados = agenda.cantidadDeTurnosDisponibles();

        assertEquals((Integer) 5, turnosEsperados);

    }

    @Test
    public void cantidadDeTurnosAsignados() {

        agenda.crearNuevoTurno(0, turno);

        agenda.crearNuevoTurno(1, turno2);

        Integer cantidadDeTurnosEsperados = agenda.cantidadDeTurnosAsignados();

        assertEquals((Integer) 2, cantidadDeTurnosEsperados);

    }

    @Test

    public void crearNuevoTurno() { // TEST PARA ASIGNAR UN TURNO A UN PACIENTE

        agenda.crearNuevoTurno(0, turno);

        Integer turnosOcupados = agenda.cantidadDeTurnosAsignados();

        assertEquals((Integer) 1, turnosOcupados);

    }

    /*--------------------------------------------------------------------------------*/

    @Test

    public void buscarPacientePorDni() { // TEST PARA BUSCAR UN PACIENTE POR DNI

        agenda.crearNuevoTurno(0, turno);

        Turno turnoEsperado = agenda.buscarPacientePorDni(39881765);

        assertEquals(turnoEsperado, turno);

    }

    /*--------------------------------------------------------------------------------*/
    @Test

    public void modificarTurnoPorDni() { // TEST PARA MODIFICAR TURNO POR DNI

        Integer dniEsperado = turno2.getPaciente().getDni();
        String nombreEsperado = turno2.getPaciente().getNombre();
        String apellidoEsperado = turno2.getPaciente().getApellido();
        String motivoDeConsultaEsperado = turno2.getPaciente().getMotivoDeConsulta();

        agenda.crearNuevoTurno(0, turno);
        agenda.modificarTurno(turno, turno2);

        assertEquals(dniEsperado, agenda.buscarPacientePorDni(dniEsperado).getPaciente().getDni());
        assertEquals(nombreEsperado, agenda.buscarPacientePorDni(dniEsperado).getPaciente().getNombre());
        assertEquals(apellidoEsperado, agenda.buscarPacientePorDni(dniEsperado).getPaciente().getApellido());
        assertEquals(motivoDeConsultaEsperado,
                agenda.buscarPacientePorDni(dniEsperado).getPaciente().getMotivoDeConsulta());

    }

    /*--------------------------------------------------------------------------------*/
    @Test

    public void eliminarTurno() { // TEST PARA ELIMINAR UN TURNO POR DNI

        agenda.crearNuevoTurno(0, turno);
        agenda.buscarPacientePorDni(39881765);
        agenda.eliminarTurno(turno);

        assertEquals(0, agenda.cantidadDeTurnosAsignados());

    }

    /*--------------------------------------------------------------------------------*/


    @Test

    public void actualizarTurno() {

        agenda.crearNuevoTurno(1, turno);

        agenda.actualizarTurno(1, turno2);

        assertTrue(true);

    }



    @Test

    public void cantidadTurnos() { // TEST PARA AGREGAR UN TURNO DISPONIBLE

        agenda.crearNuevoTurno(0, turno);
        assertEquals(1, agenda.cantidadDeTurnosAsignados());
        assertEquals(4, agenda.cantidadDeTurnosDisponibles());

    }

    @Test
    public void buscarPacientePorFechaYHora() {

        agenda.crearNuevoTurno(0, turno);

        Turno turnoEsperado = agenda.buscarPacientePorFechaYHora(fechaYHoraDelTurnoDelPaciente);

        assertEquals(turnoEsperado, turno);

    }

    @Test(expected = PacienteNoExisteException.class)

    public void buscarPacientePorFechaYHoraInexistente() {

        agenda.crearNuevoTurno(0, turno);

        LocalDateTime fechaYHoraDelTurnoDelPacienteInexistente = LocalDateTime.parse("2021-01-01T11:00:00");

        Turno turnoEsperado = agenda.buscarPacientePorFechaYHora(fechaYHoraDelTurnoDelPacienteInexistente);

        assertEquals(turnoEsperado, turno);

    }

    @Test
    public void buscarTurno() {

        agenda.crearNuevoTurno(0, turno);

        Integer turnoEsperado = agenda.buscarTurno(turno);

        assertEquals(turnoEsperado, (Integer) 0);

    }

    @Test(expected = TurnoNoExisteException.class)
    public void buscarTurnoNoExistente() {

        agenda.crearNuevoTurno(2, turno);

        Integer turnoEsperado = agenda.buscarTurno(turno2);

    }

    @Test

    public void modificarTurno() {

        agenda.crearNuevoTurno(0, turno);
        agenda.modificarTurno(turno, turno2);

        assertTrue(true);

    }

   


}
