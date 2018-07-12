Feature: Search
  Scenario Outline: Como usuario, debo poder realizar busqueda de cursos
    Given Accedo a la pagina "https://courses.ultimateqa.com/users/sign_in"
    When Lleno el campo email con "automation.diplomado.dh@outlook.com"
    And Lleno el campo password con "Password123"
    And Hago click en el boton Sing In
    Then En la pagina home debo ver el usuario "Automation D"
    When Lleno el campo search con "<course>"
    Then El curso "<course>" debe ser mostrado en home page
    And Cierro session
  Examples:
    |course                                                |
    |C# For QA Automation Engineers with Selenium Webdriver|
    |What are Implicit and Explicit Waits                  |
