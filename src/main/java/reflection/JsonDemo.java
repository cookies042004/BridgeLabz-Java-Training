package reflection;

public class JsonDemo {
    public static void main(String[] args) throws Exception {
        User user = new User();

        // Setting via reflection for demo
        ObjectMapperUtil.toObject(User.class,
                java.util.Map.of("name", "Akhil", "age", 22));

        user = ObjectMapperUtil.toObject(User.class,
                java.util.Map.of("name", "Akhil", "age", 22));

        System.out.println(JsonUtil.toJson(user));
    }
}
