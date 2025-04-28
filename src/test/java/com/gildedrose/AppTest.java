package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void testRun_no_args_OK() {
        App app = new App();
        assertDoesNotThrow(() -> app.run(null));
    }
    @Test
    void testRun_1_args_OK() {
        App app = new App();
        assertDoesNotThrow(() -> app.run(new String[] {"1"}));
    }
    @Test
    void testRunKO() {
        App app = new App();
        assertThrows(NumberFormatException.class, () -> app.run(new String[] {"kk"}));
    }
}
