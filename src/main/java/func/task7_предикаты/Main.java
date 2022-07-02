package func.task7_предикаты;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Main {

    public static void printFilteredAccounts (List<Account> accounts) {
        List<Account> nonEmptyAccounts = filter(accounts, account -> account.getBalance() > 0);
        List<Account> accountsWithTooMuchMoney = filter(
            accounts,
            account -> !account.isLocked() && account.getBalance() >= 100000000
        );

        // Please, do not change the code below
        nonEmptyAccounts.forEach(a -> System.out.print(a.getNumber() + " \n"));
        System.out.println("--------------------------");
        accountsWithTooMuchMoney.forEach(a -> System.out.print(a.getNumber() + " \n"));
    }

    public static <T> List<T> filter (List<T> elems, Predicate<T> predicate) {
        return elems.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] values = scanner.nextLine().split("\\s+");
            Account acc = new Account(values[0], Long.parseLong(values[1]), Boolean.parseBoolean(values[2]));
            accounts.add(acc);
        }

        printFilteredAccounts(accounts);
    }

    static class Account {
        private String number;
        private long balance;
        private boolean locked;

        public Account (String number, long balance, boolean locked) {
            this.number = number;
            this.balance = balance;
            this.locked = locked;
        }

        public long getBalance () {
            return balance;
        }

        public void setBalance (long balance) {
            this.balance = balance;
        }

        public boolean isLocked () {
            return locked;
        }

        public void setLocked (boolean locked) {
            this.locked = locked;
        }

        public String getNumber () {
            return number;
        }

        public void setNumber (String number) {
            this.number = number;
        }

        @Override
        public String toString () {
            return "Account{" + "number='" + number + '\'' + ", balance=" + balance + ", isLocked=" + locked + '}';
        }
    }
}
