@all
Feature: inicio de sesión

  Background:
    Given el usuario se encuentra en la página de inicio de sesión


  @TC_004 @InicioSesionFallido
  Scenario: Iniciar sesión con credenciales inválidas
    When el usuario completa el formulario de inicio de sesión con los siguientes datos:
      | email                 | password      |
      | Pablo.rojas1@test.com | wrongPassword |
    And el usuario envía el formulario de inicio de sesión
    Then debería visualizar el mensaje de validación "Incorrect username or password"

  @TC_005 @InicioSesionExitoso
  Scenario: Iniciar sesión con credenciales válidas
    When el usuario completa el formulario de inicio de sesión con los siguientes datos:
      | email                 | password      |
      | Pablo.rojas1@test.com | testPablo1234 |
    And el usuario envía el formulario de inicio de sesión
    Then debería ser redirigido a la página Contact List

