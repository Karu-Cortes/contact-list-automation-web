package testing.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URI;
import java.time.Duration;
import java.util.Objects;

public class CurrentUrl implements Question<Boolean> {

    private static final String CONTACT_LIST_PATH = "/contactList";
    private static final String ADD_USER_PATH = "/addUser";
    private final String expectedPath;

    private CurrentUrl(String expectedPath) {
        this.expectedPath = expectedPath;
    }

    public static CurrentUrl isContactList() {
        return new CurrentUrl(CONTACT_LIST_PATH);
    }

    public static CurrentUrl isAddUser() {
        return new CurrentUrl(ADD_USER_PATH);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .withMessage("Se esperaba la ruta " + expectedPath)
                .until(browser -> expectedPath.equals(
                        URI.create(Objects.requireNonNull(browser.getCurrentUrl())).getPath()
                ));
    }
}
