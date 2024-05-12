#language:es
  #encoding:UTF-8
  #Author: Devon Jose Alvarez Osorio

Característica: : buscar traslado
  yo como usuario de la pagina Despegar.com
  quiero poder buscar traslados
  para obtener todos lo beneficios de la pagina

  @rutaCritica3
  Escenario: buscar traslado con campos vacios
    Dado que el usuario esta en la pagina de traslado
    Cuando ingresa informacion en los campos incompleta
    Y prosigue con la accion
    Entonces deberia ver un mensaje error indicando que complete la informacion