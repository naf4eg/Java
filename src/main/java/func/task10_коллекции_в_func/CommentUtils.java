package func.task10_коллекции_в_func;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

final class CommentUtils {
    /**
     * An example string that fits the format "15-03-2020 10:20:34".
     * Use it to print the comments.
     */
    public static final SimpleDateFormat TEXT_FORMATTER = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private CommentUtils () {
    }

    /**
     * It processes a given list of comments by removing old comments and shortening the text length
     */
    public static void handleComments (List<Comment> comments, Date thresholdDate, int maxTextLength) {
        comments.removeIf(comment -> comment.getCreated().before(thresholdDate));
        comments.replaceAll(comment -> new Comment(
            comment.getCreated(),
            comment.getText().substring(0, Math.min(comment.getText().length(), maxTextLength))
        ));
    }

    /**
     * It prints each comment in the following format:
     * [14-03-2020 10:20:34] What a beautiful photo! Where is it?
     * [16-03-2020 15:35:18] I do not know, I just found it on the internet!
     * [20-03-2020 19:10:22] Is anyone here?
     * Please, use the formatter above to fit the format.
     */
    public static void printComments (List<Comment> comments) {
        comments.forEach(comment -> System.out.printf("[%s] %s%n",
            TEXT_FORMATTER.format(comment.getCreated()),
            comment.getText()
        ));
    }
}
