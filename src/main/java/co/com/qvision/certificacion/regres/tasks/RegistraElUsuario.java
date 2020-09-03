package co.com.qvision.certificacion.regres.tasks;

import static co.com.qvision.certificacion.regres.utils.Constantes.RECURSO_CREAR_USUARIO;

import co.com.qvision.certificacion.regres.models.RegistrarUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;


public class RegistraElUsuario implements Task {
    private String nombre;
    private String trabajo;
    public static final String APLICACION = "application/json; charset=utf-8";
    public static final String ACCEPT = "*/*";

    public RegistraElUsuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(RECURSO_CREAR_USUARIO)
                .with(request -> request
                        .contentType(APLICACION)
                        .accept(ACCEPT)
                        .relaxedHTTPSValidation()
                        .urlEncodingEnabled(false)
                        .body(new RegistrarUsuario(nombre, trabajo))));
    }

    public static RegistraElUsuario conElNombre(String nombre) {
        return Tasks.instrumented(RegistraElUsuario.class, nombre);
    }

    public RegistraElUsuario paraElTrabajo(String trabajo) {
        this.trabajo = trabajo;
        return this;
    }
}
