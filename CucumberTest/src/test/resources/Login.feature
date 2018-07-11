Feature: Login

  Scenario: Como usuario, debo poder acceder a la aplicacion con email and password correctos
    Given Accedo a la pagina "https://courses.ultimateqa.com/users/sign_in"
    When Lleno el campo email con "automation.diplomado.dh@outlook.com"
    And Lleno el campo password con "Password123"
    And Hago click en el boton Sing In
    Then En la pagina home debo ver el usuario "Automation D"

