#Autor: Andreina Iglesias

Feature: Listar datos sobre el COVID-19 con los Servicios API de Zona Fit
  Como usuario de Zona Fit
  Quiero poder ver información actualizada sobre COVID-19
  Para estar informado sobre la situación de salud pública

  @todos
  @testcorrecto
  Scenario: Obtener datos historicos para un estado, de forma exitosa
    Given el usuario ingresa un codigo de estado especifico
    When realiza una solicitud GET para ver informacion sobre el Covid en dicho estado
    Then el servicio deberia responder con un estado HTTP 200 OK y recibir todos los datos historicos para dicha zona

  @todos
  @testincorrecto
  Scenario: Obtener datos historicos para un estado, de forma no exitosa
    Given el usuario no ingresa un codigo de estado requerido
    When realiza una solicitud GET para ver informacion sobre el Covid en dicho estado
    Then el servicio deberia responder con un estado HTTP 404 y no recibiria los datos historicos para dicha zona

@todos
@testcorrecto
  Scenario: Obtener datos para todos los estados, de forma exitosa
    When el usuario realiza una solicitud GET para ver informacion sobre el Covid en todos los estados
    Then el servicio deberia responder con un estado HTTP 200 OK y recibir todos los datos para cada estado


