package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import testing.ui.home.HomePage;

import java.util.Map;
import java.util.Objects;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginForm implements Task {

    private final Map<String, String> data;

    public LoginForm(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(Objects.toString(data.get("email"), "")).into(HomePage.INPUT_EMAIL),
                Enter.theValue(Objects.toString(data.get("password"), "")).into(HomePage.INPUT_PASSWORD)
        );
    }

    public static LoginForm data(Map<String, String> data) {
        return instrumented(LoginForm.class, data);
    }
}
