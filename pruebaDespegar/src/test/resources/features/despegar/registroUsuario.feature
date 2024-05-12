#language:es
  #encoding:UTF-8
  #Author: Devon Jose Alvarez Osorio

Característica: : registro usuario en la pagina despegar.com
  yo como usuario de la pagina Despegar.com
  quiero poder registrarme
  para obtener los beneficios de la pagina

  @rutaCritica2
  Escenario: registro fallido con correo existente
    Dado Given que el usuario esta en la página de registro
    Cuando ingresa un correo existente
    Y elige confirmar la accion
    Entonces deberia ver un mensaje de error indicando que el correo ya existe

  @escenarioOutline
  Esquema del escenario: : Registro con correo y contrasenia válido
    Dado Given que el usuario se encuentra en la página de registro
    Cuando Cuando se registra con correo "<correo>" y contrasenia "<contrasenia>"
    Y  continua con la accion
    Entonces debería recibir un mensaje de confirmación al correo

    Ejemplos:
      | correo                  | contrasenia    |
      | casoPrueba803@gmail.com | casoPrueba2024 |
      | casoPrueba804@gmail.com | casoPrueba2024 |



