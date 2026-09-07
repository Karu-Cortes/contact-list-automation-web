package testing.ui.home;

import net.serenitybdd.screenplay.targets.Target;

public class AddContact {

    private AddContact() {
    }

    public static final Target INPUT_FIRST_NAME = Target
            .the("Etiqueta Nombre")
            .locatedBy("//input[@id='firstName']");

    public static final Target INPUT_LAST_NAME = Target
            .the("Etiqueta Apellido")
            .locatedBy("//input[@id='lastName']");

    public static final Target INPUT_BIRTHDAY = Target
            .the("Etiqueta Fecha de nacimiento")
            .locatedBy("//input[@id='birthdate']");

    public static final Target INPUT_EMAIL = Target
            .the("Etiqueta Correo electrónico")
            .locatedBy("//input[@id='email']");

    public static final Target INPUT_PHONE = Target
            .the("Etiqueta Teléfono")
            .locatedBy("//input[@id='phone']");

    public static final Target INPUT_ADDRESS1 = Target
            .the("Etiqueta Dirección 1")
            .locatedBy("//input[@id='street1']");

    public static final Target INPUT_ADDRESS2 = Target
            .the("Etiqueta Dirección 2")
            .locatedBy("//input[@id='street2']");

    public static final Target INPUT_CITY = Target
            .the("Etiqueta Ciudad")
            .locatedBy("//input[@id='city']");

    public static final Target INPUT_STATE = Target
            .the("Etiqueta Provincia")
            .locatedBy("//input[@id='stateProvince']");

    public static final Target INPUT_POSTAL_CODE = Target
            .the("Etiqueta Código postal")
            .locatedBy("//input[@id='postalCode']");

    public static final Target INPUT_COUNTRY = Target
            .the("Etiqueta País")
            .locatedBy("//input[@id='country']");

    public static final Target INPUT_MESSAGE_ERROR = Target
            .the("Etiqueta Mensaje de error")
            .locatedBy("//span[@id='error']");

    public static final Target BUTTON_SUBMIT = Target
            .the("Botón registrar contacto")
            .locatedBy("//button[@id='submit']");

   public static final Target BUTTON_CANCEL = Target
            .the("Botón cancelar registro de contacto")
            .locatedBy("//button[@id='cancel']");
}
