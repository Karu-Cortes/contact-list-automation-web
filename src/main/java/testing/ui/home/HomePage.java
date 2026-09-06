package testing.ui.home;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    private HomePage() {
    }

    public static final Target BOTON_SING_UP = Target
            .the("botón Registrarse")
            .locatedBy("//button[@id='signup']");
}


