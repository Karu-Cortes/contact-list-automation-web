package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import testing.ui.home.HomePage;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginWithTestCredentials implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> user = Map.of(
                "email", "Pablo.rojas1@test.com",
                "password", "testPablo1234"
        );

        actor.attemptsTo(
                OpenPage.open(),
                LoginForm.data(user),
                ClickButtonSubmit.clickOn(HomePage.INPUT_LOGIN)
        );
    }

    public static LoginWithTestCredentials login() {
        return instrumented(LoginWithTestCredentials.class);
    }
}
