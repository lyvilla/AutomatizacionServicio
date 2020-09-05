package co.com.qvision.certificacion.regres.stepDefinitions;

import co.com.qvision.certificacion.regres.exceptions.CrearUsuarioException;
import co.com.qvision.certificacion.regres.questions.LaCreacionDelUsuario;
import co.com.qvision.certificacion.regres.tasks.RegistrarEl;

import static co.com.qvision.certificacion.regres.exceptions.CrearUsuarioException.CODIGO_RESPUESTA;
import static co.com.qvision.certificacion.regres.exceptions.CrearUsuarioException.COMPARACION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static co.com.qvision.certificacion.regres.models.builders.RegistrarUsuarioBuilder.ElUsuario;

import co.com.qvision.certificacion.regres.utils.CodigoDeRespuesta;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;


import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class RegistrarUsuarioStepDefinitions {


    @Cuando("el usuario {string} ingrese su trabajo {string}")
    public void elUsuarioIngreseSuTrabajo(String nombre, String trabajo) {
        theActorInTheSpotlight().attemptsTo(RegistrarEl.usuario(ElUsuario(nombre).ParaElTrabajo(trabajo)));
        SerenityRest.lastResponse().print();
    }

    @Entonces("el usuario {string} verá el trabajo {string} creado exitosamente con la respuesta {string}")
    public void elUsuarioVeráElTrabajoCreadoExitosamenteConLaRespuesta(String nombre, String trabajo,
                                                                       String codigoRespuesta) {
        theActorInTheSpotlight().should(
                seeThatResponse("El código de respuesta es correcto",
                        response -> response
                                .statusCode(CodigoDeRespuesta.valueOf(codigoRespuesta).getCodigo())
                                .statusLine(CodigoDeRespuesta.valueOf(codigoRespuesta).getMensaje())
                                .body("nombre", equalTo("Juan")))
                                .orComplainWith(CrearUsuarioException.class, CODIGO_RESPUESTA),
                                 seeThat(
                                       LaCreacionDelUsuario
                                               .fueCorrecta(nombre, trabajo), equalTo(true))
                                       .orComplainWith(CrearUsuarioException.class, COMPARACION)
        );


    }
}

