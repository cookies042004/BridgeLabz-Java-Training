package annotation;

import java.lang.reflect.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AdminService {
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted");
    }

    public static void main(String[] args) throws Exception {

        String currentUserRole = "USER"; // change to ADMIN

        AdminService service = new AdminService();
        Method method = AdminService.class.getMethod("deleteUser");

        RoleAllowed role = method.getAnnotation(RoleAllowed.class);

        if (role.value().equals(currentUserRole)) {
            method.invoke(service);
        } else {
            System.out.println("Access Denied!");
        }
    }
}
