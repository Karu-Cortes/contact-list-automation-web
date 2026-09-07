package testing.ui.home;

import net.serenitybdd.screenplay.targets.Target;

public class ContactList {

    private ContactList() {
    }

    public static final Target CONTACT_CELLS = Target
            .the("celdas de la lista de contactos")
            .locatedBy("table td");

    public static final Target BUTTON_ADD_NEW_CONTACT = Target
            .the("Boton para agregar nuevo contacto")
            .locatedBy("//button[@id='add-contact']");

    public static final Target BUTTON_LOGOUT = Target
            .the("Boton para salir")
            .locatedBy("//button[@id='logout']");

}
