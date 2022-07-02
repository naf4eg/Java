package func.task8_поставщики;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.function.Supplier;

class TaskManager {
    /**
     * Highest priority queues come first in the list.
     * The 0th queue contains tasks with the highest priority.
     */
    private final List<Queue<Task>> taskQueues = new ArrayList<>();

    public TaskManager(int numberOfQueues) {
        if (numberOfQueues < 1) {
            throw new IllegalArgumentException("The number of queues must be >= 1");
        }
        for (int i = 0; i < numberOfQueues; i++) {
            taskQueues.add(new ArrayDeque<>());
        }
    }

    public void add(Task task, int priority) {
        if (priority < 0 || priority >= taskQueues.size()) {
            throw new IllegalArgumentException("The task has an illegal priority " + priority);
        }
        taskQueues.get(priority).add(task);
    }

    /**
     * Returns a supplier to access tasks in the right order according to their priority.
     * If all the queues are empty, it returns null.
     */
    public Supplier<Task> getTaskSupplier() {
        return () -> {
            Task task = taskQueues.get(0).poll();
            if (Objects.isNull(task)) {
                taskQueues.remove(0);
                if (!taskQueues.isEmpty()) {
                    task = taskQueues.get(0).poll();
                }
            }
            return task;
        };
    }
}

