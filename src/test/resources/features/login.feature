Feature: Login

  Scenario: Ingreso de nombre de usuario con datos almacenados en BD
    Given Estoy abriendo la página de inicio
    When Estoy ingresando el usuario "persona" y la clave "4r1c42012" y el rut "161111111"
    Then Estoy viendo la página de bienvenida

  Scenario: Ingreso de nombre de usuario y password con datos erróneos
    Given Estoy abriendo la página de inicio
    When Estoy ingresando el usuario "usuario_erroneo" y la clave "cualquier_cosa" y el rut "754647851"
    Then Estoy viendo el mensaje de error