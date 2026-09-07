package testing.stepDefinitions.login;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import testing.tasks.ClickButtonSubmit;
import testing.tasks.LoginForm;
import testing.tasks.OpenPage;
import testing.ui.home.HomePage;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Login {

    @When("el usuario completa el formulario de inicio de sesión con los siguientes datos:")
    public void elUsuarioCompletaElFormularioDeInicioDeSesionConLosSiguientesDatos(DataTable datos) {
        Map<String, String> user = datos.asMaps(String.class, String.class).getFirst();
        theActorInTheSpotlight().attemptsTo(LoginForm.data(user));
    }

    @When("el usuario envía el formulario de inicio de sesión")
    public void elUsuarioEnviaElFormularioDeInicioDeSesion() {
        theActorInTheSpotlight().attemptsTo(
                ClickButtonSubmit.clickOn(HomePage.INPUT_LOGIN)
        );
    }
}
