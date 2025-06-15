import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.sena.app.models.Book;

public class LibraryApp {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Book> library = new ArrayList<>();    public static void main(String[] args) {
        System.out.println("🚀 Biblioteca Digital - Versión 1.0");
        
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer            switch (opcion) {
                case 1:
                    crearLibro();
                    break;
                case 2:
                    leerLibros();
                    break;
                case 3:
                    actualizarLibro();
                    break;
                case 0:
                    System.out.println("¡Gracias por usar la biblioteca!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {        System.out.println("\n═══════════════════════════════════════");
        System.out.println("           BIBLIOTECA DIGITAL");
        System.out.println("═══════════════════════════════════════");
        System.out.println("1. ➕ Crear nuevo libro");
        System.out.println("2. 📚 Mostrar todos los libros");
        System.out.println("3. ✏️ Actualizar libro");
        System.out.println("0. 🚪 Salir");
        System.out.println("═══════════════════════════════════════");
        System.out.print("Seleccione una opción: ");
    }    private static void crearLibro() {
        System.out.println("\n--- ➕ CREAR NUEVO LIBRO ---");

        System.out.print("Título: ");
        String title = scanner.nextLine();

        System.out.print("Fecha de edición (YYYY-MM-DD): ");
        String editionDate = scanner.nextLine();

        System.out.print("Editorial: ");
        String editorial = scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Book newBook = new Book(title, editionDate, editorial, isbn);

        // Agregar autores
        System.out.print("Autores (separados por comas): ");
        String authorsInput = scanner.nextLine();
        if (!authorsInput.trim().isEmpty()) {
            String[] authors = authorsInput.split(",");
            for (String author : authors) {
                newBook.getAuthors().add(author.trim());
            }
        }

        // Estado de lectura
        System.out.print("¿Está leído? (true/false): ");
        boolean isReaded = scanner.nextBoolean();
        newBook.setReaded(isReaded);

        if (isReaded) {
            System.out.print("Horas de lectura: ");
            int timeReaded = scanner.nextInt();
            newBook.setTimeReaded(timeReaded);
        }
        scanner.nextLine(); // Limpiar buffer

        library.add(newBook);

        System.out.println("✅ Libro agregado exitosamente!");
        System.out.println("📖 ID asignado: " + newBook.getId());
    }    private static void leerLibros() {
        System.out.println("\n--- 📚 BIBLIOTECA COMPLETA ---");

        if (library.isEmpty()) {
            System.out.println("❌ No hay libros en la biblioteca.");
            return;
        }

        mostrarTablaLibros(library);
    }

    private static void mostrarTablaLibros(List<Book> libros) {
        System.out.println("┌────┬─────────────────────────────┬─────────────┬──────────────────┬─────────────────┬──────────────────────────────┬────────┬─────────────┐");
        System.out.println("│ ID │ Título                      │ Fecha Ed.   │ Editorial        │ ISBN            │ Autores                      │ Leído  │ Hrs. Lectura │");
        System.out.println("├────┼─────────────────────────────┼─────────────┼──────────────────┼─────────────────┼──────────────────────────────┼────────┼─────────────┤");

        for (Book book : libros) {
            String id = String.format("%-3d", book.getId());
            String title = truncateString(book.getTitle(), 28);
            String date = truncateString(book.getEdititionDate(), 12);
            String editorial = truncateString(book.getEditorial(), 17);
            String isbn = truncateString(book.getIsbn(), 16);
            
            StringBuilder authorsStr = new StringBuilder();
            for (int i = 0; i < book.getAuthors().size(); i++) {
                authorsStr.append(book.getAuthors().get(i));
                if (i < book.getAuthors().size() - 1) {
                    authorsStr.append(", ");
                }
            }
            String authors = truncateString(authorsStr.toString(), 29);
            
            String readed = book.isReaded() ? "Sí" : "No";
            String timeReaded = String.format("%-11d", book.getTimeReaded());

            System.out.printf("│ %s │ %-28s │ %-12s │ %-17s │ %-16s │ %-29s │ %-6s │ %s │%n",
                    id, title, date, editorial, isbn, authors, readed, timeReaded);
        }

        System.out.println("└────┴─────────────────────────────┴─────────────┴──────────────────┴─────────────────┴──────────────────────────────┴────────┴─────────────┘");
        System.out.println("📊 Total de libros: " + libros.size());
    }

    private static String truncateString(String str, int maxLength) {
        if (str.length() <= maxLength) {
            return str;
        } else {
            return str.substring(0, maxLength - 3) + "...";
        }
    }

    private static void mostrarLibrosConIndices() {
        System.out.println("📚 Libros disponibles:");
        for (int i = 0; i < library.size(); i++) {
            System.out.println((i + 1) + ". " + library.get(i).getTitle() + " (ID: " + library.get(i).getId() + ")");
        }
    }    private static void actualizarLibro() {
        System.out.println("\n--- ✏️ ACTUALIZAR LIBRO ---");

        if (library.isEmpty()) {
            System.out.println("❌ No hay libros para actualizar.");
            return;
        }

        mostrarLibrosConIndices();

        System.out.print("Seleccione el número del libro a actualizar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice < 1 || indice > library.size()) {
            System.out.println("❌ Índice no válido.");
            return;
        }

        Book libro = library.get(indice - 1);
        System.out.println("📖 Libro seleccionado: " + libro.getTitle());

        int opcionUpdate;
        do {
            mostrarMenuActualizacion();
            opcionUpdate = scanner.nextInt();
            scanner.nextLine();

            switch (opcionUpdate) {
                case 1:
                    System.out.print("Nuevo título (actual: " + libro.getTitle() + "): ");
                    String nuevoTitulo = scanner.nextLine();
                    if (!nuevoTitulo.trim().isEmpty()) {
                        libro.setTitle(nuevoTitulo);
                        System.out.println("✅ Título actualizado.");
                    }
                    break;
                case 2:
                    System.out.print("Nueva fecha de edición (actual: " + libro.getEdititionDate() + "): ");
                    String nuevaFecha = scanner.nextLine();
                    if (!nuevaFecha.trim().isEmpty()) {
                        libro.setEdititionDate(nuevaFecha);
                        System.out.println("✅ Fecha actualizada.");
                    }
                    break;
                case 3:
                    System.out.print("Nueva editorial (actual: " + libro.getEditorial() + "): ");
                    String nuevaEditorial = scanner.nextLine();
                    if (!nuevaEditorial.trim().isEmpty()) {
                        libro.setEditorial(nuevaEditorial);
                        System.out.println("✅ Editorial actualizada.");
                    }
                    break;
                case 4:
                    System.out.print("Nuevo ISBN (actual: " + libro.getIsbn() + "): ");
                    String nuevoIsbn = scanner.nextLine();
                    if (!nuevoIsbn.trim().isEmpty()) {
                        libro.setIsbn(nuevoIsbn);
                        System.out.println("✅ ISBN actualizado.");
                    }
                    break;
                case 5:
                    System.out.print("Nuevos autores separados por comas (actuales: " + String.join(", ", libro.getAuthors()) + "): ");
                    String nuevosAutores = scanner.nextLine();
                    if (!nuevosAutores.trim().isEmpty()) {
                        libro.getAuthors().clear();
                        String[] authors = nuevosAutores.split(",");
                        for (String author : authors) {
                            libro.getAuthors().add(author.trim());
                        }
                        System.out.println("✅ Autores actualizados.");
                    }
                    break;
                case 6:
                    System.out.print("¿Está leído? (true/false) (actual: " + libro.isReaded() + "): ");
                    boolean nuevoEstado = scanner.nextBoolean();
                    libro.setReaded(nuevoEstado);
                    if (nuevoEstado) {
                        System.out.print("Horas de lectura: ");
                        int nuevasHoras = scanner.nextInt();
                        libro.setTimeReaded(nuevasHoras);
                    } else {
                        libro.setTimeReaded(0);
                    }
                    scanner.nextLine();
                    System.out.println("✅ Estado de lectura actualizado.");
                    break;
                case 0:
                    System.out.println("✅ Actualización completada.");
                    break;
                default:
                    System.out.println("❌ Opción no válida.");
            }
        } while (opcionUpdate != 0);
    }

    private static void mostrarMenuActualizacion() {
        System.out.println("\n--- ✏️ CAMPOS A ACTUALIZAR ---");
        System.out.println("1. Título");
        System.out.println("2. Fecha de edición");
        System.out.println("3. Editorial");
        System.out.println("4. ISBN");
        System.out.println("5. Autores");
        System.out.println("6. Estado de lectura");
        System.out.println("0. Terminar actualización");
        System.out.print("Seleccione el campo a actualizar: ");
    }
}
