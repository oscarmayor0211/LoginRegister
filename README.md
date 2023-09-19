# LoginRegister Backend
# Como probar el proyecto 🔩
## Creacion de usuarios 
###  Debemos primeramente con la herramienta de test como postman

# POST - http://localhost:8080/users/save
 importante enviar el json segun las especificaciones ejemplo:
``` sh
{
    "name": "Oscar Mayor",
    "email": "oscarmayor0211@gmail.com",
    "password": "@ValpoSystem02*",
    "phones": [
        {
        "number": "1234567",
        "citycode": "1",
        "contrycode": "57"
        }
    ] 
}
```
  Lo que devolvera ejemplo:
``` sh

{
    "id": "7d8049a2-a221-458d-ae0f-d53ca831018d",
    "name": "Oscar Mayor",
    "email": "oscarmayor0211@gmail.com",
    "password": "$2a$10$t2QI4ozshUrSxtyH/0sIQOzPi8EggrgxvTM0MJO5dBvGIBzaZe1UW",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvc2Nhcm1heW9yMDIxMUBnbWFpbC5jb20iLCJleHAiOjE2OTUxNjQ1NDIsImlhdCI6MTY5NTE2MDk0Mn0.5SglyMku8vq6VzZp6Nw2YoMWaKQ0nC3woJF9Bk4AelDF-povBQgZMbBOlFoJ4PveEwSHORWUd4pROPJ-iUQrnw",
    "active": true,
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ],
    "lastLogin": "2023-09-19T17:02:22.2891225",
    "created": "2023-09-19T17:02:22.2891225"
}
  ```

# Logueo de usuario 📦
Podemos validar el usuario en el siguiente endpoint

# POST - http://localhost:8080/authenticate
Debemos ingresar el body del usuario que deseamos validar ejemplo
``` sh
{
    "username": "oscarmayor0211@gmail.com",
    "password": "@ValpoSystem02*"
}
Y nos devolvera como ejemplo:
{
    "id": "7d8049a2-a221-458d-ae0f-d53ca831018d",
    "name": "Oscar Mayor",
    "email": "oscarmayor0211@gmail.com",
    "password": "$2a$10$t2QI4ozshUrSxtyH/0sIQOzPi8EggrgxvTM0MJO5dBvGIBzaZe1UW",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvc2Nhcm1heW9yMDIxMUBnbWFpbC5jb20iLCJleHAiOjE2OTUxNjQ1NDIsImlhdCI6MTY5NTE2MDk0Mn0.5SglyMku8vq6VzZp6Nw2YoMWaKQ0nC3woJF9Bk4AelDF-povBQgZMbBOlFoJ4PveEwSHORWUd4pROPJ-iUQrnw",
    "active": true,
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ],
    "lastLogin": "2023-09-19T17:02:22.289123",
    "created": "2023-09-19T17:02:22.289123",
}
```
# Para modificar 
PUT - http://localhost:8080/users/7d8049a2-a221-458d-ae0f-d53ca831018d

# Respuesta
``` sh
{
    "id": "7d8049a2-a221-458d-ae0f-d53ca831018d",
    "name": "Oscar Mayor",
    "email": "oscarmayor0211@gmail.com",
    "password": "$2a$10$t2QI4ozshUrSxtyH/0sIQOzPi8EggrgxvTM0MJO5dBvGIBzaZe1UW",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJvc2Nhcm1heW9yMDIxMUBnbWFpbC5jb20iLCJleHAiOjE2OTUxNjQ1NDIsImlhdCI6MTY5NTE2MDk0Mn0.5SglyMku8vq6VzZp6Nw2YoMWaKQ0nC3woJF9Bk4AelDF-povBQgZMbBOlFoJ4PveEwSHORWUd4pROPJ-iUQrnw",
    "active": true,
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ],
    "lastLogin": "2023-09-19T17:02:22.2891225",
    "created": "2023-09-19T17:02:22.2891225",
 "modified": 2023-09-19T17:14:12.2234323,
}
```
# Para correr el frontend Hecho En angular
## npm install
## ng serve -o 
# Construido con 🛠️

## Se utilizo lo siguiente

## [Proyecto - Spring boot]
## [Librerias - maven]
## [Seguridad - JWT]
## [Base de datos - h2]
## [JPA - Hibernate]
## [Angular]
# Autor ✒️
## Oscar Eduardo Mayor Jaramillo
