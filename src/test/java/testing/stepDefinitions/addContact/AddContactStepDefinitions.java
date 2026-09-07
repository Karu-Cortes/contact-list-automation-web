package testing.stepDefinitions.addContact;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testing.questions.ContactInList;
import testing.questions.CurrentUrl;
import testing.tasks.ClickButtonSubmit;
import testing.tasks.ContactForm;
import testing.ui.home.AddContact;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class AddContactStepDefinitions {

    @When("el usuario completa el formulario de contacto con los siguientes datos:")
    public void completarFormulario(DataTable datos) {
        theActorInTheSpotlight().attemptsTo(
                ContactForm.data(datos.asMaps(String.class, String.class).getFirst())
        );
    }

    @When("el usuario envía el formulario de contacto")
    public void enviarFormulario() {
        theActorInTheSpotlight().attemptsTo(
                ClickButtonSubmit.clickOn(AddContact.BUTTON_SUBMIT)
        );
    }

    @Then("debería permanecer en el formulario Add a new contact")
    public void permanecerEnFormulario() {
        theActorInTheSpotlight().should(
                seeThat(CurrentUrl.isAddContact(), equalTo(true))
        );
    }

    @Then("debería visualizar el contacto {string} en la lista de contactos")
    public void visualizarContacto(String nombreCompleto) {
        theActorInTheSpotlight().should(
                seeThat(ContactInList.named(nombreCompleto), equalTo(true))
        );
    }
}
