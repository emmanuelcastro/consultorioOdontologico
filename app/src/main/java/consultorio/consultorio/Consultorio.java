package consultorio.consultorio;

import java.util.ArrayList;

import consultorio.DatosAnexos.ObraSocial;
import consultorio.excepciones.*;
import consultorio.persona.Odontologo;
import consultorio.persona.Paciente;

public class Consultorio {

    private String nombre;
    private String direccion;
    private long telefono;
    private ArrayList<Odontologo> odontologos;
    private ArrayList<Paciente> pacientes;
    private ArrayList<ObraSocial> obrasSociales;
    private static Consultorio consultorio;

    private Consultorio(String nombre, String direccion, long telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        odontologos = new ArrayList<Odontologo>();
        pacientes = new ArrayList<Paciente>();
        obrasSociales = new ArrayList<ObraSocial>();
    }

    public static Consultorio getInstancia() {

        if (consultorio == null) {

            consultorio = new Consultorio("Consultorio Odontologico", "Avenida Virgen Del Valle 678", 154567854);

        }

        return consultorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Odontologo> getOdontologos() {
        return odontologos;
    }

    public void setOdontologos(ArrayList<Odontologo> odontologos) {
        this.odontologos = odontologos;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ArrayList<ObraSocial> getObrasSociales() {
        return obrasSociales;
    }

    public void setObrasSociales(ArrayList<ObraSocial> obrasSociales) {
        this.obrasSociales = obrasSociales;
    }

    public void clear() { // METODO QUE SE UTILIZA PARA ELIMINAR LOS ELEMENTOS DE LOS ARRAYLIST

        this.odontologos.clear();
        this.pacientes.clear();
        this.obrasSociales.clear();

    }

    /*------------------------------------------------------------------------*/
    public void agregarOdontologo(Odontologo odontologo) { // METODO PARA AGREGAR UN ODONTOLOGO

        for (Odontologo i : odontologos) {

            if (i.getMatriculaProfesional().equals(odontologo.getMatriculaProfesional())) {

                throw new OdontologoExisteException();

            }

        }
        odontologos.add(odontologo);
    }

    /*------------------------------------------------------------------------*/
    public Odontologo encontrarOdontologo(Integer matriculaProfesional) { // METODO PARA ENCONTRAR UN ODONTOLOGO

        Odontologo odontologoEncontrado = null;

        for (Odontologo aux : odontologos) {

            if (aux.getMatriculaProfesional() == matriculaProfesional) {

                odontologoEncontrado = aux;

                break;

            }

        }

        if (odontologoEncontrado == null) {

            throw new OdontologoNoExisteException();

        }

        return odontologoEncontrado;

    }

    /*------------------------------------------------------------------------*/

    public void modificarOdontologo(Odontologo odontologo, Integer matriculaProfesional) { // METODO PARA MODIFICAR UN
        // ODONTOLOGO

        Odontologo odontologoAEncontrar = encontrarOdontologo(matriculaProfesional);

        odontologos.remove(odontologoAEncontrar);

        this.odontologos.add(odontologo);

        if (odontologoAEncontrar == null) {

            throw new OdontologoNoExisteException();

        }

    }

    /*------------------------------------------------------------------------*/

    public void eliminarOdontologo(Integer matriculaProfesional) { // METODO PARA ELIMINAR UN ODONTOLOGO

        Odontologo odontologoParaEliminar = encontrarOdontologo(matriculaProfesional);

        odontologos.remove(odontologoParaEliminar);

    }

    public Integer getCantidadOdontologos() { // OBTENER LA CANTIDAD DE ODONTOLOGOS

        Integer cantidad = odontologos.size();

        return cantidad;

    }

    public void encontrarDniDeOdontologoExistente(Integer dni) { // METODO PARA
        // VALIDAR DNI DE ODONTOLOGO AL MODIFICAR

        for (Odontologo aux : odontologos) {

            if (aux.getDni().equals(dni)) {

                throw new OdontologoExisteException();

            }

        }

    }

    public void encontrarMatriculaDeOdontologoExistente(Integer matricula) { // METODO PARA
        // VALIDAR MATRICULA DE ODONTOLOGO AL MODIFICAR

        for (Odontologo aux : odontologos) {

            if (aux.getMatriculaProfesional().equals(matricula)) {

                throw new OdontologoExisteException();

            }

        }

    }

    /*------------------------------------------------------------------------*/
    /*------------------------------------------------------------------------*/
    /*------------------------------------------------------------------------*/

    public void agregarPacientes(Paciente paciente) { // METODO PARA AGREGAR UN PACIENTE

        for (Paciente i : pacientes) {

            if (i.equals(paciente)) {

                throw new PacienteExisteException();

            }

        }
        pacientes.add(paciente);
    }

    /*------------------------------------------------------------------------*/
    public Integer getCantidadPacientes() { // METODO PARA OBTENER LA CANTIDAD DE PACIENTES

        Integer cantidad = pacientes.size();

        return cantidad;

    }

    public void comprobarDni(Integer dni) { // SE UTILIZA UNA EXPRESION REGULAR PARA ENCONTRAR UNA DETERMINADA
                                            // COMBINACION DE CARACTERES, EN ESTE CASO CADA DIGITO INGRESADO DEBE ESTAR
                                            // ENTRE 0 Y 9 Y QUE TENGA ENTRE 7 Y 8 CARACTERES DIGITOS EN SU LONGITUD

        String dniAComprobar = dni.toString();

        if (dniAComprobar.matches("^[0-9]{7,8}$") == false) {

            throw new DniIncorrectoException();

        }

    }

    public void comprobarNombre(String nombre) { // SE ENCARGA DE COMPROBAR DE QUE LA PRIMERA LETRA SEA MAYUSCULA DE UN
                                                 // NOMBRE Y QUE SEA UNA LETRA ENTRE LA A Y LA Z

        if (!nombre.matches("^[A-Z][a-zA-Z ]+$")) {

            throw new NombreIncorrectoException();

        }

    }

    /*------------------------------------------------------------------------*/

    public void encontrarDniDePacienteExistente(Integer dni) { // METODO PARA VALIDAR DNI DE PACIENTE AL MODIFICAR

        for (Paciente aux : pacientes) {

            if (aux.getDni().equals(dni)) {

                throw new PacienteExisteException();

            }

        }

    }

    public Paciente encontrarPaciente(Integer dni) { // METODO PARA ENCONTRAR UN PACIENTE

        Paciente pacienteEncontrado = null;

        for (Paciente aux : pacientes) {

            if (aux.getDni().equals(dni)) {

                pacienteEncontrado = aux;

                break;

            }

        }

        if (pacienteEncontrado == null) {

            throw new PacienteNoExisteException();

        }

        return pacienteEncontrado;

    }

    /*------------------------------------------------------------------------*/

    public void modificarPaciente(Paciente paciente, Integer dni) { // METODO PARA MODIFICAR PACIENTE

        Paciente pacienteAEncontrar = encontrarPaciente(dni);

        pacientes.remove(pacienteAEncontrar);

        this.pacientes.add(paciente);

        if (pacienteAEncontrar == null) {

            throw new PacienteNoExisteException();

        }

    }

    /*------------------------------------------------------------------------*/

    public void eliminarPaciente(Integer dni) { // METODO PARA ELIMINAR PACIENTE

        Paciente pacienteParaEliminar = encontrarPaciente(dni);

        pacientes.remove(pacienteParaEliminar);

    }

    /*------------------------------------------------------------------------*/

    public void agregarObraSocial(ObraSocial obraSocial) { //

        for (ObraSocial i : obrasSociales) {

            if (i.getCodigo().equals(obraSocial.getCodigo())) {

                throw new ObraSocialExisteException();

            }

        }
        obrasSociales.add(obraSocial);
    }

    /*------------------------------------------------------------------------*/

    public void encontrarObraSocialExistente(Integer codigo) { // METODO PARA
        // VALIDAR CODIGO DE OBRA SOCIAL AL MODIFICAR

        for (ObraSocial aux : obrasSociales) {

            if (aux.getCodigo().equals(codigo)) {

                // ObraSocialEncontrada = aux;

                throw new ObraSocialExisteException();

            }

        }

    }

    public ObraSocial encontrarObraSocial(long codigo) { // METODO PARA ENCONTRAR LA OBRA SOCIAL

        ObraSocial ObraSocialEncontrada = null;

        for (ObraSocial aux : obrasSociales) {

            if (aux.getCodigo() == codigo) {

                ObraSocialEncontrada = aux;

                break;

            }

        }

        if (ObraSocialEncontrada == null) {

            throw new ObraSocialNoExisteException();

        }

        return ObraSocialEncontrada;

    }

    /*------------------------------------------------------------------------*/

    public void modificarObraSocial(ObraSocial obraSocial, long codigo) { // METODO PARA MODIFICAR LA OBRA SOCIAL

        ObraSocial ObraSocialAEncontrar = encontrarObraSocial(codigo);

        obrasSociales.remove(ObraSocialAEncontrar);

        this.obrasSociales.add(obraSocial);

        if (ObraSocialAEncontrar == null) {

            throw new ObraSocialNoExisteException();

        }

    }

    /*------------------------------------------------------------------------*/

    public void eliminarObraSocial(Integer codigo) { // METODO PARA ELIMINAR LA OBRA SOCIAL

        ObraSocial obraSocialParaEliminar = encontrarObraSocial(codigo);

        obrasSociales.remove(obraSocialParaEliminar);

    }

    /*------------------------------------------------------------------------*/
    public Integer getcantidadObraSocial() { // OBTENER LA CANTIDAD DE OBRAS SOCIALES

        Integer cantidad = obrasSociales.size();

        return cantidad;

    }

}
