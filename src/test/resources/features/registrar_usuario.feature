#language: es
#encoding: iso-8859-1
#Author: jbuiles@qvision.com.co, lvilla@qvision.com.co
Característica: Registrar usuario
  Yo quiero realizar el registro de un usuario

  Antecedentes: Endpoint
    Dado que se haya ingresado el endpoint del servicio

  @crearUsuario
  Esquema del escenario: Crear usuario
    Cuando el usuario '<nombre>' ingrese su trabajo '<trabajo>'
    Entonces el usuario '<nombre>' verá el trabajo '<trabajo>' creado exitosamente con la respuesta '<respuesta>'

    @desarrollo
    Ejemplos: Registrar usuario
      | nombre | trabajo | respuesta |
      | morfeo | líder   | OK        |

    @laboratorio
    Ejemplos: Registrar usuario
      | nombre | trabajo   | respuesta |
      | Juan   | ingeniero | OK        |