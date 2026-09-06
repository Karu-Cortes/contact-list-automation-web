package testing.stepDefinitions.commons;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import testing.tasks.OpenPage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class CommonsStepDefinitions {

    @Given("el usuario se encuentra en el formulario de registro {string}")
    public void elUsuarioSeEncuentraEnElFormularioDeRegistro(String string) {
        theActorCalled("User").wasAbleTo(OpenPage.open());

    }

    @When("el usuario envía el formulario de registro")
    public void elUsuarioEnviaElFormularioDeRegistro() {

    }
}
