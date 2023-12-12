# API REST para Gestión de Ventas de una Tienda/Bazar

Este proyecto tiene como objetivo desarrollar una API robusta utilizando Spring Boot para optimizar la gestión de ventas y el control de inventario en una tienda/bazar que ha experimentado un significativo aumento en sus ventas. La solución propuesta busca superar las dificultades asociadas al registro manual de transacciones y la gestión de stock mediante la automatización de estas tareas.

## Tecnologías Utilizadas
- **Spring Boot:** Framework de desarrollo para aplicaciones Java basadas en microservicios.
- **Arquitectura Multicapas:** Enfoque de diseño que divide la aplicación en capas lógicas para una mayor modularidad.
- **Inversión de Control (IoC) / Inyección de Dependencias (DI):** Principios fundamentales de Spring para mejorar la inversión de control y la modularidad del código.
- **Postman:** Herramienta utilizada para probar y documentar la API.
- **Hibernate:** Framework de mapeo objeto-relacional (ORM) para la persistencia de datos.
- **MySQL:** Sistema de gestión de bases de datos relacional para almacenar y recuperar datos de la aplicación.

## Repositorio
El código fuente de la API se encuentra disponible en el siguiente repositorio de GitHub: [API-REST-Tienda---Spring-Boot](https://github.com/ngcb03/API-REST-Tienda---Spring-Boot)

## Requerimientos desarrollados

1. Poder realizar un CRUD completo de productos.
   a. Métodos HTTP: GET, POST, DELETE, PUT
   b. Endpoints:
      - Creación: localhost:8080/productos/crear
      - Lista completa de productos: localhost:8080/productos
      - Traer un producto en particular: localhost:8080/productos/{codigo_producto}
      - Eliminación: localhost:8080/productos/eliminar/{codigo_producto}
      - Edición: localhost:8080/productos/editar/{codigo_producto}

2. Poder realizar un CRUD completo de clientes.
   a. Métodos HTTP: GET, POST, DELETE, PUT
   b. Endpoints:
      - Creación: localhost:8080/clientes/crear
      - Lista completa de clientes: localhost:8080/clientes
      - Traer un cliente en particular: localhost:8080/clientes/{id_cliente}
      - Eliminación: localhost:8080/clientes/eliminar/{id_cliente}
      - Edición: localhost:8080/clientes/editar/{id_cliente}

3. Poder realizar un CRUD completo de ventas:
   a. Métodos HTTP: GET, POST, DELETE, PUT
   b. Endpoints:
      - Creación: localhost:8080/ventas/crear
      - Lista completa de ventas realizadas: localhost:8080/ventas
      - Traer una venta en particular: localhost:8080/ventas/{codigo_venta}
      - Eliminación: localhost:8080/clientes/eliminar/{codigo_venta}
      - Edición: localhost:8080/clientes/editar/{codigo_venta}


Nota: Igualmente se implemento la funcionalidad de actualizar el stock de productos y 
comprobación de si hay productos disponibles para bloquear nuevos registros


4. Obtener todos los productos cuya cantidad_disponible sea menor a 5.
   a. Métodos HTTP: GET.
   b. Endpoint:
      - localhost:8080/productos/falta_stock

5. Obtener la lista de productos de una determinada venta.
   a. Métodos HTTP: GET.
   b. Endpoint:
      - localhost:8080/ventas/productos/{codigo_venta}

6. Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día:
   a. Métodos HTTP: GET.
   b. Endpoint:
      - localhost:8080/ventas/{fecha_venta}

7. Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el
apellido del cliente de la venta con el monto más alto de todas.
   a. Métodos HTTP: GET
   b. Endpoint:
      - localhost:8080/ventas/mayor_venta
   
   Se implementó patrón DTO para este escenario


## Instrucciones de Uso
1. Clona el repositorio a tu máquina local utilizando el siguiente comando:
   ```bash
   git clone https://github.com/ngcb03/API-REST-Tienda---Spring-Boot.git

2. Abre el proyecto en tu entorno de desarrollo preferido.
3. Configura las propiedades de la base de datos MySQL en el archivo application.properties para adaptarse a tu entorno.
4. Ejecuta la aplicación Spring Boot.
5. Accede a la documentación de la API generada automáticamente mediante Swagger/OpenAPI o Postman para conocer y probar los endpoints disponibles.

## Instrucciones de Uso
Las contribuciones son bienvenidas. Si encuentras problemas o mejoras potenciales, por favor, abre un problema o envía una solicitud de extracción.

## Instrucciones de Uso
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para obtener más detalles.
