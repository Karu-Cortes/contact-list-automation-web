package testing.tasks;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenPage implements Task {

    private static final EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();

    @Override

    public <T extends Actor> void performAs(T actor) {

        String url = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webdriver.base.url");


        actor.attemptsTo(
                Open.url(url)
        );
    }

    public static OpenPage open() {
        return instrumented(OpenPage.class);
    }
}
