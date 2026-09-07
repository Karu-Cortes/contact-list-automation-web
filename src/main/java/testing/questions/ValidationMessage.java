package testing.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.home.AddUserPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidationMessage implements Question<String> {

    public static ValidationMessage text() {
        return new ValidationMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(AddUserPage.SPAN_ERROR, isVisible())
        );

        return Text.of(AddUserPage.SPAN_ERROR).answeredBy(actor);
    }
}
