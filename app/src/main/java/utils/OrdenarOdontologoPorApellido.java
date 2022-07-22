package utils;

import java.util.Comparator;

import consultorio.persona.Odontologo;

public class OrdenarOdontologoPorApellido implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Odontologo apellido1 = (Odontologo) o1;

        Odontologo apellido2 = (Odontologo) o2;

        return apellido1.getApellido().compareTo(apellido2.getApellido());
    }

}
