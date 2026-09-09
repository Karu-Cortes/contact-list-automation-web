package testing.stepDefinitions.addUser;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import testing.tasks.RegistrationForm;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AddUser {

    private static final String UNIQUE_EMAIL_MARKER = "correo_unico_registro";
    private static final String UNIQUE_REGISTRATION_EMAIL = "pablo.rojas." + System.currentTimeMillis() + "@test.com";
    //long milisegundos para que el correo sea único.

    @When("el usuario completa el formulario de registro con los siguientes datos:")
    public void elUsuarioCompletaElFormularioDeRegistroConLosSiguientesDatos(DataTable datos) {
        Map<String, String> user = new HashMap<>(datos.asMaps(String.class, String.class).getFirst());
        user.computeIfPresent("email", (key, email) ->
                UNIQUE_EMAIL_MARKER.equals(email) ? UNIQUE_REGISTRATION_EMAIL : email
        );

        theActorInTheSpotlight().remember("registrationUser", user);

        theActorInTheSpotlight().attemptsTo(
                RegistrationForm.data(user)
        );
    }


}
