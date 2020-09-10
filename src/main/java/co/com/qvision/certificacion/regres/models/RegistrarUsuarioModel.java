package co.com.qvision.certificacion.regres.models;


import co.com.qvision.certificacion.regres.builders.RegistrarUsuarioBuilder;

public class RegistrarUsuarioModel {

    private String nombre;
    private String trabajo;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }
}
