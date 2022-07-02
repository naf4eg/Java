package func.task6_ссылки;

import java.util.Objects;

class Book {
    private String title;
    private String isbn;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public static Book releaseBook(Book book, String isbn) {
        if (Objects.isNull(book.isbn)) {
            book.setIsbn(isbn);
        }
        return book;
    }

    public String getTitleAndIsbnWithSeparator(String separator) {
        return title + separator + isbn;
    }
}
