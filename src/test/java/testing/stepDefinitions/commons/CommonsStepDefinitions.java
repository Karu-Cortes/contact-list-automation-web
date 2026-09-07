package testing.stepDefinitions.commons;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import testing.questions.ValidationMessage;
import testing.questions.CurrentUrl;
import testing.tasks.ClickButtonSignUp;
import testing.tasks.ClickButtonSubmit;
import testing.tasks.OpenPage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CommonsStepDefinitions {

    @Given("el usuario se encuentra en el formulario de registro {string}")
    public void elUsuarioSeEncuentraEnElFormularioDeRegistro(String string) {
        theActorCalled("User").wasAbleTo(OpenPage.open());
        theActorInTheSpotlight().attemptsTo(
                ClickButtonSignUp.clickOn()
        );

    }

    @Given("el usuario se encuentra en la página de inicio de sesión")
    public void elUsuarioSeEncuentraEnLaPaginaDeInicioDeSesion() {
        theActorCalled("User").wasAbleTo(OpenPage.open());
    }

    @Then("debería visualizar el mensaje de validación {string}")
    public void deberiaVisualizarElMensajeDeValidacion(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat(ValidationMessage.text(), equalTo(mensaje))
        );
    }

    @Then("debería ser redirigido a la página Contact List")
    public void deberiaSerRedirigidoALaPaginaContactList() {
        theActorInTheSpotlight().should(
                seeThat(CurrentUrl.isContactList(), equalTo(true))
        );
    }

    @When("el usuario envía el formulario de registro")
    public void elUsuarioEnviaElFormularioDeRegistro() {
        theActorInTheSpotlight().attemptsTo(
                ClickButtonSubmit.clickOn()
        );
    }

    @And("debería permanecer en el formulario Add User")
    public void deberiaPermanecerEnElFormularioAddUser() {
        theActorInTheSpotlight().should(
                seeThat(CurrentUrl.isAddUser(), equalTo(true))
        );
    }
}
