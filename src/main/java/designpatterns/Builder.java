package designpatterns;

class User {

    private String name;
    private int age;
    private String email;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
    }

    public static class Builder {
        private String name;
        private int age;
        private String email;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public void display() {
        System.out.println(name + " " + age + " " + email);
    }
}

public class Builder {
    public static void main(String[] args) {
        User user = new User.Builder()
                .setName("Akhil")
                .setAge(22)
                .setEmail("akhil@email.com")
                .build();

        user.display();
    }
}
