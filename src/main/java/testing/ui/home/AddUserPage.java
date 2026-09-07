package testing.ui.home;

import net.serenitybdd.screenplay.targets.Target;

public class AddUserPage {

    private AddUserPage() {
    }

    public static final Target INPUT_FIRST_NAME = Target
            .the("Etiqueta Nombre")
            .locatedBy("//input[@id='firstName']");

    public static final Target INPUT_LAST_NAME = Target
            .the("Etiqueta Apellido")
            .locatedBy("//input[@id='lastName']");

    public static final Target INPUT_EMAIL = Target
            .the("Etiqueta Correo")
            .locatedBy("//input[@id='email']");

    public static final Target INPUT_PASSWORD = Target
            .the("Etiqueta Contraseña")
            .locatedBy("//input[@id='password']");

    public static final Target BUTTON_SUBMIT = Target
            .the("boton ingresar")
            .locatedBy("//button[@id='submit']");


    public static final Target BUTTON_CANCEL = Target
            .the("boton para cancelar la creación de usuario")
            .locatedBy("//button[@id='cancel']");

    public static final Target SPAN_ERROR = Target
            .the("mensaje de error")
            .locatedBy("//span[@id='error']");

}
