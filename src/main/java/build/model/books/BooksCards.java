package build.model.books;

public class BooksCards {
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;

    public BooksCards(String title, String author, int publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Название: " + title + ". Автор: " + author + ". Год издания: " + publicationYear + ". Рейтинг ISBN: "
                + isbn + ".";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        BooksCards booksCards = (BooksCards) object;

        return title.equals(booksCards.title) && author.equals(booksCards.author)
                && publicationYear == booksCards.publicationYear && isbn.equals(booksCards.isbn);
    }
}
