@all
Feature: Registro de usuarios

  Background:
    Given el usuario se encuentra en el formulario de registro "Add User"

  @TC_001 @CreacionExitosa
  Scenario: Registrar un usuario utilizando datos válidos
    Given el usuario completa todos los campos obligatorios con datos válidos y un correo único
    When el usuario envía el formulario de registro
    Then debería ser redirigido a la página "Contact List"

  @TC_002 @CreacionDuplicada
  Scenario: Rechazar el registro utilizando un correo previamente registrado
    Given existe un usuario registrado
    And el usuario completa todos los campos obligatorios utilizando el correo del usuario existente
    When el usuario envía el formulario de registro
    Then debería visualizar un mensaje indicando que el correo ya está registrado
    And debería permanecer en el formulario "Add User"
