package semana14;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Author {
    String name;
    String email;
    char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}

class Book {
    String title;
    Author author;
    double price;
    int quantity;

    public Book(String title, Author author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }
}

class Library {
    List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("La biblioteca está vacía.");
        } else {
            for (Book book : books) {
                System.out.println(book.title + " - " + book.author.name + " - $" + book.price + " - Qty: " + book.quantity +
                        " - Email: " + book.author.email + " - Gender: " + book.author.gender);
            }
        }
    }

    public void addBook(String title, String authorName, String authorEmail, char authorGender, double price, int quantity) {
        Author author = new Author(authorName, authorEmail, authorGender);
        Book book = new Book(title, author, price, quantity);
        books.add(book);
        System.out.println("Libro agregado con éxito.");
    }

    public void deleteBook(String title) {
        books.removeIf(book -> book.title.equals(title));
        System.out.println("Libro eliminado con éxito.");
    }

    public void editBook(String title, String newTitle, String newAuthorName, String newAuthorEmail, char newAuthorGender, double newPrice, int newQuantity) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                book.title = newTitle;
                book.author.name = newAuthorName;
                book.author.email = newAuthorEmail;
                book.author.gender = newAuthorGender;
                book.price = newPrice;
                book.quantity = newQuantity;
                System.out.println("Libro editado con éxito.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    public String searchAuthorByBook(String title) {
        Book book = searchBookByTitle(title);
        return (book != null) ? book.author.name : null;
    }

    public void sortBooksByAuthor() {
        Collections.sort(books, Comparator.comparing(book -> book.author.name));
        System.out.println("Libros ordenados por autor.");
    }

    // Método para agregar la lista completa de libros
    public void addCompleteBookList() {
        addBook("Cien años de soledad", "Gabriel García Márquez", "gabriel@example.com", 'M', 200, 400);
        addBook("El señor de los anillos (Trilogía)", "J. R. R. Tolkien", "tolkien@example.com", 'M', 1500, 1200);
        addBook("1984", "George Orwell", "orwell@example.com", 'M', 500, 300);
        addBook("Un mundo feliz", "Aldous Huxley", "huxley@example.com", 'M', 320, 500);
        addBook("Orgullo y prejuicio", "Jane Austen", "austen@example.com", 'F', 130, 700);
        addBook("Crimen y castigo", "Fiódor Dostoyevski", "dostoyevski@example.com", 'M', 230, 540);
        addBook("Lolita", "Vladimir Nabokov", "nabokov@example.com", 'M', 140, 456);
        addBook("Ulises", "James Joyce", "joyce@example.com", 'M', 158, 400);
        addBook("Madame Bovary", "Gustave Flaubert", "flaubert@example.com", 'M', 120, 430);
        addBook("En busca del tiempo perdido", "Marcel Proust", "proust@example.com", 'M', 345, 450);
        addBook("Don Quijote de la Mancha", "Miguel de Cervantes", "cervantes@example.com", 'M', 340, 123);
        addBook("El retrato de Dorian Gray", "Oscar Wilde", "wilde@example.com", 'M', 125, 67);
        addBook("El Principito", "Antoine de Saint-Exupéry", "exupery@example.com", 'M', 259, 345);
        addBook("El ruido y la furia", "William Faulkner", "faulkner@example.com", 'M', 134, 246);
        addBook("Los viajes de Gulliver", "Jonathan Swift", "swift@example.com", 'M', 186, 234);
        addBook("Memorias de una geisha", "Arthur Golden", "golden@example.com", 'M', 195, 234);
        addBook("Los juegos del hambre", "Suzanne Collins", "collins@example.com", 'F', 181, 234);
        addBook("Harry Potter y la piedra filosofal", "J. K. Rowling", "rowling@example.com", 'F', 650, 4000);
        addBook("Los miserables", "Victor Hugo", "hugo@example.com", 'M', 23, 245);
        addBook("Las crónicas de Narnia", "C. S. Lewis", "lewis@example.com", 'M', 456, 444);
    }
}

public class Actividad01 {
    public static void main(String[] args) {
        Library library = new Library();
        library.addCompleteBookList(); 
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar libros");
            System.out.println("2. Agregar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Editar libro");
            System.out.println("5. Buscar libro por título");
            System.out.println("6. Buscar autor por libro");
            System.out.println("7. Ordenar libros por autor");
            System.out.println("8. Salir");

            System.out.print("Ingrese la opción deseada: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.print("Ingrese el título del libro: ");
                    String title = scanner.nextLine();
                    System.out.print("Ingrese el nombre del autor: ");
                    String authorName = scanner.nextLine();
                    System.out.print("Ingrese el email del autor: ");
                    String authorEmail = scanner.nextLine();
                    System.out.print("Ingrese el género del autor (M/F): ");
                    char authorGender = scanner.nextLine().toUpperCase().charAt(0); 
                    System.out.print("Ingrese el precio del libro: ");
                    double price = scanner.nextDouble();
                    System.out.print("Ingrese la cantidad de libros: ");
                    int quantity = scanner.nextInt();
                    library.addBook(title, authorName, authorEmail, authorGender, price, quantity);
                    break;
                case 3:
                    System.out.print("Ingrese el título del libro a eliminar: ");
                    String deleteTitle = scanner.nextLine();
                    library.deleteBook(deleteTitle);
                    break;
                case 4:
                    System.out.print("Ingrese el título del libro a editar: ");
                    String editTitle = scanner.nextLine();
                    System.out.print("Ingrese el nuevo título del libro: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre del autor: ");
                    String newAuthorName = scanner.nextLine();
                    System.out.print("Ingrese el nuevo email del autor: ");
                    String newAuthorEmail = scanner.nextLine();
                    System.out.print("Ingrese el nuevo género del autor (M/F): ");
                    char newAuthorGender = scanner.nextLine().toUpperCase().charAt(0);  
                    System.out.print("Ingrese el nuevo precio del libro: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Ingrese la nueva cantidad de libros: ");
                    int newQuantity = scanner.nextInt();
                    library.editBook(editTitle, newTitle, newAuthorName, newAuthorEmail, newAuthorGender, newPrice, newQuantity);
                    break;
                case 5:
                    System.out.print("Ingrese el título del libro a buscar: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.searchBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Libro encontrado: " + foundBook.title);
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el título del libro para buscar el autor: ");
                    String searchAuthorTitle = scanner.nextLine();
                    String author = library.searchAuthorByBook(searchAuthorTitle);
                    if (author != null) {
                        System.out.println("El autor de '" + searchAuthorTitle + "' es " + author);
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                case 7:
                    library.sortBooksByAuthor();
                    break;
                case 8:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}