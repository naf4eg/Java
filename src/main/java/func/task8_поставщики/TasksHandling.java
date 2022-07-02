package func.task8_поставщики;

import java.util.Scanner;
import java.util.function.Supplier;

class TasksHandling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfQueues = Integer.parseInt(scanner.nextLine());
        int numberOfTasks = Integer.parseInt(scanner.nextLine());

        TaskManager manager = new TaskManager(numberOfQueues);

        for (int i = 0; i < numberOfTasks; i++) {
            String[] taskParts = scanner.nextLine().split("\\s+");
            long number = Long.parseLong(taskParts[0]);
            int priority = Integer.parseInt(taskParts[1]);
            Task task = new Task(number, priority);
            manager.add(task, priority);
        }

        Supplier<Task> taskSupplier = manager.getTaskSupplier();
        Task task;
        while ((task = taskSupplier.get()) != null) {
            System.out.println(task.getNumber());
        }
    }
}
