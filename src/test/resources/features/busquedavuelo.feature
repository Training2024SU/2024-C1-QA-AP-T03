Feature: Búsqueda de vuelos en Despegar.com
  Yo como usuario
  Quiero buscar vuelos en Despegar.com
  Para planificar mis viajes de manera conveniente y eficiente.

  Background:
  Given que el usuario está en la página de inicio de Despegar.com desde el navegador "Edge"

@TestVuelo
  Scenario Outline: Buscar un vuelo de ida y vuelta
    When el usuario ingresa el origen <origen>, destino <destino> del vuelo, fecha de ida <fecha_salida> y de vuelta <fecha_regreso>
    And selecciona el numero de personas mayores de edad <personas>
    And el usuario presiona el botón de buscar vuelos
    Then se debería mostrar los resultados de vuelos disponibles para las fechas y destinos especificados
    And los resultados deberían incluir opciones de vuelo de ida y vuelta
    Examples:
    | origen                            | destino                           | fecha_salida    | fecha_regreso   | personas |
    |"Bogotá, Bogotá D.C., Colombia"    |"Cancún, Quintana Roo, México"     | "2024-05-20"    | "2024-06-20"    | 3        |
    | "Lima, Peru"                      | "Miami, Florida, Estados Unidos"  | "2024-05-20"    | "2024-08-20"    | 4        |
    | "Santiago, Chile"                 | "Buenos Aires, Argentina"         | "2024-06-10"    | "2024-09-20"    | 3        |
    | "Buenos Aires, Argentina"         | "Paris, France"                   | "2024-07-05"    | "2024-08-15"    | 4        |