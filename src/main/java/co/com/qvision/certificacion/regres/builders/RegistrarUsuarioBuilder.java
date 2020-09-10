package co.com.qvision.certificacion.regres.builders;

import co.com.qvision.certificacion.regres.intefaces.IBuilderRegistrarUsuario;
import co.com.qvision.certificacion.regres.models.IniciarSesionModel;
import co.com.qvision.certificacion.regres.models.RegistrarUsuarioModel;

public class RegistrarUsuarioBuilder implements IBuilderRegistrarUsuario {
    private String nombre;
    private String trabajo;


    public RegistrarUsuarioBuilder(String nombre) {
        this.nombre = nombre;
    }

    public static RegistrarUsuarioBuilder nombre(String nombre) {
        return new RegistrarUsuarioBuilder(nombre);

    }

    public RegistrarUsuarioModel yTrabajo(String trabajo) {
        this.trabajo = trabajo;
        return this.build();
    }

    @Override
    public RegistrarUsuarioModel build() {
        RegistrarUsuarioModel registrar = new RegistrarUsuarioModel();
        registrar.setNombre(this.nombre);
        registrar.setTrabajo(this.trabajo);
        return registrar;
    }
}
