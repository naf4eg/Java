package func.task6;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main (String[] args) {
        Book book = new Book("Java");
        Book.releaseBook(book, "999-000");
        System.out.println(book.getTitleAndIsbnWithSeparator(" | "));

        Function<String, Book> book2new = Book::new;
        BiFunction<Book, String, Book> releaseBookFunc = Book::releaseBook;
        Book book2 = book2new.apply("Kotlin");
        Function<String, String> getTitleAndIsbnWithSeparator = book2::getTitleAndIsbnWithSeparator;
        Supplier<String> getIsbn = book2::getIsbn; //!
        Function<Book, String> getIsbn1 = Book::getIsbn;

    }
}
