package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.home.AddUserPage;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ClickButtonSubmit implements Task {

    @Override

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(AddUserPage.BUTTON_SUBMIT, isClickable()),
                Click.on(AddUserPage.BUTTON_SUBMIT)
        );

    }

    public static ClickButtonSubmit clickOn() {
        return instrumented(ClickButtonSubmit.class);
    }
}
