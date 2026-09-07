package testing.stepDefinitions.addUser;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import testing.tasks.RegistrationForm;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AddUser {

    @When("el usuario completa el formulario de registro con los siguientes datos:")
    public void elUsuarioCompletaElFormularioDeRegistroConLosSiguientesDatos(DataTable datos) {
        Map<String, String> user = datos.asMaps(String.class, String.class).getFirst();
        theActorInTheSpotlight().remember("registrationUser", user);

        theActorInTheSpotlight().attemptsTo(
                RegistrationForm.data(user)
        );
    }


}
