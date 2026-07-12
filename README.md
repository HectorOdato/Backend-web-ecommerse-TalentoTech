# ZStride - Backend API - TalentoTech

Descripción del Proyecto:
ZStride es una plataforma de comercio especializada en moda masculina y calzado deportivo. Este backend, desarrollado con Java y Spring Boot, 
proporciona una API RESTful para la gestión integral de productos, categorías y el procesamiento de pedidos de clientes, utilizando MongoDB como base de datos.
El sistema permite administrar el inventario en tiempo real y gestionar la lógica de ventas.

La aplicación permite:

- Crear, consultar, actualizar y eliminar productos.
- Crear, actualizar y eliminar categorías.
- Asociar productos con categorías.
- Consultar productos según su categoría.
- Gestionar pedidos realizados por usuarios.
- Crear, listar y eliminar pedidos.
- Validar datos ingresados mediante validaciones de Spring.
- Conectar la aplicación con una base de datos MongoDB Atlas.

El backend fue desarrollado utilizando Spring Boot y desplegado en Render.
El frontend de la aplicación fue desarrollado por separado y desplegado en Vercel.

Tecnologías utilizadas:

- Java
- Spring Boot
- Spring Data MongoDB
- MongoDB Atlas
- Maven
- Git y GidHub
- Postman para pruebas de endpoints
- Render (deploy backend)
- Vercel (deploy frontend)

---

# DEPLOY

- BackEnd: https://backend-web-ecommerse-talentotech.onrender.com/productos

- Fronend: https://web-ecommerse-talento-tech.vercel.app (esperar unos segundos a que inicialize el backend)

- Deshboard: https://web-ecommerse-talento-tech.vercel.app/deshboard.html

# El proyecto está organizado siguiendo una estructura por capas:

```
src/main/java
│
├── controller
│ └── Controladores REST de la aplicación
│
├── service
│ └── Lógica de negocio
│
├── repository
│ └── Acceso a datos mediante MongoDB
│
└── model
└── Entidades del sistema
```

# Instrucciones para ejecutar la aplicación

## Requisitos previos

Tener instalado:

- Java JDK 17 o superior.
- Maven.
- MongoDB (local) o una cuenta en MongoDB Atlas.

## 1- Clonar el repositorio

```bash
git clone URL_DEL_REPOSITORIO

cd gestionproductos
```

## 2- Configuración de MongoDB 

Cofigurar la coneccion a MongoDB en: src/main/resources/application.properties
 
spring.application.name=gestionproductos

spring.data.mongodb.uri=URL_MONGODB_ATLAS

spring.data.mongodb.database=gestionProductos

## 3- Ejecutar la aplicacion

Lo podes hacer desde la clase principal del proyecto desde un IDE o ejecutar en terminal:

```bash
mvn spring-boot:run
```


# Ejemplos de uso de EndPoins

## Productos
- Obtener todos los productos: GET /productos
- Crear productos: POST /productos
- Listar productos GET /productos
- Buscar por ID: GET /productos/id
- Actualizar productos PUT /productos/{id}
- eliminar productos DELETE/productos/{id}
- prodcutos por categoria: GET/productos/categoria/{id}

Ejemplo de Respuesta esperada para obtener productos

```
  {
    "id": "65abc12321321dsa2e212",
    "nombre": "Remera deportiva",
    "descripcion": "Remera de algodón",
    "precio": 15000,
    "stock": 20
    "imagenURL: https//ejemplo.com"
  }
```

## Categorias

- Crear categorias: POST /categorias
- Listar categorias GET /categorias
- Buscar por ID: GET /categorias/id
- Actualizar categorias PUT /categorias/{id}
- Y eliminar categorais DELETE/categorias/{id}

Ejemplo de BODY json para crear:
```
{
    "nombre": "Calzado"
    "descripcion":"calidad asegurada"
}
```




## Pedidos

- Crear pedidos: POST /pedidos
- Eliminar pedidos: DELETE/pedidos
- listar pedidos: GET/pedidos

Ejemplo de body Json para listar pedidos
```
{
    "usuario": "Juan Perez",
    "lineas": [
        {
            "producto": {
                "id": "ID_PRODUCTO"
            },
            "cantidad": 2
        }
    ]
}
```

## Usuarios

- Crear usuarios: POST /usuarios
- Eliminar usuarios: DELETE/usuarios
- listar usuarios: GET/usuarios
- Obtener pedidos por Usuario: GET/usuarios/{UsuarioId}/pedidos

JSON esperado para obtener pedidos por ID de usuarios

```
    {
        "estado": "PENDIENTE",
        "fechaCreacion": "2026-07-10T17:21:08.111",
        "id": "6a512a057e4650bc7591c51a",
        "lineas": [
            {
                "producto": {
                    "id": "6a50f696f35324ea98b1155e",
                    "nombre": "Zapatillas Running",
                    "precio": 85000.0,
                    "stock": 8,
                    "descripcion": "Ideales para correr",
                    "imagenURL": "imagen365",
                    "categoria": {
                        "nombre": "Calzado",
                        "descripcion": "Zapatillas y botas",
                        "id": "6a50ee042478b3c06a5c81a8"
                    }
                },
                "cantidad": 2
            }
```














