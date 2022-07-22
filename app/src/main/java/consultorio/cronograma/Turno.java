package consultorio.cronograma;

import java.time.LocalDateTime;
import consultorio.persona.Paciente;

public class Turno {

    private LocalDateTime fechayHoraDelTurnoDelPaciente;
    private Paciente paciente;

    public Turno(LocalDateTime fechayHoraDelTurnoDelPaciente, Paciente paciente) {

        this.fechayHoraDelTurnoDelPaciente = fechayHoraDelTurnoDelPaciente;
        this.paciente = paciente;

    }

    public Turno(Paciente paciente) {

        this.paciente = paciente;

    }

    public LocalDateTime getFechayHoraDelTurnoDelPaciente() {
        return fechayHoraDelTurnoDelPaciente;
    }

    public void setFechayHoraDelTurnoDelPaciente(LocalDateTime fechayHoraDelTurnoDelPaciente) {
        this.fechayHoraDelTurnoDelPaciente = fechayHoraDelTurnoDelPaciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Turno{" + "fechayHoraDelTurnoDelPaciente=" + fechayHoraDelTurnoDelPaciente + ", paciente=" + paciente
                + '}';
    }

}
