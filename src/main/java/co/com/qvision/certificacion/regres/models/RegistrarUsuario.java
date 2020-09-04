package co.com.qvision.certificacion.regres.models;


import co.com.qvision.certificacion.regres.models.builders.RegistrarUsuarioBuilder;

public class RegistrarUsuario {

    private String nombre;
    private String trabajo;


    public RegistrarUsuario (RegistrarUsuarioBuilder builder){
        nombre=builder.getNombre();
        trabajo=builder.getTrabajo();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTrabajo() {
        return trabajo;
    }





}
