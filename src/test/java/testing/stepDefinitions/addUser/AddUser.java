package testing.stepDefinitions.addUser;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testing.questions.CurrentUrl;
import testing.questions.ValidationMessage;
import testing.tasks.RegistrationForm;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class AddUser {

    @When("el usuario completa el formulario de registro con los siguientes datos:")
    public void elUsuarioCompletaElFormularioDeRegistroConLosSiguientesDatos(DataTable datos) {
        Map<String, String> user = datos.asMaps(String.class, String.class).getFirst();
        theActorInTheSpotlight().remember("registrationUser", user);

        theActorInTheSpotlight().attemptsTo(
                RegistrationForm.data(user)
        );
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


}
