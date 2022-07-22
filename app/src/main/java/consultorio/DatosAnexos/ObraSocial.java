package consultorio.DatosAnexos;

public class ObraSocial {

    private String nombreDeObraSocial;
    private Integer codigo;

    public ObraSocial(String nombreDeObraSocial, Integer codigo) {
        this.nombreDeObraSocial = nombreDeObraSocial;
        this.codigo = codigo;
    }

    public String getNombreDeObraSocial() {
        return nombreDeObraSocial;
    }

    public void setNombreDeObraSocial(String nombreDeObraSocial) {
        this.nombreDeObraSocial = nombreDeObraSocial;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {  //SE UTILIZO UN METODO toString() PARA MOSTRAR LA INFORMACION DE UN OBJETO

        return nombreDeObraSocial;
        
    }

}
