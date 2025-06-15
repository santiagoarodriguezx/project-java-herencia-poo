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
}
