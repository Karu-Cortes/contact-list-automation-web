package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.home.HomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ClickButtonSignUp implements Task {

    @Override

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(HomePage.BUTTON_SIGN_UP, isClickable()),
                Click.on(HomePage.BUTTON_SIGN_UP)
        );

    }

    public static ClickButtonSignUp clickOn() {
       return instrumented(ClickButtonSignUp.class);
    }
}
