package annotation;

import java.lang.reflect.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {

    @Todo(task = "Add login feature", assignedTo = "Akhil")
    public void login() {}

    @Todo(task = "Optimize DB", assignedTo = "Ravi", priority = "HIGH")
    public void optimize() {}
}

public class ToDo {
    public static void main(String[] args) {

        for (Method method : Project.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println(todo.task() + " - " + todo.assignedTo() +
                        " - " + todo.priority());
            }
        }
    }
}
