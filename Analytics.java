import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analytics {

    public void showReport(List<Task> tasks) {
        long totalTasks = tasks.size();
        long completedTasks = tasks.stream().filter(Task::isCompleted).count();
        long pendingTasks = totalTasks - completedTasks;

        Map<String, Long> priorityCount = tasks.stream()
                .collect(Collectors.groupingBy(Task::getPriorityLevel, Collectors.counting()));

        double completionPercentage = totalTasks > 0 ? (completedTasks * 100.0) / totalTasks : 0.0;

        System.out.println("\n--- Analytics Report ---");
        System.out.println("Total Tasks: " + totalTasks);
        System.out.println("Completed Tasks: " + completedTasks);
        System.out.println("Pending Tasks: " + pendingTasks);
        System.out.printf("Completion Rate: %.2f%%\n", completionPercentage);

        System.out.println("Tasks by Priority Level:");
        System.out.println(" - High Priority: " + priorityCount.getOrDefault("High", 0L));
        System.out.println(" - Medium Priority: " + priorityCount.getOrDefault("Medium", 0L));
        System.out.println(" - Low Priority: " + priorityCount.getOrDefault("Low", 0L));
    }
}

