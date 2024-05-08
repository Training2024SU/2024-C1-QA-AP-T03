Feature: Tablero de elementos deslizables
  yo como usario de la aplicación demoga
  quiero deslizar elementos en diferentes tableros
  para organizar mi información de manera personalizada
  #autor: Daniel Chaparro


# escenarios

  Background:
    Given que el usuario esta en la página de interacción

  @testTablero1
  Scenario: organizar lista
    When organiza su lista deslizando los items
    Then los elementos de la lista deberían estar organizados según el orden dado por el usuario

#  @test2
#  Scenario: organizar lista grid
#    When ingresa su informacion correctamente
#    And envia el formulario
#    Then deberia observar un mensaje de registro exitoso