package reflection;

import java.util.*;

public class ObjectMapperDemo {
    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Akhil");
        map.put("age", 22);

        User user = ObjectMapperUtil.toObject(User.class, map);

        System.out.println(user);
    }
}
