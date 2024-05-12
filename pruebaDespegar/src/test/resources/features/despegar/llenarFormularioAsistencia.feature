#language:es
  #encoding:UTF-8
  #Author: Devon Jose Alvarez Osorio

  Característica: llenar formulario para finalizar compra
    yo como usuario de la pagina Despegar.com
    quiero llenar el formulario de comprar de asistencia
    para accceder a todos sus beneficios

@test4
Esquema del escenario: llenar fomulario de compra
Dado que el usuario esta en la pagina de finalizacion de compra
Cuando llena el formulario con los datos "<nombre>", "<apellido>", "<correo>" y "<telefono>"
Y el usuario continua con la finalizacion de la compra
Entonces deberia finalizar la compra exitosamente

Ejemplos:
| nombre    | apellido | correo                | telefono     |
| Juan      | Perez    | juan@example.com      | 555-123-4567 |
