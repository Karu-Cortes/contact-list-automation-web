package testing.stepDefinitions.addUser;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddUser {

    @Given("el usuario completa todos los campos obligatorios con datos válidos y un correo único")
    public void elUsuarioCompletaTodosLosCamposObligatoriosConDatosValidosYUnCorreounico() {

    }

    @Then("debería ser redirigido a la página {string}")
    public void deberiaSerRedirigidoALaPagina(String string) {

    }

    @Given("existe un usuario registrado")
    public void existeUnUsuarioRegistrado() {
    }

    @And("el usuario completa todos los campos obligatorios utilizando el correo del usuario existente")
    public void elUsuarioCompletaTodosLosCamposObligatoriosUtilizandoElCorreoDelUsuarioExistente() {
    }

    @Then("debería visualizar un mensaje indicando que el correo ya está registrado")
    public void deberiaVisualizarUnMensajeIndicandoQueElCorreoYaEstaRegistrado() {
    }

    @And("debería permanecer en el formulario {string}")
    public void deberiaPermanecerEnElFormulario(String arg0) {
    }
}
