package testing.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import testing.ui.home.AddContact;

import java.util.Map;
import java.util.Objects;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ContactForm implements Task {
    private final Map<String, String> data;

    public ContactForm(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AddContact.INPUT_FIRST_NAME, isVisible()),
                Enter.theValue(Objects.toString(data.get("firstName"), "")).into(AddContact.INPUT_FIRST_NAME),
                Enter.theValue(Objects.toString(data.get("lastName"), "")).into(AddContact.INPUT_LAST_NAME),
                Enter.theValue(Objects.toString(data.get("birthdate"), "")).into(AddContact.INPUT_BIRTHDAY),
                Enter.theValue(Objects.toString(data.get("email"), "")).into(AddContact.INPUT_EMAIL),
                Enter.theValue(Objects.toString(data.get("phone"), "")).into(AddContact.INPUT_PHONE),
                Enter.theValue(Objects.toString(data.get("street1"), "")).into(AddContact.INPUT_ADDRESS1),
                Enter.theValue(Objects.toString(data.get("street2"), "")).into(AddContact.INPUT_ADDRESS2),
                Enter.theValue(Objects.toString(data.get("city"), "")).into(AddContact.INPUT_CITY),
                Enter.theValue(Objects.toString(data.get("stateProvince"), "")).into(AddContact.INPUT_STATE),
                Enter.theValue(Objects.toString(data.get("postalCode"), "")).into(AddContact.INPUT_POSTAL_CODE),
                Enter.theValue(Objects.toString(data.get("country"), "")).into(AddContact.INPUT_COUNTRY)
        );
    }

    public static ContactForm data(Map<String, String> data) {
        return instrumented(ContactForm.class, data);
    }
}
