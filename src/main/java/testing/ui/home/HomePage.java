package testing.ui.home;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    private HomePage() {
    }

    public static final Target INPUT_EMAIL = Target
            .the("Etiqueta Correo usuario")
            .locatedBy("//input[@id='email']");

    public static final Target INPUT_PASSWORD = Target
            .the("Etiqueta Contraseña usuario")
            .locatedBy("//input[@id='password']");

    public static final Target INPUT_LOGIN = Target
            .the("boton ingresar")
            .locatedBy("//button[@id='submit']");

    public static final Target BUTTON_SIGN_UP = Target
            .the("botón Registrarse")
            .locatedBy("//button[@id='signup']");
}


