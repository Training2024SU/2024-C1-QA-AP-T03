#language:es
  #encoding:UTF-8
  #Author: Devon Jose Alvarez Osorio

@servicio
Característica: Verificar la funcionalidad de un servicio GET de la pagina developer.marvel.com/
Yo Como usuario
Quiero verificar el servicio GET de la pagina
Para obtener una lista con la información de todos los comics

Escenario: : Verificar obtención de todos los comics
Dado que el servicio GET en la pagina developer.marvel.com/ está en línea y accesible
Cuando realiza una solicitud GET atravez del endpoint
Entonces deberia mostrar un código de estado HTTP 200
