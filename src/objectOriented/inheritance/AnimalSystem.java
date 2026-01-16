package objectOriented.inheritance;


// creating superClass Animal
class Animal{
    String name;
    int age;

    void makeSound(){
        System.out.println("Animal sound");
    }
}

// subclass using superclass
class Dog extends Animal{
    @Override
    void makeSound(){
        System.out.println("Dog sound");
    }
}

class Cat extends Animal{
    @Override
    void makeSound(){
        System.out.println("Cat Sound");
    }
}

class Bird extends Animal{
    @Override
    void makeSound(){}

}

public class AnimalSystem {
    public static void main(String[] args) {

    }
}

