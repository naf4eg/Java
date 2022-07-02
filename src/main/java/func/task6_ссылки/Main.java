package func.task6_ссылки;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main (String[] args) {
        Book book = new Book("Java");
        Book.releaseBook(book, "999-000");
        System.out.println(book.getTitleAndIsbnWithSeparator(" | "));

        /*ссылка на конструктор*/
        Function<String, Book> book2new = Book::new;
        Book java_func = book2new.apply("Java func");
        Book.releaseBook(java_func, "333-000");
        System.out.println(java_func.getTitleAndIsbnWithSeparator(" | "));

        /*ссылка на статический метод*/
        BiFunction<Book, String, Book> releaseBookFunc = Book::releaseBook;
        Book kubernetes = releaseBookFunc.apply(new Book("Kubernetes"), "888-000");
        System.out.println(kubernetes.getTitleAndIsbnWithSeparator(" | "));

        Book book2 = book2new.apply("Kotlin");
        Book.releaseBook(book2, "444-000");

        /*ссылка на метод экземпляра класса*/
        Function<String, String> getTitleAndIsbnWithSeparator = book2::getTitleAndIsbnWithSeparator;
        String bookInfo = getTitleAndIsbnWithSeparator.apply(" | ");
        System.out.println(bookInfo);

        /*ссылка на метод класса*/
        Function<Book, String> getIsbn1 = Book::getIsbn;
        Book microservices1 = new Book("Microservices");
        Book.releaseBook(microservices1,"222-000");
        String microservicesIsbn = getIsbn1.apply(microservices1);
        System.out.println(microservicesIsbn);
    }
}
