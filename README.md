# README

## CONTENIDOS
   
* Introducción
* Requerimientos
* Configuración
* Autor


## INTRODUCCION

Este proyecto fue creado con Spring, conectado mediante una base de Datos de tipo H2, y mediante la utilización de JPA para consumir con un REST los datos. A su vez se utilizó Python para hacer peticiones al servidor de Spring directamente.


## REQUERIMIENTOS

Este proyecto utilizó los siguientes módulos:
Para Spring:
* PA
* H2 Database
* Spring Web
* Spring DevTools

Para Python:
* libreria Request
* libreria JSON


## INSTALACIÓN
 
Para Spring unicamente la dependencia en el pom:
```java
<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
</dependency>
```
Para Python:
```python
pip install requests
```
```python
pip install json
```
## CONFIGURATION
 
Para la configuración del proyecto, debemos ejecutar el proyecto de tipo Spring, en este caso con el IDE de IntellijIdea, mediante el cual ejecutamos el servidor en la siguiente dirección local:
http://localhost:8080/employee/apiv1/clientes/add
Mediante el archivo de Python, se obtendrá el JSON que servirá como cuerpo de la petición que será recibido por la aplicación de Spring, y a su vez los datos serán insertados dentro de la Base de Datos Airport


## AUTOR

* Fernando Hernandez Vazquez
