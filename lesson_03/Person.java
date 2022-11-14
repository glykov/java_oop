public class Person {
    private String name;
    private boolean visited;

    public Person(String name) {
        this.name = name;
        visited = false;
    }

    public String getName() {
        return name;
    }

    public void setVisitedStatus(boolean b) {
        visited = b;
    }

    public boolean wasVisited() {
        return visited;
    }
}
