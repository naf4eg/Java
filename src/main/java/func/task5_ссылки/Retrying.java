package func.task5_ссылки;

import java.util.Scanner;

class Retrying {
    private static final int MAX_ATTEMPTS = 1;
    private static final long DELAY_MS = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RetryUtils.retry.run(() -> System.out.println(scanner.nextLine()), MAX_ATTEMPTS, DELAY_MS);
    }
}
