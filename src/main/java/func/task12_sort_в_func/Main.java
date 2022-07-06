package func.task12_sort_в_func;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account("Peter", 1000L, false));
        accounts.add(new Account("John", 1000L, false));
        accounts.add(new Account("Ivan", 8000L, true));
        accounts.add(new Account("Helen", 5000L, false));
        accounts.add(new Account("Nicole", 3000L, true));

        accounts.sort(Account.getComparatorByLockedBalanceAndOwner());

        accounts.forEach(System.out::println);
    }
}
