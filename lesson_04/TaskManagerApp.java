import java.time.LocalDate;

public class TaskManagerApp {
    public static void main(String[] args) {
        Task t1 = new Task();
        Task t2 = new Task();
        t2.setPriority(Priority.HIGH);
        t2.setDescription("work");
        t2.setDeadline(LocalDate.now().plusDays(2));
        Task t3 = new Task();
        t3.setDeadline(LocalDate.now());
        t3.setPriority(Priority.MEDIUM);

        TaskManager tm = new TaskManager();
        tm.addTask(t1);
        tm.addTask(t2);
        tm.addTask(t3);

        tm.showTasks();
        tm.sortByPriority();
        System.out.println();
        tm.showTasks();
        System.out.println();
        tm.sortByDeadline();
        tm.showTasks();

        tm.saveTasksToFile("data.csv");

        TaskManager manager = new TaskManager();
        manager.getTasksFromFile("data.csv");
        System.out.println();
        manager.showTasks();
    }
}
