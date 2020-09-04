package co.com.qvision.certificacion.regres.models.builders;

import co.com.qvision.certificacion.regres.models.RegistrarUsuario;

public class RegistrarUsuarioBuilder{
    private String nombre;
    private String trabajo;


    public RegistrarUsuarioBuilder(String nombre) {
        this.nombre = nombre;
    }

    public static RegistrarUsuarioBuilder ElUsuario(String nombre) {
        return new RegistrarUsuarioBuilder(nombre);

    }
        public RegistrarUsuario ParaElTrabajo(String trabajo){
        this.trabajo=trabajo;
        return this.build();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public RegistrarUsuario build() {
        return new RegistrarUsuario(this);
    }


}
