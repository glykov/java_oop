import java.util.Queue;
import java.util.Stack;

public class FamilyTree {
    private static final int MAX_MEMBERS = 50;
    private Person[] memberList;
    private Relations[][] relMatrix;
    private int numMembers;
    private Stack<Integer> stack;
    private Queue<Integer> queue;

    public FamilyTree() {
        memberList = new Person[MAX_MEMBERS];
        relMatrix = new Relations[MAX_MEMBERS][MAX_MEMBERS];
        numMembers = 0;

        for (int i = 0; i < MAX_MEMBERS; i++) {
            for (int j = 0; j < MAX_MEMBERS; j++) {
                relMatrix[i][j] = Relations.NO;
            }
        }
    }

    public void addMember(Person member) {
        memberList[numMembers++] = member;
    }

    public void addRelation(int start, int end, Relations rel) {
        switch (rel) {
            case CHILD:
                relMatrix[start][end] = Relations.CHILD;
                relMatrix[end][start] = Relations.PARENT;
                break;
            case PARENT:
                relMatrix[start][end] = Relations.PARENT;
                relMatrix[end][start] = Relations.CHILD;
                break;
            case SIBLING:
                relMatrix[start][end] = Relations.SIBLING;
                relMatrix[end][start] = Relations.SIBLING;
                break;
        }
    }

    public void showMember(Person member) {
        System.out.println(member.getName());
    }

    private int findMember(String name) {
        for (int i = 0; i < numMembers; i++) {
            if (name.equals(memberList[i].getName())) {
                return i;
            }
        }
        return -1;
    }

    private int getAdjUnvisitedMember(int m, Relations rel) {
        for(int i = 0; i < numMembers; i++) {
            if (relMatrix[m][i] == rel && !memberList[i].wasVisited()) {
                return i;
            }
        }
        return -1;
    }

    public void showAncestors(String personName) {
        int index = findMember(personName);
        if (index == -1) {
            System.out.println("No family member with name " + personName);
            return;
        }
        memberList[index].setVisitedStatus(true);
        showMember(memberList[index]);

        stack = new Stack<>();
        stack.push(index);

        while(!stack.isEmpty()) {
            int m = getAdjUnvisitedMember(stack.peek(), Relations.CHILD);
            if (m == -1) {
                stack.pop();
            } else {
                memberList[m].setVisitedStatus(true);
                showMember(memberList[m]);
                stack.push(m);
            }
        }

        for (int i = 0; i < numMembers; i++) {
            memberList[i].setVisitedStatus(false);
        }
    }
}
