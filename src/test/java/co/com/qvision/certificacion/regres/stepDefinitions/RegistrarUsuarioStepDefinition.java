package co.com.qvision.certificacion.regres.stepDefinitions;


import co.com.qvision.certificacion.regres.tasks.RegistraElUsuario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistrarUsuarioStepDefinition {


    @Cuando("el usuario {string} ingrese su trabajo {string}")
    public void elUsuarioIngreseSuTrabajo(String nombre, String trabajo) {
        theActorInTheSpotlight().attemptsTo(RegistraElUsuario.conElNombre(nombre).paraElTrabajo(trabajo));
        SerenityRest.lastResponse().print();
    }

    @Entonces("el usuario verá la información guardada exitosamente {string}")
    public void elUsuarioVeráLaInformaciónGuardadaExitosamente(String string) {

    }

}