package consultorio;

import java.time.LocalDateTime;

import consultorio.consultorio.Consultorio;
import consultorio.persona.Odontologo;
import utils.Generator;
import utils.HorarioUtils;

public class PruebaGeneradorDeHoras {

    public static void main(String[] args) {

        String horaDeEntrada = "2021-11-23T09:00:00";

        Odontologo odontologo = Generator.crearOdontologo("Luis", "Olima", 28244423, 4456, horaDeEntrada, 10);

        Consultorio consultorio = Consultorio.getInstancia();

        consultorio.agregarOdontologo(odontologo);

        for (int i = 0; i < odontologo.getCantidadDeTurnosDiarios(); i++) {

            System.out.println(odontologo.getAgenda().calcularHoraDelTurno(i));

        }

      
    }

}
