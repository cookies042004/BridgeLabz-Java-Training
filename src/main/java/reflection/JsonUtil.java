package reflection;

import java.lang.reflect.*;

public class JsonUtil {
    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < fields.length; i++) {

            fields[i].setAccessible(true);

            sb.append("\"")
                    .append(fields[i].getName())
                    .append("\":\"")
                    .append(fields[i].get(obj))
                    .append("\"");

            if (i < fields.length - 1) sb.append(",");
        }

        sb.append("}");

        return sb.toString();
    }
}
