package annotation;

import java.lang.reflect.*;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class UserJson {
    @JsonField(name = "user_name")
    private String name = "Akhil";

    @JsonField(name = "user_age")
    private int age = 22;

    public static String toJson(Object obj) throws Exception {

        StringBuilder sb = new StringBuilder("{");

        for (Field field : obj.getClass().getDeclaredFields()) {

            field.setAccessible(true);

            if (field.isAnnotationPresent(JsonField.class)) {

                JsonField jf = field.getAnnotation(JsonField.class);

                sb.append("\"")
                        .append(jf.name())
                        .append("\":\"")
                        .append(field.get(obj))
                        .append("\",");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        UserJson userJson = new UserJson();
        System.out.println(toJson(userJson));
    }
}
