/**
 * Реализовать, с учетом ооп подхода, приложение Для проведения исследований с генеалогическим древом. 
 */

import java.util.*;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


public enum Relationship {
    child(1), parent(2), sibling(3), spouce(4);

    private int code;

    Relationship(int code) {
        this.code = code;
    }

    int getCode() {
        return code;
    }
}


public class FamilyMemeber {
    Person member;
    boolean wasVisited;

    public FamilyMemeber(String name) {
        member = new Person(name);
        wasVisited = false;
    }

    public String getName() {
        return member.getName();
    }

    @Override
    public int hashCode() {
        return member.getName().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (getClass() != other.getClass())
            return false;
        FamilyMemeber person = (FamilyMemeber) other;
        return this.getName().equals(person.getName());
    }
}

public class Connection {
    FamilyMemeber src;
    FamilyMemeber dest;
    Relationship relationship;

    public Connection(FamilyMemeber m1, Relationship re, FamilyMemeber m2) {
        src = m1;
        dest = m2;
        relationship = re;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public String getSourceName() {
        return src.getName();
    }

    public String getDestinationName() {
        return dest.getName();
    }
}

public class FamilyTree {
    Set<FamilyMemeber> familyMembers;
    Map<FamilyMemeber, List<Connection>> family;

    public FamilyTree() {
        familyMembers = new HashSet<>();
        family = new HashMap<>();
    }

    public void addMember(String name1, Relationship re, String name2) {
        FamilyMemeber m1 = new FamilyMemeber(name1);
        FamilyMemeber m2 = new FamilyMemeber(name2);
        familyMembers.add(m1);
        familyMembers.add(m1);
        familyMembers.add(m2);
        familyMembers.add(m2);
        Connection connection = new Connection(m1, re, m2);
        Connection reverseConnection;
        if (re == Relationship.child) {
            reverseConnection = new Connection(m2, Relationship.parent, m1);
        } else if (re == Relationship.parent) {
            reverseConnection = new Connection(m2, Relationship.child, m1);
        } else {
            reverseConnection = connection;
        }
        if (!family.containsKey(m1)) {
            family.put(m1, new ArrayList<>());
        }
        if (!family.containsKey(m2)) {
            family.put(m2, new ArrayList<>());
        }
        family.get(m1).add(connection);
        family.get(m2).add(reverseConnection);
    }

    public List<Connection> getConnections(String name) {
        for (var member : family.keySet()) {
            if (member.getName().equals(name)) {
                return family.get(member);
            }
        }
        return null;
    }

    public boolean contains(FamilyMemeber m) {
        return family.containsKey(m);
    }
}

public class Research {
    FamilyTree tree;
    List<String> result = new ArrayList<>();

    public Research(FamilyTree ft) {
        tree = ft;
    }

    public void research(String name, Relationship re) {
        List<Connection> connections = tree.getConnections(name);
        if (!connections.isEmpty()) {
            for (var connection : connections) {
                if (connection.getRelationship() == re) {
                    result.add(connection.getDestinationName());
                }
            }
        } else {
            System.out.println("There is no such member in the family");
        }
    }

    public void printResult() {
        System.out.print("[");
        for (var e : result) {
            System.out.print(e + ", ");
        }
        System.out.println("]");
    }
}


public class FamilyTreeApp {
    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree();

        ft.addMember("vasya", Relationship.child, "masha");
        ft.addMember("vasya", Relationship.child, "petya");
        ft.addMember("sveta", Relationship.child, "masha");
        ft.addMember("sveta", Relationship.child, "petya");

        Research research = new Research(ft);
        research.research("vasya", Relationship.child);
        research.printResult();
    }
}
