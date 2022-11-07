import java.util.*;

public abstract class Animal {
    protected String name;

    public Animal() {
        this("");
    }

    public Animal(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void play();

    public abstract void eat();

    public abstract void obey();
}

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        this("");
    }

    @Override
    public void play() {
        waveTail();
        System.out.println("playing");
    }

    @Override
    public void eat() {
        waveTail();
        System.out.println("eating");
    }

    @Override
    public void obey() {
        waveTail();
        System.out.println("obeying");
    }

    private void waveTail() {
        System.out.println("waving its tail");
    }
}

public class Cat extends Animal{
    private boolean goodMood;

    public Cat(String name) {
        super(name);
    }

    public Cat() {
        this("");
    }

    private boolean getMood() {
        return Math.random() < 0.5;
    }

    @Override
    public void play() {
        if (!getMood()) {
            System.out.println("ignoring");
        } else {
            System.out.println("playing");
        }
    }

    @Override
    public void eat() {
        System.out.println("eating and asking for more");
    }

    @Override
    public void obey() {
        System.out.println("ignoring");
    }
}

public class Human {
    protected String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Master extends Human {
    private List<Animal> pets;
    private Interactor interactor;

    public Master(String name) {
        super(name);
        pets = new ArrayList<>();
        interactor = new PetInteractor();
    }

    public void addPet(Animal a) {
        pets.add(a);
    }

    public List<Animal> getPets() {
        return pets;
    }

    public void feedPets() {
        for (var a : pets) {
            interactor.interact(a, Interaction.EAT);
        }
    }

    public void playWithPets() {
        for (var a : pets) {
            interactor.interact(a, Interaction.PLAY);
        }
    }

    public void trainPets() {
        for (var a : pets) {
            interactor.interact(a, Interaction.OBEY);
        }
    }
}

public enum Interaction {
    PLAY, EAT, OBEY
}

public interface Interactor {
    void interact(Animal a, Interaction i);
}

public class PetInteractor implements Interactor{
    @Override
    public void interact(Animal a, Interaction i) {
        switch(i) {
            case PLAY:
                System.out.print(a.getName() + " is ");
                a.play();
                break;
            case EAT:
                System.out.print(a.getName() + " is ");
                a.eat();
                break;
            case OBEY:
                System.out.print(a.getName() + " is ");
                a.obey();
                break;
        }
    }
}

public class InteractionApp {
    public static void main(String[] args) {
        Master m = new Master("Pat Masters");
        m.addPet(new Cat("Kitty"));
        m.addPet(new Dog("Barboskin"));
        m.addPet(new Cat("Matroskin"));

        m.feedPets();
        m.playWithPets();
        m.trainPets();
    }
}

