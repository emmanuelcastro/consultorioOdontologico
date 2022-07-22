package utils;

import consultorio.DatosAnexos.ObraSocial;
import consultorio.consultorio.Consultorio;
import consultorio.persona.Odontologo;
import consultorio.persona.Paciente;
import java.time.LocalDateTime;

public class Generator {

    public static ObraSocial crearObraSocial(String nombreDeObraSocial, Integer codigo) {
        return new ObraSocial(nombreDeObraSocial, codigo);
    }

    public static Odontologo crearOdontologo(String nombre, String apellido, Integer dni, int matricula,
            String horaDeEntrada, int cantidadTurnos) {
        return new Odontologo(nombre, apellido, dni, matricula, LocalDateTime.parse(horaDeEntrada), cantidadTurnos);
    }

    public static void agregarDosMedicosAlConsultorio(String horaDeEntrada, String horaDeEntrada2,
            Consultorio consultorio) {
        consultorio.agregarOdontologo(crearOdontologo("Test", "Test", 22244423, 4456, horaDeEntrada, 5));
        consultorio.agregarOdontologo(crearOdontologo("Alfredo", "Olima", 33344423, 4456, horaDeEntrada, 10));
    }

    public static void agregarUnMedicosAlConsultorio(Consultorio consultorio) {
        consultorio.agregarOdontologo(crearOdontologo("Test", "Test", 8888888, 8856, "2021-01-01T08:30:00", 5));
    }

    public static Paciente crearPaciente(String nombre, String apellido, Integer dni, String motivoDeConsulta,
            ObraSocial obraSocial) {
        return new Paciente(nombre, apellido, dni, motivoDeConsulta, obraSocial);
    }

    public static void agregarUnPacienteAlConsultorio(Consultorio consultorio, ObraSocial obraSocial) {
        consultorio.agregarPacientes(crearPaciente("Paciente", "Paciente", 22444777, "motivoDeConsulta", obraSocial));
    }

    public static void agregarDosPacientesAlConsultorio(ObraSocial obraSocial, ObraSocial obraSocial2,
            Consultorio consultorio) {
        consultorio.agregarPacientes(crearPaciente("Juan", "Quinteros", 22444777, "motivoDeConsulta", obraSocial));
        consultorio.agregarPacientes(crearPaciente("Martin", "Quiroga", 14888444, "motivoDeConsulta", obraSocial2));

    }

}
