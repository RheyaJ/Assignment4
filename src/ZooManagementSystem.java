abstract class Animal {
    protected String name;
    protected int age;
    private static int counter = 0;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public abstract void makeSound();
    public abstract void move();

    public static int getAnimalCount() {
        return counter;
    }
}

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Bird extends Animal implements Flyable {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + "  makes loud crowing wails!");
    }

    @Override
    public void move() {
        System.out.println(name + "can walk and fly.");
    }

    @Override
    public void fly() {
        System.out.println(name + " can fly short distance.");
    }
}

class Fish extends Animal implements Swimmable {
    public Fish(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " makes bubbling sounds.");
    }

    @Override
    public void move() {
        System.out.println(name + " swims in water.");
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming at a fast pace.");
    }
}

class Duck extends Animal implements Flyable, Swimmable {
    public Duck(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " quacks!");
    }

    @Override
    public void move() {
        System.out.println(name + " waddles.");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying.");
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming.");
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meows!");
    }

    @Override
    public void move() {
        System.out.println(name + " walks quietly.");
    }
}

class Zookeeper {
    public void feedAllAnimals(Animal[] animals) {
        for(Animal a:animals)
            a.eat();
    }

    public void makeAnimalSound(Animal animal) {
        animal.makeSound();
    }
}

public class ZooManagementSystem {
    public static void main(String[] args) {
        Animal bird = new Bird("Peacock", 10);
        Animal fish = new Fish("Goldfish", 2);
        Animal duck = new Duck("Indian Duck", 50);
        Animal cat = new Cat("Black Cat", 12);

        Zookeeper zookeeper = new Zookeeper();

        Animal[] animals = {bird, fish, duck, cat};

        zookeeper.feedAllAnimals(animals);

        for (Animal a : animals) {
            zookeeper.makeAnimalSound(a);
            a.move();

            if (a instanceof Flyable) {
                ((Flyable) a).fly();
            }
            if (a instanceof Swimmable) {
                ((Swimmable) a).swim();
            }
        }

        System.out.println("Total animals in zoo: " + Animal.getAnimalCount());
    }
}