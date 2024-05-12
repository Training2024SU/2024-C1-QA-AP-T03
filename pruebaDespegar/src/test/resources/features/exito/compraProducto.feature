#language:es
  #encoding:UTF-8
  #Author: Devon Jose Alvarez Osorio


Característica: comprar producto en la pagina exito.com
  Yo Como usuario de la pagina exito.com
  Quiero poder comprar productos
  Para obtener los beneficios del producto

  Antecedentes:
    Dado que el usuario esta en la pagina principal 2

  @rutacritica1
  Esquema del escenario: : compra de producto exitosa
    Cuando seleciona un producto
    Y continua con el proceso de pago
    Y llena el formulario de pago con los datos "<nombre>","<apellido>","<cedula>" y "<telefono>"
    Entonces entonces deberia mostrar una factura con los detalles de la compra
    Ejemplos:
      | nombre | apellido        | cedula   | telefono   |
      | devon  | alvarez osorio  | 50924345 | 3023610274 |
      | Jose   | Perez Hernandez | 10927345 | 3004679823 |

  @agregarproductoscarrito2
  Escenario: agregar varios productos al carrito
    Cuando agrega varios productos al carrito
    Entonces deberia poder realizar la compra de todos los productos