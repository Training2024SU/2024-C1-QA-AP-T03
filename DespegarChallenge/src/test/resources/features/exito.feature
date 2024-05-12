Feature: Purchasing in Exito´s web page

  i as a user of the Exito web page
  want to browse through it
  to purchase some products or services

  Background:
    Given the user is in the web page 1



  @test1
  Scenario: Purchase a single product by category
    And adds to cart by category "Celulares" a cell phone "Celular Xiaomi Redmi 13C 256GB 8GB RAM Negro" selecting 3 units
    When goes to finalize the purchase with email "correopruebas1@gmail.com" name "Eric" last name "Cartman" id "Cédula ciudadanía" number "1152215765" cell phone "3110987654"
    And fills the delivery form state "Antioquia" city "Medellín-05001" addres type "Carrera" address numnber "99" "48" "50" neighborhood "San Javier" receives "Eric"
    Then should see a button with name Finalizar compra "Comprar ahora"

  @test2
  Scenario: Purchase three different products
    And adds to cart refrigerator "Nevera SAMSUNG No Frost Congelador Superior 236 LTS" 3 washing machine "Lavadora HACEB Carga Superior 11 kg" 2 and blender "'Licuadora Clásica Negra OSTER" 3
    When proceeds to finalize the purchase
    Then should see a confirmation message
