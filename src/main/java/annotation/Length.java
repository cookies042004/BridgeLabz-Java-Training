package annotation;

import java.lang.reflect.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {

    @MaxLength(5)
    private String username;

    public User(String username) throws Exception {

        Field field = this.getClass().getDeclaredField("username");
        MaxLength max = field.getAnnotation(MaxLength.class);

        if (username.length() > max.value()) {
            throw new IllegalArgumentException("Username too long!");
        }

        this.username = username;
    }
}
