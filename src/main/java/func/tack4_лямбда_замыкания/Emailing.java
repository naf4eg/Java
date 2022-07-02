package func.tack4_лямбда_замыкания;

import java.util.Scanner;
import java.util.function.Function;

//In this exercise, you need to write a function that formats email messages according to a certain format. This format states that a message consists of four parts: a sender's email, a receiver's email, a text, and a signature. All the parts are separated by the special "|" character. To write the formatter, you need to use a lambda expression that takes only text as the argument and captures all other variables (sender, receiver and signature) from the context.
//
//Let's consider an example. Imagine there is an input text "The new version of Java works pretty fast!". The sender is "sender@mymail.com", the receiver is "receiver@mymail.com" and the signature is "Best regards, James Gosling". Here is the message created in accordance with the described format:
//
//sender@mymail.com|receiver@mymail.com|The new version of Java works pretty fast!|Best regards, James Gosling
//Take a look that there is no extra white spaces before and after the "|" characters.
//
//Sample Input:
//sender@mymail.com
//receiver@mymail.com
//Best regards, James Gosling
//
//The new version of Java works pretty fast!
//Sample Output: sender@mymail.com|receiver@mymail.com|The new version of Java works pretty fast!|Best regards, James Gosling
// исполльзуем замыкание, тоесть захватываем переменные из контекста
class Emailing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sender = scanner.nextLine();
        String receiver = scanner.nextLine();
        String signature = scanner.nextLine();

        Function<String, String> emailFormatter = text -> sender + "|" + receiver + "|" + text + "|" + signature;

        System.out.println(emailFormatter.apply(scanner.nextLine()));
    }
}
