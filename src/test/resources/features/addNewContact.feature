@all
Feature: Registro de contactos

  Background:
    Given el usuario se encuentra en el formulario de registro Add a new contact

  @TC_006 @ValidacionesContacto
  Scenario Outline: Mostrar el mensaje de error al registrar un contacto sin nombre o apellido
    When el usuario completa el formulario de contacto con los siguientes datos:
      | firstName | lastName   | birthdate    | email    | phone      | street1      | street2      | city     | stateProvince | postalCode     | country |
      | <nombre>  | <apellido> | <nacimiento> | <correo> | <telefono> | <direccion1> | <direccion2> | <ciudad> | <provincia>   | <codigoPostal> | <pais>  |
    And el usuario envía el formulario de contacto
    Then debería visualizar el mensaje de validación "<mensaje>"
    And debería permanecer en el formulario Add a new contact

    Examples:
      | nombre | apellido | nacimiento | correo           | telefono   | direccion1    | direccion2 | ciudad | provincia | codigoPostal | pais     | mensaje                                                             |
      |        | Riaño    | 1990-05-15 | LorenaR@test.com | 3001234567 | Calle 123 #45 | Apto 201   | Bogota | Bogota DC | 110111       | Colombia | Contact validation failed: firstName: Path `firstName` is required. |
      | Lorena |          | 1990-05-15 | LorenaR@test.com | 3001234567 | Calle 123 #45 | Apto 201   | Bogota | Bogota DC | 110111       | Colombia | Contact validation failed: lastName: Path `lastName` is required.   |

  @TC_008 @ValidacionesFormatoContacto
  Scenario Outline: Rechazar el registro de un contacto cuando la fecha de nacimiento o el correo tienen un formato inválido
    When el usuario completa el formulario de contacto con los siguientes datos:
      | firstName | lastName | birthdate    | email    | phone      | street1       | street2  | city   | stateProvince | postalCode | country  |
      | Lorena    | Riaño    | <nacimiento> | <correo> | 3001234567 | Calle 123 #45 | Apto 201 | Bogota | Bogota DC     | 110111     | Colombia |
    And el usuario envía el formulario de contacto
    Then debería visualizar el mensaje de validación "<mensaje>"
    And debería permanecer en el formulario Add a new contact

    Examples:
      | nacimiento | correo           | mensaje                                                    |
      | Lorena     | LorenaR@test.com | Contact validation failed: birthdate: Birthdate is invalid |
      | 15-05-1990 | LorenaR@test.com | Contact validation failed: birthdate: Birthdate is invalid |
      | 1990-05-15 | LorenaR@test     | Contact validation failed: email: Email is invalid         |
      | 15/05/1990 | LorenaR@test.com | Contact validation failed: birthdate: Birthdate is invalid |
      | 1990-05-15 | prueba           | Contact validation failed: email: Email is invalid         |

  @TC_007 @CreacionContactoExitosa
  Scenario Outline: Registrar un contacto utilizando datos válidos
    When el usuario completa el formulario de contacto con los siguientes datos:
      | firstName | lastName   | birthdate    | email    | phone      | street1      | street2      | city     | stateProvince | postalCode     | country |
      | <nombre>  | <apellido> | <nacimiento> | <correo> | <telefono> | <direccion1> | <direccion2> | <ciudad> | <provincia>   | <codigoPostal> | <pais>  |
    And el usuario envía el formulario de contacto
    Then debería ser redirigido a la página Contact List
    And debería visualizar el contacto "<nombre> <apellido>" en la lista de contactos

    Examples:
      | nombre | apellido | nacimiento | correo       | telefono   | direccion1    | direccion2 | ciudad | provincia | codigoPostal | pais     |
      | Lorena | Riaño    | 1990-05-15 | ana@test.com | 3001234567 | Calle 123 #45 | Apto 201   | Bogota | Bogota DC | 110111       | Colombia |
      | Luis   | Gomez    |            |              |            |               |            |        |           |              |          |
