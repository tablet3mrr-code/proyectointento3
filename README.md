# Sistema de Gestión de Tours

## Descripción

Este proyecto corresponde a una aplicación desarrollada en Java utilizando Programación Orientada a Objetos para administrar un sistema de gestión de tours turísticos.

El sistema permite gestionar personas, vehículos, tours y reservas mediante un menú interactivo ejecutado desde consola.

---

## Funcionalidades

- Registro de clientes.
- Registro de guías turísticos.
- Registro de proveedores.
- Gestión de vehículos.
- Gestión de tours.
- Gestión de reservas.
- Lectura de información desde archivos de texto.
- Validación de RUT mediante clase propia.
- Manejo de excepciones personalizadas.

---

## Tecnologías utilizadas

- Java
- Apache NetBeans
- Programación Orientada a Objetos
- Git
- GitHub

---

## Estructura del proyecto

```
src/
│
├── app
│   └── Main.java
│
├── model
│   ├── Persona.java
│   ├── Cliente.java
│   ├── GuiaTuristico.java
│   ├── Proveedor.java
│   ├── Vehiculo.java
│   ├── Tour.java
│   ├── Reserva.java
│   ├── Rut.java
│   ├── Direccion.java
│   └── Registrable.java
│
├── util
│   └── ArchivoUtil.java
│
├── service
│   └── PersonaService.java
│
└── exception
    └── RutInvalidoException.java

data/
└── personas.txt
```

---

## Ejecución

1. Abrir el proyecto en Apache NetBeans.
2. Ejecutar **Clean and Build**.
3. Ejecutar el proyecto.
4. Utilizar el menú de consola para gestionar la información.

---

## Conceptos aplicados

- Clases y objetos.
- Herencia.
- Polimorfismo.
- Encapsulamiento.
- Interfaces.
- Clases abstractas.
- Manejo de excepciones.
- Lectura de archivos.
- Colecciones (`ArrayList`).

---

## Autor

Proyecto desarrollado por Juan Tomás Moya para la Evaluación Final Transversal de Programación Orientada a Objetos.
