import java.util.ArrayList;

public class Library {
    public ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author, int year, String isbn) {
        Book book = new Book(title, author, year, isbn);
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.title + ", Author: " + book.author +
                    ", Year: " + book.year + ", ISBN: " + book.isbn);
        }
    }

    public Book findBook(String search) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(search) || book.isbn.equalsIgnoreCase(search)) {
                return book;
            }
        }
        return null;
    }
}