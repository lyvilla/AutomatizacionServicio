package co.com.qvision.certificacion.regres.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hooks {
    private static final String ENDPOINT_REGRES="endpoint.registro";
    private EnvironmentVariables environmentVariables;
    private String endpoint;

    @Before
    public void set_the_stage() {
        endpoint = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(ENDPOINT_REGRES);
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que se haya ingresado el endpoint del servicio")
    public void queSeHayaIngresadoElEndpointDelServicio() {
        theActorCalled("Juan").whoCan(CallAnApi.at(endpoint));
    }
}
