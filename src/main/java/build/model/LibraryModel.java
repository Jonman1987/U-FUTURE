package build.model;

import build.model.books.BooksCards;

import java.util.LinkedList;
import java.util.List;

public class LibraryModel implements Model {
    private LinkedList<BooksCards> items = new LinkedList<>();

    @Override
    public boolean addBook(String title, String author, int publicationYear, String isbn) {
        return items.add(new BooksCards(title, author, publicationYear, isbn));
    }

    @Override
    public boolean deleteBook(String title, String author, int publicationYear, String isbn) {
        return items.remove(new BooksCards(title, author, publicationYear, isbn));
    }

    @Override
    public String[] findByTitle(String title) {
        List<BooksCards> foundResult = items.stream().filter(i -> i.getTitle().equalsIgnoreCase(title)).toList();

        if (foundResult.isEmpty()) {
            return new String[]{"", "Совпадения не найдены.", ""};
        }

        String[] array = new String[foundResult.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = foundResult.get(i).toString();
        }

        return array;
    }

    @Override
    public String[] findByAuthor(String author) {
        List<BooksCards> foundResult = items.stream().filter(i -> i.getAuthor().equalsIgnoreCase(author)).toList();

        if (foundResult.isEmpty()) {
            return new String[]{"", "Совпадения не найдены.", ""};
        }

        String[] array = new String[foundResult.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = foundResult.get(i).toString();
        }

        return array;
    }

    @Override
    public String[] findByPublicationYear(int publicationYear) {
        List<BooksCards> foundResult = items.stream().filter(i -> i.getPublicationYear() == publicationYear).toList();

        if (foundResult.isEmpty()) {
            return new String[]{"", "Совпадения не найдены.", ""};
        }

        String[] array = new String[foundResult.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = foundResult.get(i).toString();
        }

        return array;
    }

    @Override
    public String[] findByIsbn(String isbn) {
        List<BooksCards> foundResult = items.stream().filter(i -> i.getAuthor().equals(isbn)).toList();

        if (foundResult.isEmpty()) {
            return new String[]{"", "Совпадения не найдены.", ""};
        }

        String[] array = new String[foundResult.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = foundResult.get(i).toString();
        }

        return array;
    }

    @Override
    public String[] showAllBooks() {
        List<BooksCards> allResult = items.stream().toList();
        String[] array = new String[allResult.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = allResult.get(i).toString();
        }

        return array;
    }

    @Override
    public boolean contains(String title, String author, int publicationYear, String isbn) {
        List<BooksCards> foundResult = items.stream().filter(i -> {
            boolean a = i.getPublicationYear() == publicationYear;
            boolean b = i.getTitle().equalsIgnoreCase(title);
            boolean c = i.getAuthor().equalsIgnoreCase(author);
            boolean d = i.getIsbn().equalsIgnoreCase(isbn);

            return a && b && c && d;
        }).toList();

        return !foundResult.isEmpty();
    }
}
