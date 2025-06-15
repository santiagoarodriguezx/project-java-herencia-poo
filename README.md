# 📚 Sistema de Biblioteca Digital

Proyecto de gestión de biblioteca digital implementado en Java con programación orientada a objetos.

## 🎯 Características

- ✅ Operaciones CRUD completas (Crear, Leer, Actualizar, Eliminar)
- 🔍 Búsqueda por título, autor e ISBN
- 📊 Estadísticas de lectura
- 🎨 Interfaz de consola interactiva
- 📖 Gestión de autores múltiples
- ⏱️ Seguimiento de tiempo de lectura

## 🏗️ Estructura del Proyecto

```
project-java-herencia-poo/
├── src/
│   ├── LibraryApp.java
│   └── com/
│       └── sena/
│           └── app/
│               └── models/
│                   └── Book.java
├── bin/
├── docs/
└── README.md
```

## 🚀 Cómo ejecutar

1. Compilar el proyecto:

```bash
javac -d bin src/LibraryApp.java src/com/sena/app/models/Book.java
```

2. Ejecutar la aplicación:

```bash
java -cp bin LibraryApp
```

## 📋 Funcionalidades

- **Crear libros**: Agregar nuevos libros con información completa
- **Listar libros**: Ver todos los libros en formato tabla
- **Actualizar libros**: Modificar información de libros existentes
- **Eliminar libros**: Remover libros con confirmación
- **Buscar libros**: Encontrar libros por diversos criterios
- **Estadísticas**: Ver métricas de la biblioteca

## 🔧 Tecnologías

- Java SE
- Programación Orientada a Objetos
- Collections Framework
- Scanner para entrada de usuario

## 👨‍💻 Desarrollo

Proyecto desarrollado usando GitFlow para control de versiones y metodología incremental.
