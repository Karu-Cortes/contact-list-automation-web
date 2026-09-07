package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;
import testing.ui.home.AddUserPage;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ClickButtonSubmit implements Task {

    private final Target button;

    public ClickButtonSubmit(Target button) {
        this.button = button;
    }

    @Override

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(button, isClickable()),
                Click.on(button)
        );

    }

    public static ClickButtonSubmit clickOn() {
        return clickOn(AddUserPage.BUTTON_SUBMIT);
    }

    public static ClickButtonSubmit clickOn(Target button) {
        return instrumented(ClickButtonSubmit.class, button);
    }
}
