package func.task5;

@FunctionalInterface
interface Retry {
    int run(Runnable action, int maxAttempts, long delayBeforeRetryMs);
}
