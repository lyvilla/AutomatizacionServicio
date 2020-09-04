package co.com.qvision.certificacion.regres.tasks;

import co.com.qvision.certificacion.regres.interactions.Post;
import co.com.qvision.certificacion.regres.models.RegistrarUsuario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.qvision.certificacion.regres.utils.Constantes.RECURSO_CREAR_USUARIO;

public class RegistrarEl implements Task {

    public static final String APLICACION = "application/json; charset=utf-8";
    public static final String ACCEPT = "*/*";

    private final RegistrarUsuario registrarUsuario;

    public RegistrarEl(RegistrarUsuario registrarUsuario) {
        this.registrarUsuario = registrarUsuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(RECURSO_CREAR_USUARIO)
                .with(request -> request.contentType(APLICACION)
                .accept(ACCEPT)
                .body(registrarUsuario)
                .relaxedHTTPSValidation()
                .urlEncodingEnabled(false)
                ));
    }

   public static RegistrarEl usuario(RegistrarUsuario registrarUsuario){
        return Tasks.instrumented(RegistrarEl.class, registrarUsuario);

    }

}
