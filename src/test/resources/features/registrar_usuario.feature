#language: es
#encoding: iso-8859-1

Caracter�stica: Registrar usuario
  Yo quiero realizar el registro de un usuario

  Antecedentes: Endpoint
    Dado que se haya ingresado el endpoint del servicio

  @crearUsuario
  Esquema del escenario: Crear usuario
    Cuando el usuario '<nombre>' ingrese su trabajo '<trabajo>'
    Entonces el usuario '<nombre>' ver� el trabajo '<trabajo>' creado exitosamente con la respuesta '<respuesta>'

    @desarrollo
    Ejemplos: Registrar usuario
      | nombre | trabajo | respuesta |
      | morfeo | l�der   | OK        |


  @loguearse
  Esquema del escenario: Loguearse
    Cuando el usuario inicie sesi�n erroneamente
      | email   | contrasena   |
      | <email> | <contrasena> |
    Entonces el usuario vera el mensaje de error '<mensajeError>'

    @desarrollo
    Ejemplos: Registrar usuario
      | email              | contrasena | mensajeError |
      | eve.holt@reqres.in | pistola    | BAD_REQUEST  |



