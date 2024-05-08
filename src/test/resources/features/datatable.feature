Feature: datatable
  Yo como administrador de la aplicación demoga
  Quiero poder gestionar la información de los usuarios
  Para tener un control completo sobre los datos de los usuarios
  #autor: Daniel Chaparro


# escenarios

  Background:
    Given que el administrador se encuentra en la página de gestion de usuarios


  @dataTable
  @agregarUsuario
  Scenario: agregar usuario
    When el administrador llena el formulario de usuario
    Then el administrador debería visualizar la información del usuario agregado

  @dataTable
  @editarUsuario
  Scenario: editar información de usuario
    When el administrador modifica la información del usuario
    Then el administrador debería ver la información actualizada del usuario en la página de gestión de usuarios

  @dataTable
  @eliminarUsuario
  Scenario: eliminar usuario
    When el administrador elimina un usuario
    Then el usuario debería ser eliminado del sistema correctamente

  @dataTable
  @filtrarUsuario
  Scenario: buscar usuario por nombre
    When el administrador ingresa el nombre de un usuario en el campo de búsqueda
    Then se debería visualizar en la tabla solo los usuarios cuyo nombre coincida con la búsqueda