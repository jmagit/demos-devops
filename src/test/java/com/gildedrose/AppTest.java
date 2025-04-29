package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.test.utils.PrivateField;

class AppTest {
    @Test
    void testRun_no_args_OK() {
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
    @Test
    void testRun_1_args_OK() {
        assertDoesNotThrow(() -> App.main(new String[] {"1"}));
    }
    @Test
    void testRunKO() {
        App app = new App();
        assertThrows(NumberFormatException.class, () -> app.run(new String[] {"kk"}));
    }
    @Test
    void testRunProductListExceptionKO() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        App app = new App();
        PrivateField.set(app, "items", null);
        assertThrows(ProductListException.class, () -> app.run(null));
    }
}
