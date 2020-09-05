package co.com.qvision.certificacion.regres.questions;

import co.com.qvision.certificacion.regres.models.RespuestaCreacionDeUsuario;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class LaCreacionDelUsuario implements Question<Boolean> {
    private String nombre;
    private String trabajo;

    public LaCreacionDelUsuario(String nombre, String trabajo) {
        this.nombre = nombre;
        this.trabajo = trabajo;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        System.out.println(trabajo);
        RespuestaCreacionDeUsuario creacion = lastResponse().jsonPath().getObject("", RespuestaCreacionDeUsuario.class);
        return creacion.getNombre().equals(nombre) && creacion.getTrabajo().equals(trabajo);
    }

    public static LaCreacionDelUsuario fueCorrecta(String nombre, String trabajo) {
        return new LaCreacionDelUsuario(nombre, trabajo);
    }
}
