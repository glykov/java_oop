public class FamilyTreeApp {
    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree();
        ft.addMember(new Person("Ivan"));
        ft.addMember(new Person("Maria"));
        ft.addMember(new Person("Peter"));
        ft.addMember(new Person("Kosma"));

        ft.addRelation(0, 1, Relations.CHILD);
        ft.addRelation(0,2, Relations.CHILD);
        ft.addRelation(3, 1, Relations.PARENT);

        System.out.println("Ivan's family tree");
        ft.showAncestors("Ivan");
    }
}
