@all
Feature: Registro de usuarios

  Background:
    Given el usuario se encuentra en el formulario de registro Add User


  @TC_001 @ValidacionesRegistro
  Scenario Outline: Rechazar el registro cuando un campo es inválido
    When el usuario completa el formulario de registro con los siguientes datos:
      | firstName | lastName | email   | password   |
      | <nombre>  | <apellido> | <correo> | <clave> |
    And el usuario envía el formulario de registro
    Then debería visualizar el mensaje de validación "<mensaje>"
    And debería permanecer en el formulario Add User

    Examples:
      | nombre | apellido | correo          | clave   | mensaje                                                                                                      |
      |        | Perez    | prueba@hola.com | Abc1234 | User validation failed: firstName: Path `firstName` is required.                                             |
      | Ana    |          | prueba@hola.com | Abc1234 | User validation failed: lastName: Path `lastName` is required.                                               |
      | Ana    | Perez    |                 | Abc1234 | User validation failed: email: Email is invalid                                                              |
      | Ana    | Perez    | prueba          | Abc1234 | User validation failed: email: Email is invalid                                                              |
      | Ana    | Perez    | prueba@hola.com |         | User validation failed: password: Path `password` is required.                                               |
      | Ana    | Perez    | prueba@hola.com | 123456  | User validation failed: password: Path `password` (`123456`) is shorter than the minimum allowed length (7). |

  @TC_002 @CreacionExitosa
  Scenario: Registrar un usuario utilizando datos válidos
    When el usuario completa el formulario de registro con los siguientes datos:
      | firstName | lastName | email                  | password      |
      | Pablo     | Rojas    | Pablo3.rojas1@test.com | testPablo1234 |
    And el usuario envía el formulario de registro
    Then debería ser redirigido a la página Contact List

  @TC_003 @CreacionDuplicada
  Scenario: Rechazar el registro utilizando un correo previamente registrado.
    When el usuario completa el formulario de registro con los siguientes datos:
      | firstName | lastName | email                  | password      |
      | Pablo     | Rojas    | Pablo3.rojas1@test.com | testPablo1234 |
    And el usuario envía el formulario de registro
    Then debería visualizar el mensaje de validación "Email address is already in use"
    And debería permanecer en el formulario Add User


