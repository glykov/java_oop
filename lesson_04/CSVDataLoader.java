import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVDataLoader extends DataLoader{
    public CSVDataLoader(String fileName) {
        super(fileName);
    }
    @Override
    public List<Task> loadFromFile() {
        List<Task> data = new ArrayList<>();
        try(Scanner in = new Scanner(new FileInputStream(new File(fileName)))) {
            while(in.hasNextLine()) {
                String line = in.nextLine();
                String[] tokens = line.split("\\|");
                Task t = new Task();
                t.setTaskId(Integer.parseInt(tokens[0]));
                t.setStart(LocalDate.parse(tokens[1]));
                t.setDescription(tokens[2]);
                t.setAuthor(tokens[3]);
                t.setPriority(Priority.valueOf(tokens[4]));
                t.setDeadline(LocalDate.parse(tokens[5]));
                data.add(t);
            }
        } catch(IOException e) {
            System.out.println("File " + fileName + " not found");
        }
        return data;
    }

    @Override
    public void saveToFile(List<Task> tasks) {
        try(PrintWriter out = new PrintWriter(fileName)) {
            for (Task t : tasks) {
                out.printf("%d|%s|%s|%s|%s|%s\n", t.getTaskId(), t.getStart(),
                        t.getDescription(), t.getAuthor(), t.getPriority(), t.getDeadline());
            }
        } catch (IOException e) {
            System.out.println("Cannot write to file " + fileName);
        }
    }
}
