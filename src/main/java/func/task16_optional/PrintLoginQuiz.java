package func.task16_optional;

import java.util.Set;

class PrintLoginQuiz {

    public static void printLoginIfPro (Set<User> users, String id) {
        users.forEach(user -> {
            user.getAccount()
                .filter(account -> account.getId().equals(id))
                .filter(account -> account.getType().equals("pro"))
                .ifPresent(value -> System.out.println(user.getLogin()));
        });
    }
}
