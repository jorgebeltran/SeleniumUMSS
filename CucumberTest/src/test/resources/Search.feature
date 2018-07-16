Feature: Search
  Background: Login
    Given Accedo a la pagina "https://courses.ultimateqa.com/users/sign_in"
    #When Lleno el campo email con "automation.diplomado.dh@outlook.com"
    #And Lleno el campo password con "Password123"
    When Me logueo en la aplicacion con
      |email   |automation.diplomado.dh@outlook.com|
      |password|Password123                        |
    #And Hago click en el boton Sing In
    Then En la pagina home debo ver el usuario "Automation D"

  Scenario Outline: Como usuario, debo poder realizar busqueda de cursos
    When Navego al tab "All Courses"
    And Lleno el campo search con "<course>"
    Then El curso "<course>" debe ser mostrado en home page
    And Cierro session
  Examples:
    |course                                                |
    |C# For QA Automation Engineers with Selenium Webdriver|
    |What are Implicit and Explicit Waits                  |

    Scenario Outline: Como usuario, cuando realizo una busqueda sin resultados,
      un mensaje de error debe ser mostrado
      When Navego al tab "All Courses"
      And Lleno el campo search con "<course>"
      Then El mensaje que dice "Search result for" "<course>" es mostrado
      And Cierro session
      Examples:
        |course        |
        |InvalidCourse |
        |NotExistCourse|



