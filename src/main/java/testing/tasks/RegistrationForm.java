package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import testing.ui.home.AddUserPage;

import java.util.Map;
import java.util.Objects;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegistrationForm implements Task {

    private final Map<String, String> data;

    public RegistrationForm(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(value("firstName")).into(AddUserPage.INPUT_FIRST_NAME),
                Enter.theValue(value("lastName")).into(AddUserPage.INPUT_LAST_NAME),
                Enter.theValue(value("email")).into(AddUserPage.INPUT_EMAIL),
                Enter.theValue(value("password")).into(AddUserPage.INPUT_PASSWORD)
        );
    }

    private String value(String campo) {
        return Objects.toString(data.get(campo), "");
    }

    public static RegistrationForm data(Map<String, String> data) {
        return instrumented(RegistrationForm.class, data);
    }
}
