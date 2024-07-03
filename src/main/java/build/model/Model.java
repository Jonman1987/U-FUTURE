package build.model;

public interface Model {
    boolean addBook(String title, String author, int publicationYear, String isbn);
    boolean deleteBook(String title, String author, int publicationYear, String isbn);
    String[] findByTitle(String title);
    String[] findByAuthor(String author);
    String[] findByPublicationYear(int publicationYear);
    String[] findByIsbn(String isbn);
    String[] showAllBooks();
    boolean contains(String title, String author, int publicationYear, String isbn);
}
