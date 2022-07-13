package co.com.qvision.certificacion.regres.builders;


import co.com.qvision.certificacion.regres.intefaces.IBuilderIniciarSesion;
import co.com.qvision.certificacion.regres.models.IniciarSesionModel;

public class IniciarSesionBuilder implements IBuilderIniciarSesion {
    private String email;
    private String contrasena;

    public IniciarSesionBuilder(String email) {
        this.email = email;
    }// constructor

    public static IniciarSesionBuilder email(String email) {
        return new IniciarSesionBuilder(email);
    }

    public IniciarSesionModel yClave(String contrasena) {
        this.contrasena = contrasena;
        return this.build();
    }

    @Override
    public IniciarSesionModel build() {
        IniciarSesionModel iniciarSesion = new IniciarSesionModel();
        iniciarSesion.setContrasena(this.contrasena);
        iniciarSesion.setEmail(this.email);
        return iniciarSesion;
    }
}
