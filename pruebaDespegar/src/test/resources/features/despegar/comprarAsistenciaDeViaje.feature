#language:es
  #encoding:UTF-8
  #Author: Devon Jose Alvarez Osorio

Característica: proceso compra de asitencia de viaje en la pagina Despegar.com
  Yo como usuario de la pagina Despegar.com
  quiero poder comprar asistencias de viaje
  para recibir soporte surante le viaje

  @test3
  Escenario: compra exitosa de asistencia de viaje
    Dado que el usuario esta en la pagina de asistencia
    Cuando completa todos los campos con informacion valida
    Y elije la opcion que desea comprar
    Entonces deberia ser dirigido a la opcion de pago

