package consultorio.persona;

import consultorio.DatosAnexos.ObraSocial;

public class Paciente extends Persona {

    private String motivoDeConsulta;
    private ObraSocial obraSocial;

    public Paciente(String nombre, String apellido, Integer dni, String motivoDeConsulta, ObraSocial obraSocial) {
        super(nombre, apellido, dni);
        this.motivoDeConsulta = motivoDeConsulta;
        this.obraSocial = obraSocial;
    }

    public Paciente(String nombre, String apellido, Integer dni, ObraSocial obraSocial) {
        super(nombre, apellido, dni);
        this.obraSocial = obraSocial;
    }

    public Integer getDni() {
        return super.getDni();
    }

    public String getNombre() {
        return super.getNombre();
    }

    public String getApellido() {
        return super.getApellido();
    }

    public String getMotivoDeConsulta() {
        return motivoDeConsulta;
    }

    public void setMotivoDeConsulta(String motivoDeConsulta) {
        this.motivoDeConsulta = motivoDeConsulta;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    @Override
    public String toString() {
        return super.getNombre() + " " + super.getApellido();
    }

}
