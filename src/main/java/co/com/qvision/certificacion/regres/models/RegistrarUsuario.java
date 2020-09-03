package co.com.qvision.certificacion.regres.models;

public class RegistrarUsuario {

    private String nombre;
    private String trabajo;

    public RegistrarUsuario(String nombre, String trabajo) {
        this.nombre = nombre;
        this.trabajo = trabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTrabajo() {
        return trabajo;
    }
}
