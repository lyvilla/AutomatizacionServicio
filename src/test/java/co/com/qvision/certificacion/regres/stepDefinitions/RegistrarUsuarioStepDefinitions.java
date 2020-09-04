package co.com.qvision.certificacion.regres.stepDefinitions;

import co.com.qvision.certificacion.regres.tasks.RegistrarEl;
import static co.com.qvision.certificacion.regres.models.builders.RegistrarUsuarioBuilder.ElUsuario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;



import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
public class RegistrarUsuarioStepDefinitions {


    @Cuando("el usuario {string} ingrese su trabajo {string}")
    public void elUsuarioIngreseSuTrabajo(String nombre, String trabajo) {
        theActorInTheSpotlight().attemptsTo(RegistrarEl.usuario(ElUsuario(nombre).ParaElTrabajo(trabajo)));
        SerenityRest.lastResponse().print();
    }

    @Entonces("el usuario vera la informacion guardada exitosamente {string}")
    public void elUsuarioVeraLaInformacionGuardadaExitosamente(String string) {

    }
}
