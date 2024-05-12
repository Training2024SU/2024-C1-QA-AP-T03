#language:es
  #encoding:UTF-8
  #Author: Devon Jose Alvarez Osorio

Característica: : Inicio de Sesión en Despegar.com
  yo como usuario de la pagina Despegar.com
  quiero iniciar sesion
  para obtener los beneficios de la pagina

  @test1
  Escenario: : Inicio de sesion exitoso
    Dado Given que el usuario esta en la página de inicio de sesión de Despegar.com
    Cuando ingresa los credenciales correctamente
    Y procede a confirmar la accion
    Entonces deberia ser dirigido a la pagina principal del inicio de sesion

  @rutacritica1
  Escenario: : Inicio de sesion fallido con correo no registrado
    Dado Given que el usuario esta en la página de inicio de sesión
    Cuando ingresa un correo no registrado
    Y  confirmar la accion
    Entonces deberia ver un mensaje de error



