import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library bookLibrary = new Library();
        Scanner scanner = new Scanner(System.in);

        bookLibrary.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565");
        bookLibrary.addBook("1984", "George Orwell", 1949, "9780451524935");

        System.out.println("Do you want to add a book? (yes/no)");
        String answer = getAnswer(scanner);

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Enter book details:");
            String isbn = getInput(scanner, "Enter ISBN: ");
            String title = getInput(scanner, "Enter title: ");
            String author = getInput(scanner, "Enter author: ");
            int year = Integer.parseInt(getInput(scanner, "Enter year: "));

            bookLibrary.addBook(title, author, year, isbn);
        } else {
            System.out.println("No book added.");
            bookLibrary.displayBooks();
            scanner.close();
            return;
        }

        System.out.println("Do you want to search for a book? (yes/no)");
        answer = getAnswer(scanner);

        if (answer.equalsIgnoreCase("yes")) {
            String search = getInput(scanner, "Enter search (title or isbn): ");
            Book book = bookLibrary.findBook(search);

            if (book != null) {
                System.out.println("Found: Title: " + book.title + ", Author: " + book.author +
                        ", Year: " + book.year + ", ISBN: " + book.isbn);
            } else {
                System.out.println("Book not found.");
            }
        } else {
            System.out.println("No search performed.");
            System.out.println("Books in the library:");
            bookLibrary.displayBooks();
        }

        scanner.close();
    }

    private static String getAnswer(Scanner scanner) {
        return scanner.nextLine();
    }

    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
