#language:es
  #encoding:UTF-8
  #Author: Devon Jose Alvarez Osorio

Característica: Buscar un vuelo en Despegar.com
  Yo Como usuario la pagina de Despegar.com
  Quiero poder buscar vuelos
  Para ver las opciones disponibles

  Antecedentes:
    Dado Given que el usuario esta en la página de inicio de sesión de Despegar.com

  @test2
  Escenario:Buscar un vuelo
    Cuando lleno todos los campos necesarios
    Y confirma la accion
    Entonces deberia ser dirigido a la pagina con los vuelos disponibles