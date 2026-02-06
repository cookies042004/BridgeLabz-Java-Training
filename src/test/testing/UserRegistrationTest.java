package testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {
    UserRegistration registration = new UserRegistration();

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() ->
                registration.registerUser(
                        "Akhil",
                        "akhil@gmail.com",
                        "pass123"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class,
                () -> registration.registerUser(
                        "", "akhil@gmail.com", "pass123"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> registration.registerUser(
                        "Akhil", "akhilgmail.com", "pass123"));
    }
}
