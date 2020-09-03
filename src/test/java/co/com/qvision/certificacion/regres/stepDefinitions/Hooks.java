package co.com.qvision.certificacion.regres.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hooks {
    private EnvironmentVariables environmentVariables;
    private String endpoint;

    @Before
    public void set_the_stage() {
        endpoint = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("endpoint.registro");
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que se haya ingresado el endpoint del servicio")
    public void queSeHayaIngresadoElEndpointDelServicio() {
        theActorCalled("juan").whoCan(CallAnApi.at(endpoint));
    }
}
