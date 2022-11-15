import java.time.LocalDate;

public class Task {
    private int taskId;
    private LocalDate start;
    private LocalDate deadline;
    private Priority priority;
    private String description;
    private String author;

    public Task() {
        taskId = 0;
        start = LocalDate.now();
        deadline = LocalDate.MAX;
        priority = Priority.LOW;
        description = "rest";
        author = "Big Boss";
    }

    public Task(int taskId, LocalDate start, String description, String author, Priority priority, LocalDate deadline) {
        this.taskId = taskId;
        this.start = start;
        this.deadline = deadline;
        this.priority = priority;
        this.description = description;
        this.author = author;
    }

    public void setPriority(Priority level) {
        priority = level;
    }

    public String getPriority() {
        return priority.toString();
    }

    public void setDescription(String s) {
        description = s;
    }

    public String getDescription() {
        return description;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return  "id=" + taskId +
                ", start=" + start +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", priority=" + priority +
                ", deadline=" + deadline;
    }
}
