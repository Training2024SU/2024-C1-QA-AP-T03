
Feature: Listar datos sobre el COVID-19 con los Servicios API de Zona Fit
  Como usuario de Zona Fit
  Quiero poder ver información actualizada sobre COVID-19
  Para estar informado sobre la situacion de salud publica

 #Usar 1 para navegador Chrome y 2 para Edge
  Background:
  #Given que el usuario selecciona el navegador 1 e ingresa al servicio

  Scenario: Obtener todos los datos historicos para un estado especifico
    And el usuario ingresa un codigo de estado especifico
    When realiza una solicitud GET para ver informacion sobre el Covid en dicho estado
    Then el servicio deberia responder con un estado HTTP 200 OK y recibir todos los datos historicos para dicha zona


  #Scenario: Acceder a recursos relacionados con COVID-19
  #  When el usuario busca información adicional sobre COVID-19
   # Then debería tener acceso a recursos confiables de información sobre COVID-19
   # And debería poder acceder a enlaces a sitios web de salud pública y recursos relevantes.

