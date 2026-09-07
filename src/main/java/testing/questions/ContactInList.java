package testing.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.support.ui.WebDriverWait;
import testing.ui.home.ContactList;

import java.time.Duration;

public class ContactInList implements Question<Boolean> {
    private final String fullName;

    private ContactInList(String fullName) {
        this.fullName = fullName;
    }

    public static ContactInList named(String fullName) {
        return new ContactInList(fullName);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), Duration.ofSeconds(10))
                .withMessage("No se encontró el contacto " + fullName)
                .until(driver -> ContactList.CONTACT_CELLS.resolveAllFor(actor).stream()
                        .anyMatch(cell -> cell.isDisplayed() && fullName.equals(cell.getText().trim())));
    }
}
