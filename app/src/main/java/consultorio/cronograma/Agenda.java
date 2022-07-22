package consultorio.cronograma;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import utils.HorarioUtils;
import consultorio.excepciones.PacienteNoExisteException;
import consultorio.excepciones.TurnoNoExisteException;

public class Agenda implements IAgenda {

    private LocalDateTime horaDelPrimerTurno;
    private Map<Integer, Turno> listaTurnos = new HashMap<>();

    public Agenda(LocalDateTime horaDelPrimerTurno) {
        this.horaDelPrimerTurno = horaDelPrimerTurno;
    }

    public Map<Integer, Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(Map<Integer, Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    // ADMINISTRACION DE TURNOS
    // FUNCION QUE SE VA A ENCARGAR DE ESTABLECER TANTOS TURNOS COMO EL ODONTOLOGO
    // DISPONGA
    public void definirNumeroDeTurnos(Integer cantidadDeTurnos) {

        for (int i = 0; i < cantidadDeTurnos; i++) {

            listaTurnos.put(i, null); // ASOCIA EL VALOR CON LA CLAVE DEL MAPA --RESUME: CREAR Y UPDATE: SI NO EXISTE
                                      // LO CREA Y SI EXISTE LO ACTUALIZA
            // INDICE DEL TURNO
            // ESTA NULO PORQUE NO ESTA DISPONIBLE
        }

    }

    public Turno crearNuevoTurno(Integer indice, Turno turno) { // ASOCIAR UN TURNO EN LA AGENDA A UN SITIO PREFERIDO
        // DEFINIMOS QUE HORARIO VA A TENER EL TURNO

        if (turno.getPaciente() == null) {

            throw new TurnoNoExisteException();

        }

        if (indice == 0) { // SI EL INDICE ES IGUAL A 0 (KEY) SIGNIFICA QUE ES EL PRIMER TURNO

            turno.setFechayHoraDelTurnoDelPaciente(this.horaDelPrimerTurno);
            // el turno viene sin hora y hay q settear hora
        } else {

            turno.setFechayHoraDelTurnoDelPaciente(this.calcularHoraDelTurno(indice));

        }

        return listaTurnos.putIfAbsent(indice, turno); // AGREGA UN ELEMENTO CON EL VALOR ESPECIFICADO (null , turno)
        // PONER SI ESTA AUSENTE //DEVUELVE EL TURNO CREADO
        // SI RETORNA EL TURNO ES PORQUE YA ESTABA ASOCIADO, Y SI RETORNA NULL ES PORQUE
        // SE ACTUALIZO EL NUEVO TURNO Y NULL ES LO ANTERIOR QUE TENIA

    }

    public void actualizarTurno(Integer indice, Turno turno) { // ACTUALIZAR TURNOS

        listaTurnos.put(indice, turno); // ASOCIA EL VALOR CON LA CLAVE DEL MAPA

    }

    public Turno buscarPacientePorDni(Integer dni) { // SE BUSCA UN PACIENTE EN BASE AL DNI

        Turno pacienteEncontrado = null;
        // RECORRE EL MAPA, EL ENTRY RECORRE UN OBJETO ITERABLE, INGRESO ES CADA UNO DE
        // LOS ELEMENTOS POR ITERACION
        for (Map.Entry<Integer, Turno> ingreso : listaTurnos.entrySet()) { // OBTIENE LA COLECCION DE TODOS LOS OBJETOS
            // DE PARES CLAVE-VALOR EN LA COLECCION DE MAPAS

            if (ingreso.getValue() != null) { // CONDICION PARA EVITAR UN NULLPOINTEREXCEPTION

                if (ingreso.getValue().getPaciente().getDni().equals(dni)) {

                    pacienteEncontrado = ingreso.getValue();

                }

            }

        }

        if (pacienteEncontrado == null) {

            throw new PacienteNoExisteException();

        }
        return pacienteEncontrado;
    }

    public Turno buscarPacientePorFechaYHora(LocalDateTime fechaYHora) { // SE BUSCA UN PACIENTE POR FECHA Y HORA

        Turno pacienteEncontrado = null;
        for (Map.Entry<Integer, Turno> ingreso : listaTurnos.entrySet()) {

            if (ingreso.getValue() != null) { // CONDICION PARA EVITAR UN NULLPOINTEREXCEPTION

                if (ingreso.getValue().getFechayHoraDelTurnoDelPaciente().isEqual(fechaYHora)) {

                    pacienteEncontrado = ingreso.getValue();

                }

            }

        }

        if (pacienteEncontrado == null) {

            throw new PacienteNoExisteException();

        }

        return pacienteEncontrado;

    }

    public boolean eliminarTurno(Turno turno) { // SE REMUEVE UN TURNO, DEJANDOLO DISPONIBLE SOLAMENTE SI EL TURNO
        // EXISTE
        if (listaTurnos.containsValue(turno)) { // PREGUNTAMOS SI EXISTE UN TURNO (EN UNA POSICION DE MEMORIA)
            // SI EXISTE EL TURNO EN EL MAPA, SI EXISTE SE ACTUALIZA PONIENDOLO EN NULO
            listaTurnos.put(buscarTurno(turno), null);
            return true;

        }

        return false;

    }

    public Integer buscarTurno(Turno turno) { // RETORNA EL INDICE DADO UN VALOR

        Integer turnoEncontrado = null; // VARIABLE BANDERA ESTABLECIDA COMO TURNO NO ENCONTRADO

        for (Map.Entry<Integer, Turno> ingreso : this.listaTurnos.entrySet()) {

            if (Objects.equals(turno, ingreso.getValue())) { // SI EL VALOR COMPARADO EXISTE CON LA ITERACION ACTUAL SE
                // PROCEDE A RETORNAR LA KEY
                // COMPARA OBJETOS
                turnoEncontrado = ingreso.getKey();

                // RETORNA LA CLAVE

            }

        }

        if (turnoEncontrado == null) {

            throw new TurnoNoExisteException();

        }

        return turnoEncontrado;
    }

    public boolean modificarTurno(Turno turno, Turno turnoParaAgregar) { // SE MODIFICA UN TURNO, DEJANDOLO DISPONIBLE
        // SOLAMENTE SI EL TURNO EXISTE

        if (listaTurnos.containsValue(turno)) { // PREGUNTAMOS SI EXISTE UN TURNO (EN UNA POSICION DE MEMORIA)

            listaTurnos.put(buscarTurno(turno), turnoParaAgregar); //SE HACE USO DE LA FUNCION BUSCAR TURNO PASANDO COMO PARAMETRO EL TURNO
            return true;

        }

        return false;

    }

    public LocalDateTime calcularHoraDelTurno(Integer cantidadDeTurnosDiarios) { // SE PROCEDE A ITERAR PARA CALCULAR LA HORA DEL TURNO
        // SELECCIONADO
        LocalDateTime horaActual = this.horaDelPrimerTurno; // EL INDICE RECIBIDO ES EL INDICE DONDE IRIA EL TURNO

        for (int i = 0; i < cantidadDeTurnosDiarios; i++) { // RECORREMOS EL FOR PARA IR SUMANDO 30 MINUTOS DEPENDIENDO DEL VALOR DEL
                                           // INDICE DEL TURNO A ASIGNAR

            Horario horarioTemp = HorarioUtils.getSiguienteHorario(horaActual); // ES ESTATICO PARA NO TENER QUE
                                                                                // INSTANCIARLO CADA VEZ QUE SE LLAMA A
                                                                                // UN UTILS.

            horaActual = LocalDateTime.of(LocalDate.now(), LocalTime.of(horarioTemp.getHours(),
                    horarioTemp.getMinutes(), horarioTemp.getSeconds(), horarioTemp.getNanoSeconds()));

            // LA CLASE UTILS YA VIENE CON HORA, MINUTOS, SEGUNDOS PARA CONSTRUIR
            // LOCALDATETIME

        }

        return horaActual;

    }

    public int cantidadDeTurnosPorAgenda() { // OBTENER LA CANTIDAD DE TURNOS POR AGENDA

        return listaTurnos.size();

    }

    public int cantidadDeTurnosAsignados() { // METODO PARA OBTENER LA CANTIDAD DE TURNOS ASIGNADOS

        int i = 0;

        for (Map.Entry<Integer, Turno> ingreso : this.listaTurnos.entrySet()) {

            if (ingreso.getValue() != null) // CONDICION PARA EVITAR UN NULLPOINTEREXCEPTION
            {

                i++;

            }

        }

        return i;

    }

    public int cantidadDeTurnosDisponibles() { // METODO PARA OBTENER LA CANTIDAD DE TURNOS DISPONIBLES

        int cantidadDisponible = cantidadDeTurnosAsignados();
        return listaTurnos.size() - cantidadDisponible;

    }

}
