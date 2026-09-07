package testing.stepDefinitions.commons;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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
