package reflection;

import java.lang.reflect.*;

class Service {
    public void serve() {
        System.out.println("Service executed");
    }
}

class Client {

    @Inject
    private Service service;

    public void doWork() {
        service.serve();
    }
}

public class DIContainer {
    public class DIDemo {

        public static void main(String[] args) throws Exception {

            Client client = DIContainer.createInstance(Client.class);
            client.doWork();
        }
    }
    public static <T> T createInstance(Class<T> clazz) throws Exception {

        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {

            if (field.isAnnotationPresent(Inject.class)) {

                field.setAccessible(true);
                Object dependency = field.getType()
                        .getDeclaredConstructor()
                        .newInstance();

                field.set(obj, dependency);
            }
        }

        return obj;
    }
}
