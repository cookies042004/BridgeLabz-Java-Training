package designpatterns;

class Employee implements Cloneable {

    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void display() {
        System.out.println(name + " " + id);
    }
}

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee e1 = new Employee("Akhil", 101);
        Employee e2 = (Employee) e1.clone();

        e1.display();
        e2.display();

        System.out.println(e1 == e2);  // false (different object)
    }
}