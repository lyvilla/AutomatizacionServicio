package co.com.qvision.certificacion.regres.stepDefinitions;

import co.com.qvision.certificacion.regres.builders.IniciarSesionBuilder;
import co.com.qvision.certificacion.regres.exceptions.CrearUsuarioException;
import co.com.qvision.certificacion.regres.models.IniciarSesionModel;
import co.com.qvision.certificacion.regres.questions.LaCreacionDelUsuario;
import co.com.qvision.certificacion.regres.tasks.IniciaSesion;
import co.com.qvision.certificacion.regres.tasks.RegistrarElUsuario;

import static co.com.qvision.certificacion.regres.builders.IniciarSesionBuilder.email;
import static co.com.qvision.certificacion.regres.exceptions.CrearUsuarioException.CODIGO_RESPUESTA;
import static co.com.qvision.certificacion.regres.exceptions.CrearUsuarioException.COMPARACION;
import static co.com.qvision.certificacion.regres.builders.RegistrarUsuarioBuilder.nombre;
import static co.com.qvision.certificacion.regres.utils.CodigoDeRespuesta.valueOf;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static co.com.qvision.certificacion.regres.utils.Constantes.MENSAJE_RESPUESTA;

public class RegistrarUsuarioStepDefinitions {


    @Cuando("el usuario {string} ingrese su trabajo {string}")
    public void elUsuarioIngreseSuTrabajo(String nombre, String trabajo) {
        theActorInTheSpotlight().attemptsTo(RegistrarElUsuario.conLosDatos(nombre(nombre).yTrabajo(trabajo)));
    }

    @Entonces("el usuario {string} verá el trabajo {string} creado exitosamente con la respuesta {string}")
    public void elUsuarioVeráElTrabajoCreadoExitosamenteConLaRespuesta(String nombre, String trabajo,
                                                                       String codigoRespuesta) {
        theActorInTheSpotlight().should(
                seeThatResponse(MENSAJE_RESPUESTA,
                        response -> response
                                .statusCode(valueOf(codigoRespuesta).getCodigo())
                                .statusLine(valueOf(codigoRespuesta).getMensaje()))
                        .orComplainWith(CrearUsuarioException.class, CODIGO_RESPUESTA),
                seeThat(LaCreacionDelUsuario.fueCorrecta(nombre, trabajo), equalTo(true))
                        .orComplainWith(CrearUsuarioException.class, COMPARACION)
        );
    }

    @Cuando("el usuario inicie sesión erroneamente")
    public void elUsuarioInicieSesiónErroneamente(List<IniciarSesionModel> datos) {
        System.out.println(datos);
        theActorInTheSpotlight()
                .attemptsTo(IniciaSesion
                        .conLosDatos(email(datos.get(0).getEmail())
                                .yClave(datos.get(0).getContrasena())));
    }

    @Entonces("el usuario vera el mensaje de error {string}")
    public void elUsuarioVeraElMensajeDeError(String mensajeError) {
        theActorInTheSpotlight().should(
                seeThatResponse(MENSAJE_RESPUESTA,
                        response -> response
                                .statusCode(valueOf(mensajeError).getCodigo())
                                .body("error", equalTo(valueOf(mensajeError).getMensaje())))
                        .orComplainWith(CrearUsuarioException.class, CODIGO_RESPUESTA));

    }

}

