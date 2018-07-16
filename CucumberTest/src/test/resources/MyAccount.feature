Feature: My account
  Background: Login
    Given Accedo a la pagina "https://courses.ultimateqa.com/users/sign_in"
    When Me logueo en la aplicacion con
      |email   |automation.diplomado.dh@outlook.com|
      |password|Password123                        |
    Then En la pagina home debo ver el usuario "Automation D"

  Scenario: Como usuario, debo poder modificar "My profile" y los cambios deben ser guasrdados
    When Navego al menu "My Account"
    And Selecciono el tab "Profile"
    And Lleno los siguientes datos en profile form
      |company              |Digital Harbor|
      |professional title    |Quality Assurance Engineer|
    And Hago click en el boton Save Changes
    When Navego al tab "All Courses"
    And Navego al menu "My Account"
    And Selecciono el tab "Profile"
    Then Verifico que los siguientes datos en profile form
      |company              |Digital Harbor|
      |profesional title    |Quality Assurance Engineer|
    And Cierro session
