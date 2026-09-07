package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.home.ContactList;
import testing.ui.home.HomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ClickButtonNewContact implements Task {

    @Override

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(ContactList.BUTTON_ADD_NEW_CONTACT, isClickable()),
                Click.on(ContactList.BUTTON_ADD_NEW_CONTACT)
        );

    }

    public static ClickButtonNewContact clickOn() {
        return instrumented(ClickButtonNewContact.class);
    }
}
