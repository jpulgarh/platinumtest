Feature: Transacción

  Scenario: Registro de hora de una transacción
    Given Estoy abriendo la página de la transacción
    When Estoy viendo el detalle de una transacción
    Then Estoy guardando la hora de la transacción
