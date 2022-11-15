import java.util.List;

public abstract class DataLoader {
    protected String fileName;

    public DataLoader(String fileName) {
        this.fileName = fileName;
    }

    public abstract List<Task> loadFromFile();

    public abstract void saveToFile(List<Task> tasks);
}
