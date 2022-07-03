package func.task10_коллекции_в_func;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main (String[] args) throws ParseException {
        List<Comment> comments = new ArrayList<>();

        comments.add(new Comment(
            CommentUtils.TEXT_FORMATTER.parse("14-03-2020 10:20:34"),
            "What a beautiful photo! Where is it?"
        ));
        comments.add(new Comment(
            CommentUtils.TEXT_FORMATTER.parse("16-03-2020 15:35:18"),
            "I do not know, I just found it on the internet!"
        ));
        comments.add(new Comment(
            CommentUtils.TEXT_FORMATTER.parse("20-03-2020 19:10:22"),
            "Is anyone here?"
        ));

        Date threshold = CommentUtils.TEXT_FORMATTER.parse("15-03-2020 00:00:00");
        int maxTextLength = 30; // it is just an example, do not rely on this number!

        CommentUtils.handleComments(comments, threshold, maxTextLength);
        CommentUtils.printComments(comments);
    }
}
