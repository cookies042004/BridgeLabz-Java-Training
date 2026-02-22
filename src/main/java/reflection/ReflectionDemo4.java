package reflection;

class Student {
    String name;

    public Student() {
        name = "Default Student";
    }

    public void show() {
        System.out.println("Name: " + name);
    }
}

public class ReflectionDemo4 {
    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("Student");

        Object obj = clazz.getDeclaredConstructor().newInstance();

        Student student = (Student) obj;

        student.show();
    }
}