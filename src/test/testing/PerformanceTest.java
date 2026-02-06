package testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class PerformanceTest {
    @Test
    @Timeout(2) // seconds by default
    void testPerformance() throws InterruptedException {
        Thread.sleep(3000);
    }
}
