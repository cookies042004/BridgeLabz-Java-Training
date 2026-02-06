package testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {
    DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDate() {
        assertEquals("25-12-2024",
                formatter.formatDate("2024-12-25"));
    }

    @Test
    void testInvalidDate() {
        assertThrows(IllegalArgumentException.class,
                () -> formatter.formatDate("invalid-date"));
    }
}
