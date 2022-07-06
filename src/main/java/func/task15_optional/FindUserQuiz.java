package func.task15_optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

class FindUserQuiz {

    public static Optional<User> findUserByAccountId (Set<User> users, String id) {
        Map<String, User> map = new HashMap<>();
        users.forEach(user -> user.getAccount().ifPresent(account -> {
            if (account.getId().equals(id)) {
                map.put(id, user);
            }
        }));
        return map.isEmpty() ? Optional.empty() : Optional.of(map.get(id));
    }
}
