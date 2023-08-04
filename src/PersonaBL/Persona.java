package PersonaBL;

public class Persona {

    private String codigo;
    private String cedula;
    private String nombre;
    private String fechaNac;
    private String signoZ;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getSignoZ() {
        return signoZ;
    }

    public void setSignoZ(String signoZ) {
        this.signoZ = signoZ;
    }
}