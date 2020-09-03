package co.com.qvision.certificacion.regres.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/registrar_usuario.feature"
        , glue = "co/com/qvision/certificacion/regres/stepDefinitions"
        //, tags = "@laboratorio or @validacionDeCampos"
        //, tags = "@produccion"
        , snippets = CAMELCASE)
public class RegistrarUsuarioRunner {
}
