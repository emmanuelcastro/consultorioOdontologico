package utils;

import java.util.Comparator;
import consultorio.persona.Paciente;

public class OrdenarPacientePorDni implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Paciente dni1 = (Paciente) o1;

        Paciente dni2 = (Paciente) o2;

        int resultado = -1;

        // ESTE METODO COMPARA AMBOS OBJETOS Y SI LA COMPARACION ES POSITIVA EL VALOR ES
        // 1 ES MAYOR QUE 2. SI ES 0 SON IGUALES Y SI ES NEGATIVO EL VALOR 2 ES MAYOR

        if (dni1.getDni() == dni2.getDni()) {

            resultado = (int) (dni1.getDni() - dni2.getDni());

        } else {

            resultado = (int) (dni1.getDni() - dni2.getDni());

        }

        return resultado;

    }

}
