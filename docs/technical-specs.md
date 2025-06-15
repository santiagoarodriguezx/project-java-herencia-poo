# 📋 Especificaciones Técnicas - Biblioteca Digital v1.0.0

## 🏗️ Arquitectura del Sistema

### Estructura de Paquetes

```
src/
├── LibraryApp.java              # Aplicación principal
└── com/sena/app/models/
    └── Book.java                # Modelo de datos del libro
```

### Diagrama de Clases

```
┌─────────────────────────────┐
│          Book               │
├─────────────────────────────┤
│ - id: int                   │
│ - title: String             │
│ - edititionDate: String     │
│ - editorial: String         │
│ - isbn: String              │
│ - authors: List<String>     │
│ - readed: boolean           │
│ - timeReaded: int           │
├─────────────────────────────┤
│ + Book(title, date, ...)    │
│ + getId(): int              │
│ + getTitle(): String        │
│ + setTitle(String): void    │
│ + ... (getters/setters)     │
│ + toString(): String        │
└─────────────────────────────┘
```

## 🔧 Funcionalidades Implementadas

### CRUD Completo

- **✅ Create**: Crear nuevos libros con validación
- **✅ Read**: Mostrar libros en tabla formateada
- **✅ Update**: Actualizar campos específicos
- **✅ Delete**: Eliminar con confirmación

### Funcionalidades Avanzadas

- **🔍 Búsqueda**: Por título, autor, ISBN
- **📊 Estadísticas**: Análisis completo de la biblioteca
- **📋 Tabla formateada**: Visualización profesional
- **🎯 Validaciones**: Entrada de datos robusta

## 📊 Métricas del Proyecto

### Líneas de Código

- **Total**: ~400 líneas
- **Clases**: 2 (LibraryApp, Book)
- **Métodos**: 15+

### Complejidad

- **Menús interactivos**: 2 niveles
- **Algoritmos de búsqueda**: 3 tipos
- **Cálculos estadísticos**: 7 métricas

## 🧪 Datos de Prueba Incluidos

1. **Effective Java** - Joshua Bloch (Leído, 15h)
2. **Clean Code** - Robert C. Martin (Leído, 12h)
3. **Design Patterns** - Gang of Four (No leído)
4. **Spring in Action** - Craig Walls (Leído, 8h)
5. **Java: The Complete Reference** - Herbert Schildt (No leído)

## 🚀 Instrucciones de Compilación y Ejecución

### Compilación

```bash
javac -d bin src/LibraryApp.java src/com/sena/app/models/Book.java
```

### Ejecución

```bash
java -cp bin LibraryApp
```

## 🛠️ Tecnologías Utilizadas

- **Java SE 8+**
- **Collections Framework** (ArrayList, List)
- **Scanner** para entrada de usuario
- **Printf** para formateo de salida

## 📈 Posibles Mejoras Futuras

1. **Persistencia**: Guardar datos en archivo/base de datos
2. **Interfaz Gráfica**: JavaFX o Swing
3. **Validaciones**: ISBN real, fechas
4. **Categorías**: Clasificación por géneros
5. **Préstamos**: Sistema de biblioteca real
6. **Exportación**: PDF, Excel
7. **Configuración**: Archivos de propiedades

## 🔒 Consideraciones de Seguridad

- Validación de entrada de usuario
- Manejo de errores robusto
- Límites en tamaño de strings

## 📄 Licencia

Proyecto académico - SENA - 2025
