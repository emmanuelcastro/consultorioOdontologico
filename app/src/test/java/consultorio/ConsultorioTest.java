package consultorio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import consultorio.consultorio.Consultorio;
import consultorio.cronograma.IAgenda;
import consultorio.cronograma.Turno;
import consultorio.DatosAnexos.*;
import consultorio.excepciones.DniIncorrectoException;
import consultorio.excepciones.NombreIncorrectoException;
import consultorio.excepciones.ObraSocialExisteException;
import consultorio.excepciones.ObraSocialNoExisteException;
import consultorio.excepciones.OdontologoExisteException;
import consultorio.excepciones.OdontologoNoExisteException;
import consultorio.excepciones.PacienteExisteException;
import consultorio.excepciones.PacienteNoExisteException;
import consultorio.persona.Odontologo;
import consultorio.persona.Paciente;
import utils.Generator;

public class ConsultorioTest {

    private Consultorio consultorio = Consultorio.getInstancia();
    private ObraSocial obraSocial;
    private ObraSocial obraSocial2, obraSocial3;
    private Paciente paciente, paciente2, paciente3;
    private LocalDateTime horarioDisponible;
    private LocalDateTime fechaYHoraDelTurnoDelPaciente;
    private LocalDateTime fechaYHoraDelTurnoDelPaciente2;
    private Turno turno, turno2;
    private Odontologo odontologo, odontologo2;
    private IAgenda agenda, agenda2, agenda3;
    private String horaDeEntrada, horaDeEntrada2, horaDeEntrada3;

    @Before

    public void variables() { // CREACION DE INSTANCIAS

        consultorio.clear();

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

    public void agregarPaciente() { // TEST PARA AGREGAR PACIENTE

        obraSocial = new ObraSocial("OSEP", 11122);
        obraSocial2 = new ObraSocial("Osde", 44466);

        paciente = Generator.crearPaciente("Pedro", "Ramirez", 40123456, "Dolor de encía", obraSocial);
        paciente2 = Generator.crearPaciente("Juan", "Ramirez", 40123456, "Dolor de diente", obraSocial2);

        consultorio.agregarPacientes(paciente);
        consultorio.agregarPacientes(paciente2);
        assertEquals((Integer) 2, consultorio.getCantidadPacientes());

    }

    @Test

    public void agregarPaciente2() {

        obraSocial = new ObraSocial("Osdop", 11122);
        obraSocial2 = new ObraSocial("OUTHGRA", 78945);
        obraSocial3 = new ObraSocial("Pami", 12345);

        paciente = Generator.crearPaciente("Atilio", "Fernandez", 40123456, "Dolor de encía", obraSocial);
        paciente2 = Generator.crearPaciente("Patricia", "Gutierrez", 40123456, "Dolor de diente", obraSocial2);
        paciente3 = Generator.crearPaciente("Luisa", "Martinez", 25789321, "Tratamiento de caries", obraSocial3);

        consultorio.agregarPacientes(paciente);
        consultorio.agregarPacientes(paciente2);
        consultorio.agregarPacientes(paciente3);

        assertEquals((Integer) 3, consultorio.getCantidadPacientes());

    }

    @Test

    public void encontrarPacientes() { // TEST PARA ENCONTRAR PACIENTE

        obraSocial = new ObraSocial("Osdop", 11122);
        obraSocial2 = new ObraSocial("OUTHGRA", 78945);
        obraSocial3 = new ObraSocial("Pami", 12345);

        paciente = Generator.crearPaciente("Atilio", "Fernandez", 40123456, "Dolor de encía", obraSocial);
        paciente2 = Generator.crearPaciente("Patricia", "Gutierrez", 41123456, "Dolor de diente", obraSocial2);
        paciente3 = Generator.crearPaciente("Luisa", "Martinez", 25789321, "Tratamiento de caries", obraSocial3);

        consultorio.agregarPacientes(paciente);
        consultorio.agregarPacientes(paciente2);
        consultorio.agregarPacientes(paciente3);

        consultorio.encontrarPaciente(40123456);
        consultorio.encontrarPaciente(41123456);
        consultorio.encontrarPaciente(25789321);

        assertEquals((Integer) 40123456, paciente.getDni());

    }

    @Test
    public void modificarPaciente() { // TEST PARA MODIFICAR UN PACIENTE

        obraSocial = new ObraSocial("Osdop", 11122);
        obraSocial2 = new ObraSocial("OUTHGRA", 78945);
        obraSocial3 = new ObraSocial("Pami", 12345);

        paciente = Generator.crearPaciente("Atilio", "Fernandez", 40123456, "Dolor de encía", obraSocial);
        paciente2 = Generator.crearPaciente("Patricia", "Gutierrez", 41123456, "Dolor de diente", obraSocial2);
        paciente3 = Generator.crearPaciente("Luisa", "Martinez", 25789321, "Tratamiento de caries", obraSocial3);

        consultorio.agregarPacientes(paciente);
        consultorio.agregarPacientes(paciente2);
        consultorio.agregarPacientes(paciente3);

        consultorio.encontrarPaciente(40123456);
        consultorio.encontrarPaciente(41123456);
        consultorio.encontrarPaciente(25789321);

        consultorio.modificarPaciente(paciente2, 40123456);
        consultorio.modificarPaciente(paciente3, 41123456);
        consultorio.modificarPaciente(paciente, 25789321);

        assertEquals((Integer) 40123456, paciente.getDni());
        assertEquals((Integer) 41123456, paciente2.getDni());
        assertEquals((Integer) 25789321, paciente3.getDni());

    }

    @Test
    public void eliminarPaciente() { // TEST PARA ELIMINAR UN PACIENTE

        obraSocial = new ObraSocial("Osdop", 11122);
        obraSocial2 = new ObraSocial("OUTHGRA", 78945);
        obraSocial3 = new ObraSocial("Pami", 12345);

        paciente = Generator.crearPaciente("Atilio", "Fernandez", 40123456, "Dolor de encía", obraSocial);
        paciente2 = Generator.crearPaciente("Patricia", "Gutierrez", 41123456, "Dolor de diente", obraSocial2);
        paciente3 = Generator.crearPaciente("Luisa", "Martinez", 25789321, "Tratamiento de caries", obraSocial3);

        consultorio.agregarPacientes(paciente);
        consultorio.agregarPacientes(paciente2);
        consultorio.agregarPacientes(paciente3);

        consultorio.encontrarPaciente(40123456);
        consultorio.encontrarPaciente(41123456);
        consultorio.encontrarPaciente(25789321);

        consultorio.eliminarPaciente(40123456);
        consultorio.eliminarPaciente(41123456);
        consultorio.eliminarPaciente(25789321);

        assertEquals((Integer) 0, consultorio.getCantidadPacientes());

    }

    @Test

    public void agregarOdontologo() { // TEST PARA AGREGAR ODONTOLOGO

        horaDeEntrada = "2021-01-01T08:00:00";
        horaDeEntrada2 = "2021-01-01T09:00:00";

        odontologo = Generator.crearOdontologo("Luis", "Olima", 28244423, 4456, horaDeEntrada, 5);
        odontologo2 = Generator.crearOdontologo("Emmanuel", "Castro", 38344423, 2202, horaDeEntrada2, 10);

        consultorio.agregarOdontologo(odontologo);
        consultorio.agregarOdontologo(odontologo2);

        assertEquals((Integer) 2, consultorio.getCantidadOdontologos());

    }

    @Test

    public void encontrarOdontologo() { // METODO PARA ENCONTRAR UN ODONTOLOGO

        horaDeEntrada = "2021-01-01T08:00:00";
        odontologo = Generator.crearOdontologo("Luis", "Olima", 28244423, 001, horaDeEntrada, 5);

        consultorio.agregarOdontologo(odontologo);
        consultorio.encontrarOdontologo(001);

        assertEquals((Integer) 001, odontologo.getMatriculaProfesional());
    }

    @Test

    public void modificarOdontologo() { // TEST PARA AGREGAR ODONTOLOGO

        horaDeEntrada = "2021-01-01T08:00:00";
        horaDeEntrada2 = "2021-01-01T09:00:00";

        odontologo = Generator.crearOdontologo("Luis", "Olima", 28244423, 001, horaDeEntrada, 5);
        odontologo2 = Generator.crearOdontologo("Emmanuel", "Castro", 38344423, 002, horaDeEntrada2, 10);

        consultorio.agregarOdontologo(odontologo);
        consultorio.agregarOdontologo(odontologo2);

        consultorio.encontrarOdontologo(001);
        consultorio.modificarOdontologo(odontologo2, 001);

        assertEquals((Integer) 001, odontologo.getMatriculaProfesional());

    }

    @Test

    public void eliminarOdontologo() { // TEST PARA ELIMINAR ODONTOLOGO

        horaDeEntrada = "2021-01-01T08:00:00";
        horaDeEntrada2 = "2021-01-01T09:00:00";

        odontologo = Generator.crearOdontologo("Luis", "Olima", 28244423, 001, horaDeEntrada, 5);
        odontologo2 = Generator.crearOdontologo("Emmanuel", "Castro", 38344423, 002, horaDeEntrada2, 10);

        consultorio.agregarOdontologo(odontologo);
        consultorio.agregarOdontologo(odontologo2);

        consultorio.encontrarOdontologo(001);
        consultorio.encontrarOdontologo(002);

        consultorio.eliminarOdontologo(001);
        consultorio.eliminarOdontologo(002);

        assertEquals((Integer) 0, consultorio.getCantidadOdontologos());

    }

    @Test(expected = OdontologoExisteException.class)

    public void agregarOdontologoExistente() {

        horaDeEntrada = "2021-01-01T08:00:00";
        odontologo = Generator.crearOdontologo("Luis", "Olima", 28244423, 001, horaDeEntrada, 5);

        consultorio.agregarOdontologo(odontologo);
        consultorio.agregarOdontologo(odontologo);

    }

    @Test(expected = OdontologoNoExisteException.class)
    public void encontrarOdontologoNoExistente() {

        horaDeEntrada = "2021-01-01T08:00:00";
        odontologo = Generator.crearOdontologo("Luis", "Olima", 28244423, 001, horaDeEntrada, 5);

        consultorio.agregarOdontologo(odontologo);
        consultorio.encontrarOdontologo(125);

    }

    @Test(expected = OdontologoNoExisteException.class)
    public void modificarOdontologoNoExistente() {

        horaDeEntrada = "2021-01-01T08:00:00";
        odontologo = Generator.crearOdontologo("Luis", "Olima", 28244423, 001, horaDeEntrada, 5);
        odontologo2 = Generator.crearOdontologo("Ruben", "Farias", 33344423, 2202, horaDeEntrada2, 10);

        consultorio.agregarOdontologo(odontologo);
        consultorio.encontrarOdontologo(123);
        consultorio.modificarOdontologo(odontologo2, 001);

    }

    @Test(expected = OdontologoNoExisteException.class)
    public void eliminarOdontologoNoExistente() {

        horaDeEntrada = "2021-01-01T08:00:00";
        odontologo = Generator.crearOdontologo("Luis", "Olima", 28244423, 001, horaDeEntrada, 5);

        consultorio.agregarOdontologo(odontologo);
        consultorio.encontrarOdontologo(123);
        consultorio.eliminarOdontologo(123);

    }

    @Test(expected = PacienteExisteException.class)
    public void encontrarPacienteExistente() {

        obraSocial = new ObraSocial("OSEP", 11122);
        paciente = Generator.crearPaciente("Atilio", "Fernandez", 40123456, "Dolor de encía", obraSocial);
        paciente2 = Generator.crearPaciente("Juan", "Ramirez", 40123456, "Dolor de diente", obraSocial2);

        consultorio.agregarPacientes(paciente);
        consultorio.agregarPacientes(paciente);
        consultorio.encontrarPaciente(40123456);

    }

    @Test(expected = PacienteNoExisteException.class)
    public void encontrarPacienteNoExistente() {

        obraSocial = new ObraSocial("OSEP", 11122);
        paciente = Generator.crearPaciente("Atilio", "Fernandez", 40123456, "Dolor de encía", obraSocial);

        consultorio.agregarPacientes(paciente);
        consultorio.encontrarPaciente(456123);

    }

    @Test(expected = PacienteNoExisteException.class)

    public void modificarPacienteExistente() {

        obraSocial = new ObraSocial("OSEP", 11122);
        paciente = Generator.crearPaciente("Atilio", "Fernandez", 40123456, "Dolor de encía", obraSocial);

        ObraSocial obraSocial2 = new ObraSocial("Osep", 000002);
        Paciente paciente2 = new Paciente("Javier", "Morales", 40346987, "tratamiento de conducto", obraSocial2);

        consultorio.agregarPacientes(paciente);
        consultorio.encontrarPaciente(41456789);
        consultorio.modificarPaciente(paciente2, 798456);

    }

    @Test
    public void agregarObraSocial() { // TEST PARA AGREGAR UNA OBRA SOCIAL

        obraSocial = new ObraSocial("OSEP", 11122);

        consultorio.agregarObraSocial(obraSocial);

        assertEquals((Integer) 1, consultorio.getcantidadObraSocial());
    }

    @Test(expected = ObraSocialExisteException.class)

    public void agregarObraSocialExistente() {

        obraSocial = new ObraSocial("OSEP", 11122);
        obraSocial2 = new ObraSocial("PAMI", 11123);
        obraSocial3 = new ObraSocial("PAMI", 11123);

        consultorio.agregarObraSocial(obraSocial);
        consultorio.agregarObraSocial(obraSocial2);
        consultorio.agregarObraSocial(obraSocial3);

    }

    @Test
    public void encontrarObraSocial() { // TEST PARA ENCONTRAR UNA OBRA SOCIAL

        obraSocial = new ObraSocial("OSEP", 11122);
        obraSocial2 = new ObraSocial("PAMI", 11123);
        obraSocial3 = new ObraSocial("SWISS MEDICAL", 11124);

        consultorio.agregarObraSocial(obraSocial);
        consultorio.agregarObraSocial(obraSocial2);
        consultorio.agregarObraSocial(obraSocial3);
        consultorio.encontrarObraSocial(11122);
        consultorio.encontrarObraSocial(11123);
        consultorio.encontrarObraSocial(11124);

        assertEquals((Integer) 11122, obraSocial.getCodigo());
        assertEquals((Integer) 11123, obraSocial2.getCodigo());
        assertEquals((Integer) 11124, obraSocial3.getCodigo());

    }

    @Test(expected = ObraSocialNoExisteException.class)
    public void encontrarObraSocialNoExistente() {

        obraSocial = new ObraSocial("OSEP", 11122);
        obraSocial2 = new ObraSocial("PAMI", 11123);
        obraSocial3 = new ObraSocial("SWISS MEDICAL", 11124);

        consultorio.agregarObraSocial(obraSocial);
        consultorio.agregarObraSocial(obraSocial2);
        consultorio.agregarObraSocial(obraSocial3);

        consultorio.encontrarObraSocial(000465);
        consultorio.encontrarObraSocial(000234);
        consultorio.encontrarObraSocial(006201);
        consultorio.encontrarObraSocial(006577);
        consultorio.encontrarObraSocial(000175);
    }

    @Test
    public void eliminarObraSocial() { // TEST PARA ELIMINAR UNA OBRA SOCIAL

        obraSocial = new ObraSocial("OSEP", 11122);
        obraSocial2 = new ObraSocial("PAMI", 11123);
        obraSocial3 = new ObraSocial("SWISS MEDICAL", 11124);

        consultorio.agregarObraSocial(obraSocial);
        consultorio.agregarObraSocial(obraSocial2);
        consultorio.agregarObraSocial(obraSocial3);

        consultorio.encontrarObraSocial(11122);
        consultorio.encontrarObraSocial(11123);
        consultorio.encontrarObraSocial(11124);

        consultorio.eliminarObraSocial(11122);
        consultorio.eliminarObraSocial(11123);
        consultorio.eliminarObraSocial(11124);

        assertEquals((Integer) 0, consultorio.getcantidadObraSocial());
    }

    @Test(expected = ObraSocialNoExisteException.class)
    public void eliminarObraSocialNoExistente() {

        obraSocial = new ObraSocial("OSEP", 11122);
        obraSocial2 = new ObraSocial("PAMI", 11123);
        obraSocial3 = new ObraSocial("SWISS MEDICAL", 11124);
        ObraSocial obraSocial4 = new ObraSocial("Andar", 006470);
        ObraSocial obraSocial5 = new ObraSocial("Osecac", 000140);
        ObraSocial obraSocial6 = new ObraSocial("ASE", 000150);
        ObraSocial obraSocial7 = new ObraSocial("OSUTHGRA", 007456);

        consultorio.agregarObraSocial(obraSocial);
        consultorio.agregarObraSocial(obraSocial2);
        consultorio.agregarObraSocial(obraSocial3);
        consultorio.agregarObraSocial(obraSocial4);
        consultorio.agregarObraSocial(obraSocial5);
        consultorio.agregarObraSocial(obraSocial6);
        consultorio.agregarObraSocial(obraSocial7);

        consultorio.encontrarObraSocial(000464);
        consultorio.encontrarObraSocial(000775);
        consultorio.encontrarObraSocial(006150);
        consultorio.encontrarObraSocial(001023);
        consultorio.encontrarObraSocial(000142);
        consultorio.encontrarObraSocial(001111);
        consultorio.encontrarObraSocial(007756);

        consultorio.eliminarObraSocial(000464);
        consultorio.eliminarObraSocial(000775);
        consultorio.eliminarObraSocial(006150);
        consultorio.eliminarObraSocial(001023);
        consultorio.eliminarObraSocial(000142);
        consultorio.eliminarObraSocial(001111);
        consultorio.eliminarObraSocial(007756);

    }

    @Test
    public void modificarObraSocial() { // TEST PARA MODIFICAR UNA OBRA SOCIAL

        obraSocial = new ObraSocial("OSEP", 11122);
        obraSocial2 = new ObraSocial("PAMI", 11123);
        obraSocial3 = new ObraSocial("SWISS MEDICAL", 11124);

        consultorio.agregarObraSocial(obraSocial);
        consultorio.agregarObraSocial(obraSocial2);
        consultorio.agregarObraSocial(obraSocial3);

        consultorio.encontrarObraSocial(11122);
        consultorio.encontrarObraSocial(11123);
        consultorio.encontrarObraSocial(11124);

        consultorio.modificarObraSocial(obraSocial, 11122);
        consultorio.modificarObraSocial(obraSocial2, 11123);
        consultorio.modificarObraSocial(obraSocial3, 11124);

        assertEquals((Integer) 11122, obraSocial.getCodigo());
        assertEquals((Integer) 11123, obraSocial2.getCodigo());
        assertEquals((Integer) 11124, obraSocial3.getCodigo());

    }

    @Test(expected = ObraSocialNoExisteException.class)
    public void modificarObraSocialNoExistente() {

        obraSocial = new ObraSocial("OSEP", 11122);
        obraSocial2 = new ObraSocial("PAMI", 11123);
        obraSocial3 = new ObraSocial("SWISS MEDICAL", 11124);

        consultorio.agregarObraSocial(obraSocial);
        consultorio.agregarObraSocial(obraSocial2);
        consultorio.agregarObraSocial(obraSocial3);

        consultorio.encontrarObraSocial(0006);
        consultorio.encontrarObraSocial(000657);
        consultorio.encontrarObraSocial(000656);

        consultorio.modificarObraSocial(obraSocial, 0006);
        consultorio.modificarObraSocial(obraSocial2, 000657);
        consultorio.modificarObraSocial(obraSocial3, 000656);

    }

    @Test(expected = ObraSocialNoExisteException.class)
    public void modificarObraSocialNoExistente2() {

        obraSocial = new ObraSocial("OSEP", 11122);
        obraSocial2 = new ObraSocial("PAMI", 11123);
        obraSocial3 = new ObraSocial("SWISS MEDICAL", 11124);

        consultorio.agregarObraSocial(obraSocial);
        consultorio.agregarObraSocial(obraSocial2);
        consultorio.agregarObraSocial(obraSocial3);

        consultorio.encontrarObraSocial(045665);
        consultorio.encontrarObraSocial(654987);
        consultorio.encontrarObraSocial(123456);

        consultorio.modificarObraSocial(obraSocial, 045665);
        consultorio.modificarObraSocial(obraSocial2, 654987);
        consultorio.modificarObraSocial(obraSocial3, 123456);

    }

    @Test

    public void comprobarDniIncorrecto() {

        Integer dniIncorrecto = 180;

        assertThrows(DniIncorrectoException.class, () -> consultorio.comprobarDni(dniIncorrecto)); // SE UTILIZA FUNCION
                                                                                                   // LAMBDA
        // (EN JAVA RUNNEABLE O
        // CONSUMMER)PARA CONVOCAR EL
        // METODO COMPROBAR DNI

    }

    @Test
    public void comprobarDniCorrecto() {
        Integer dniCorrecto = 41475451;
        Boolean bandera;
        try {

            consultorio.comprobarDni(dniCorrecto);

            bandera = true;

        } catch (DniIncorrectoException e) {

            bandera = false;

        }
        assertTrue(bandera);

    }

    @Test

    public void comprobarNombreIncorrecto() {

        String nombreIncorrecto = "Javier21";

        assertThrows(NombreIncorrectoException.class, () -> consultorio.comprobarNombre(nombreIncorrecto));

    }

    @Test
    public void comprobarNombreCorrecto() {
        String nombreCorrecto = "Lucas Olmos";
        Boolean bandera;
        try {

            consultorio.comprobarNombre(nombreCorrecto);

            bandera = true;

        } catch (NombreIncorrectoException e) {

            bandera = false;

        }
        assertTrue(bandera);

    }

 
}
