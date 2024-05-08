Feature: Datepicker
  Como usuario de la aplicación demoga
  Quiero poder ingresar fechas y horas en los calendarios interactivos
  Para programar eventos y citas de manera precisa
  #autor: Daniel Chaparro


# escenarios

  Background:
    Given que el usuario esta en la página de datepicker

  @datepicker
  @testDatepicker1
  Scenario: ingresar fecha
    When el usuario selecciona una fecha en el datepicker
    Then la fecha seleccionada debería mostrarse correctamente en el campo correspondiente

  @datepicker
  @testDatepicker2
  Scenario: ingresar fecha y hora
    When el usuario selecciona una fecha y hora en el datepicker
    Then la fecha y hora seleccionadas se muestran correctamente en el campo correspondiente