package utils;

import consultorio.cronograma.Horario;
import java.time.LocalDateTime;

public class HorarioUtils {

    // MANEJO DE HORARIOS
    public static Horario getSiguienteHorario(LocalDateTime localDateTime) { // BAJO LA SUPOSICION DE QUE SOLO SE PUEDE
        // INICIAR EN XX:00 o XX:30 - EN CASOS
        // DIFERENTES NO FUNCIONARIA, POR EJEMPLO
        // XX:15
        int hora = localDateTime.getHour();
        int minuto = localDateTime.getMinute();

        if (minuto == 30) {
            hora++;
            minuto = 0;
        } else {
            minuto = 30;
        }

        if (hora > 23) {
            hora = 0;
        }

        return new Horario(hora, minuto, 0, 0); // retorna objeto Horario (hora minuto segundos centesimas)

    }
}
