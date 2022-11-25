package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class FuncionalesTest {

	@Test
	void test() {
		assertDoesNotThrow(() -> TexttestFixture.main(null));
	}

}
