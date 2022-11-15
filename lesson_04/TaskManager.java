import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private DataLoader loader;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task t) {
        tasks.add(t);
    }

    public boolean remove(Task t) {
        return tasks.remove(t);
    }

    public void showTasks() {
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void sortByPriority() {
        tasks.sort(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return Priority.valueOf(o2.getPriority()).ordinal() - Priority.valueOf(o1.getPriority()).ordinal();
            }
        });
    }

    public void sortByDeadline() {
        tasks.sort(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getDeadline().compareTo(o2.getDeadline());
            }
        });
    }

    public void saveTasksToFile(String fileName) {
        loader = new CSVDataLoader(fileName);
        loader.saveToFile(tasks);
    }

    public void getTasksFromFile(String fileName) {
        loader = new CSVDataLoader(fileName);
        tasks = loader.loadFromFile();
    }
}
