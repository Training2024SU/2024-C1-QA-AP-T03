Feature: obtener informacion de los servicios
  yo como usuario de los servicio de ZonaFit
  quiero revisar los datos registrados
  para poder acceder a su informacion

#Autor: Julio Vasquez

  Background:
    Given un usuario administrador en la página web de ZonaFit

  @task1
  Scenario Outline: Obtener los datos de una fecha
    And consulta por la fecha <fecha>
    When envía la solicitud para obtener la informacion
    Then deberia tener una respuesta con el codigo <codigo>
    And la informacion recibida deberia concidir con la fecha <fecha>
    Examples:
      | fecha    | codigo |
      | 20200501 | 200    |
      | 20200305 | 200    |

  @task2
  Scenario Outline: Obtener la informacion por estado
    When se pide al servicio la informacion por estado <estado>
    Then deberia recibir una respuesta con el codigo 200
    And deberia recibir la informacion del estado <estado>
    Examples:
      | estado |
      | "ca"   |
      | "ar"   |
      | "al"   |