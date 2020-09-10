package co.com.qvision.certificacion.regres.questions;

import co.com.qvision.certificacion.regres.models.RespuestaCreacionDeUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.qvision.certificacion.regres.utils.ObtenerFecha.fechaDelServicio;
import static co.com.qvision.certificacion.regres.utils.ObtenerFecha.fechaDelSistema;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

@Subject("Se compara la respuesta del servicio con los datos esperados")
public class LaCreacionDelUsuario implements Question<Boolean> {
    private String nombre;
    private String trabajo;

    public LaCreacionDelUsuario(String nombre, String trabajo) {
        this.nombre = nombre;
        this.trabajo = trabajo;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return lastResponse().jsonPath().getObject("", RespuestaCreacionDeUsuario.class).getNombre().equals(nombre)
                && lastResponse().jsonPath().getObject("", RespuestaCreacionDeUsuario.class).getTrabajo().equals(trabajo)
                && fechaDelServicio(lastResponse().jsonPath().getObject("", RespuestaCreacionDeUsuario.class).getCreatedAt()).contains(fechaDelSistema());
    }

    public static LaCreacionDelUsuario fueCorrecta(String nombre, String trabajo) {
        return new LaCreacionDelUsuario(nombre, trabajo);
    }
}
