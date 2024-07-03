package concolelibraryapptest;

import build.model.LibraryModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LibraryModelTest {
    private LibraryModel libraryModel = new LibraryModel();

    @Test
    public void addBookTest(){
        Assertions.assertTrue(libraryModel.addBook("Евгений Онегин.", "Пушкин А.С.", 1823, "978-5-93673-265-2"));
    }

    @Test
    public void deleteBookTest(){
        libraryModel.addBook("Евгений Онегин.", "Пушкин А.С.", 1823, "978-5-93673-265-2");
        Assertions.assertTrue(libraryModel.deleteBook("Евгений Онегин.", "Пушкин А.С.", 1823, "978-5-93673-265-2"));
    }

    @Test
    public void deleteBookNegativeTest(){
        libraryModel.addBook("Евгений Онегин.", "Пушкин А.С.", 1823, "978-5-93673-265-2");
        Assertions.assertFalse(libraryModel.deleteBook("Евгений Онегин.", "Гоголь Н.В.", 1823, "978-5-93673-265-2"));
    }

    @Test
    public void findByTitle(){
        libraryModel.addBook("Евгений Онегин.", "Пушкин А.С.", 1823, "978-5-93673-265-2");
        Assertions.assertNotEquals(libraryModel.findByTitle("Евгений Онегин."), new String[]{"Название: Нос. Автор: Гоголь Н.В. Год издания: 1823. Рейтинг ISBN: 978-5-93673-265-2."});
    }
}
