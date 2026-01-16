package objectoriented.inheritance;

// interface
interface Worker{
    void performDuties();
}

// class Restaurant
class RestaurantPerson{
    String name;
    int id;

    RestaurantPerson(String name, int id){
        this.name = name;
        this.id = id;
    }
}
// Subclass 1
class Chef extends Person implements Worker {
    String specialtyDish;

    Chef(String name, int id, String specialtyDish) {
        super(name, id);
        this.specialtyDish = specialtyDish;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " (Chef) prepares " + specialtyDish);
    }
}

// Subclass 2
class Waiter extends Person implements Worker {
    int tablesAssigned;

    Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " (Waiter) serves customers at " + tablesAssigned + " tables");
    }
}

public class RestaurantMain {
    public static void main(String[] args) {
        Chef c = new Chef("Rahul", 1, "Pasta");
        Waiter w = new Waiter("Karan", 2, 5);

        c.performDuties();
        w.performDuties();
    }
}