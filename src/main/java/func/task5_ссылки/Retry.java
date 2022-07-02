package func.task5_ссылки;

@FunctionalInterface
interface Retry {
    int run(Runnable action, int maxAttempts, long delayBeforeRetryMs);
}
