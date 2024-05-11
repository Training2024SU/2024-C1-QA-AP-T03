Feature: Organización de resultados de vuelos por menor duración en Despegar.com

  Yo como usuario
  Quiero ver los resultados de vuelos organizados por menor duración
  Para poder seleccionar la opción más conveniente y eficiente para mi viaje.

  Background:
    Given que el usuario está en la página resultados de vuelo de Despegar.com desde el navegador "Edge"

  @TestVueloMenorDuracion
  @rutacritica
  Scenario: Buscar vuelos de ida y vuelta organizados por menor duración
    When el usuario visualiza vuelos de ida y vuelta de "Bogotá" a "Cancún"
    And organiza los vuelos por menor duracion
    Then se deberían mostrar los resultados de vuelos de "Bogotá" a "Cancún"