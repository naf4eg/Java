package func.task12_sort_в_func;

import java.util.Comparator;

public class Account {
    private final String owner;
    private final long balance;
    private final boolean locked;

    public Account (String owner, long balance, boolean locked) {
        this.owner = owner;
        this.balance = balance;
        this.locked = locked;
    }

    /* Now you need to support an ability to sort accounts by their locked flag,
       balance and the name of the owner. After sorting, non-blocked accounts should be
       placed before the blocked ones and they must be sorted by balance in descending order.
       If the balances are the same, the accounts must also be sorted by owner name in lexicographic order.
       To support this sorting mechanism, just implement the getComparatorByLockedBalanceAndOwner method by
       returning an appropriate comparator. */
    public static Comparator<? super Account> getComparatorByLockedBalanceAndOwner () {
        return Comparator
            .comparing(Account::isLocked)
            .thenComparing(Account::getBalance, Comparator.reverseOrder())
            .thenComparing(Account::getOwner);
    }

    public String getOwner () {
        return owner;
    }

    public long getBalance () {
        return balance;
    }

    public boolean isLocked () {
        return locked;
    }

    @Override
    public String toString () {
        return "Account{" + "owner='" + owner + '\'' + ", balance=" + balance + ", locked=" + locked + '}';
    }
}
