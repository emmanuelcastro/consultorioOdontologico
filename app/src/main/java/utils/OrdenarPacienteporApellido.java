package utils;

import java.util.Comparator;

import consultorio.persona.Paciente;

public class OrdenarPacienteporApellido implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Paciente apellido1 = (Paciente) o1;

        Paciente apellido2 = (Paciente) o2;

        return apellido1.getApellido().compareTo(apellido2.getApellido());
    }

}
