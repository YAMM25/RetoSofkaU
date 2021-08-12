#language: es

Característica: Gestión de usuarios en retofinal modulo administracion

  Escenario: Creacion exitosa de usuario nuevo
    Cuando se tiene la informacion de un nuevo usuario para crear en retofinal
    Entonces se crea el usuario exitosamente

  Escenario: Consulta exitosa de un usuario por id
    Cuando un analista consulta un usuario por id
    Entonces puede recuperar la informacion del usuario correctamente

  Escenario: Se actualizará un usuario existente
    Cuando se tiene la informacion de un usuario para actualizar
    Entonces se actualiza el usuario exitosamente

  Escenario: Consulta exitosa de todas las preguntas frecuentes
    Cuando un usuario consulta las preguntas frecuentes en la plataforma
    Entonces puede recuperar la informacion de las preguntas correctamente

  Escenario: Consulta exitosa de todas las verticales
    Cuando un analista consulta todas las verticales del OKR
    Entonces puede recuperar la informacion de las verticales correctamente

  Escenario: Consulta exitosa de una vertical por id
    Cuando un analista consulta una vertical del OKR
    Entonces puede recuperar la informacion de la vertical correctamente