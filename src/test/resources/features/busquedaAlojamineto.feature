Feature: Búsqueda de alojamiento en Despegar.com
  Como usuario de Despegar.com,
  Quiero buscar alojamiento
  Para encontrar opciones convenientes para mi viaje

  Background:
    Given el usuario está en la página de inicio de Despegar.com desde el navegador "Edge"

  @TestAlojamiento
  Scenario: Buscar alojamiento
    When el usuario selecciona el apartado de alojamiento
    And el usuario ingresa el origen "Bogotá, Bogotá D.C., Colombia" destino "Cancún, Quintana Roo, México" del alojamiento, fecha de entrada "2024-05-20" y de salida "2024-06-20"
    And el usuario ingresa el número de habitaciones 4
    And el usuario presiona el botón de buscar alojamiento
    Then se deberían mostrar los resultados de alojamiento disponibles para las fechas y destinos especificados
