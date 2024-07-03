package build.controller;

import build.model.Model;
import build.view.View;

public class LibraryController implements Controller {
    private final View view;
    private final Model model;

    public LibraryController(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
    }

    public void doOperation(int operationValue, String title, String author, int publicationYear, String isbn) {
        switch (operationValue) {
            case 1: {
                if(model.contains(title, author, publicationYear, isbn)){
                    view.showResult("");
                    view.showResult("Запись уже существует.");
                    view.showResult("");
                    break;
                }

                if(model.addBook(title, author, publicationYear, isbn)){
                    view.showResult("");
                    view.showResult("Запись успешно добавлена.");
                    view.showResult("");
                    break;
                }

                view.showResult("");
                view.showResult("Ошибка добавления.");
                view.showResult("");
                break;
            }

            case 2: {
                if(model.deleteBook(title, author, publicationYear, isbn)){
                    view.showResult("");
                    view.showResult("Запись успешно удалена.");
                    view.showResult("");
                    break;
                }

                view.showResult("");
                view.showResult("Ошибка удаления.");
                view.showResult("");
                break;
            }

            case 31: {
                view.showResult(model.findByTitle(title));
                break;
            }

            case 32: {
                view.showResult(model.findByAuthor(author));
                break;
            }

            case 33: {
                view.showResult(model.findByPublicationYear(publicationYear));
                break;
            }

            case 34: {
                view.showResult(model.findByIsbn(isbn));
                break;
            }

            case 4: {
                if(model.showAllBooks().length == 0){
                    view.showResult("");
                    view.showResult("Записи отсутствуют.");
                    view.showResult("");
                    break;
                }

                view.showResult(model.showAllBooks());
            }
        }
    }
}
