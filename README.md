# Reflexión con Servidor Web y MySpring

[![CircleCI](https://circleci.com/gh/alejovasquero/AREP---LabReflexion.svg?style=svg)](https://circleci.com/gh/alejovasquero/AREP---LabReflexion)

[Despliegue en heroku](https://lab-reflexion.herokuapp.com/)

-----------------
Este repositorio contiene la implementación de un pequeño motor de
spring, para el acceso a recursos y páginas web con Http.  

## Empezando

Estas instrucciones te utilizar la página web, compilar y ejecutar. 

 
### Prerrequisitos

Para instalar y correr exitosamente este proyecto necesitamos:
* **Java**
* **Maven**
* **Git**


### Instalación

Primeramente vamos a descargar el repositorio en nuestra máquina local, y en la carpeta de 
nuestra preferencia. En consola vamos a digitar el siguiente comando para clonar el repositorio.

```
git clone https://github.com/alejovasquero/AREP---LabReflexion
```

Entremos a el directorio del proyecto

```
cd Taller-Reflexion
```

Debemos compilar el proyecto, que contiene las clases necesarias para poder correr nuestro
proyecto. Por medio de maven vamos a crear todos los compilables **.class**. Desde consola, y ubicados en la carpeta donde se encuentra
nuestra configuración de maven.

```
mvn package
```

Ahora que nuestras clases etan compiladas vamos a ejecutar la clase principal para
ver el código en acción : )

## Spring local

Una vez compiladas las clases vamos a correr el proyecto

```
java -cp target/classes edu.eci.escuelaing.arep.Main edu.eci.escuelaing.arep.Controller.PagesController
```

Ahora vamos a entrar a nuestro browser en [localhost:35000](http://localhost:35000)

## Pruebas

Para correr las pruebas

```
mvn test
```


## Construido con


* [Maven](https://maven.apache.org/) - Manejo de dependencias
* [Git](https://git-scm.com/) - Control de versiones
* [Java](https://www.java.com/es/) - Lenguaje de programación
* [Spark](http://sparkjava.com/) - Framework de desarrollo web


## Autores

* **David Alejandro Vasquez Carreño** - *Trabajo inicial* - [alejovasquero](https://github.com/alejovasquero)

## Licencia

Este proyecto está licenciado bajo la licencia del MIT - Vea el [LICENSE.md](LICENSE.md) para más detalles

## Reconocimientos

* Daniel Benavides
