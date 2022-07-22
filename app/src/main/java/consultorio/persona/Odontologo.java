package consultorio.persona;

import java.time.LocalDateTime;

import consultorio.cronograma.Agenda;
import consultorio.cronograma.IAgenda;

public class Odontologo extends Persona {

    private Integer matriculaProfesional;
    private IAgenda agenda;
    private LocalDateTime horaDeEntrada;
    private Integer cantidadDeTurnosDiarios;

    public Odontologo(String nombre, String apellido, Integer dni, Integer matriculaProfesional,
            LocalDateTime horaDeEntrada, Integer cantidadDeTurnosDiarios) {
        super(nombre, apellido, dni);
        this.matriculaProfesional = matriculaProfesional;
        this.horaDeEntrada = horaDeEntrada;
        this.cantidadDeTurnosDiarios = cantidadDeTurnosDiarios;
        inicializarAgenda();
    }

    @Override
    public String toString() {
        return "Odontologo{" + "matriculaProfesional=" + matriculaProfesional + ", agenda=" + agenda
                + ", HoraDeEntrada=" + horaDeEntrada + ", cantidadDeTurnosDiarios=" + cantidadDeTurnosDiarios + '}';
    }

    public Integer getMatriculaProfesional() {
        return matriculaProfesional;
    }

    public void setMatriculaProfesional(Integer matriculaProfesional) {
        this.matriculaProfesional = matriculaProfesional;
    }

    public IAgenda getAgenda() {
        return agenda;
    }

    public void setAgenda(IAgenda agenda) {
        this.agenda = agenda;
    }

    public LocalDateTime getHoraDeEntrada() {
        return horaDeEntrada;
    }

    public void setHoraDeEntrada(LocalDateTime horaDeEntrada) {
        this.horaDeEntrada = horaDeEntrada;
    }

    public Integer getCantidadDeTurnosDiarios() {
        return cantidadDeTurnosDiarios;
    }

    public void setCantidadDeTurnosDiarios(Integer cantidadDeTurnosDiarios) {
        this.cantidadDeTurnosDiarios = cantidadDeTurnosDiarios;
    }

    public void inicializarAgenda() { // METODO PARA INICIALIZAR LA AGENDA DE UN ODONTOLOGO
        agenda = new Agenda(getHoraDeEntrada());
        agenda.definirNumeroDeTurnos(cantidadDeTurnosDiarios);
    }

}
