package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class ItemTest {

	@Test
	void qualityValidTest() {
		Item actual = new Item("algo", 0, 0);
		assertEquals(0, actual.getQuality());
	}
	@Test
	@Timeout(value = 40, unit = TimeUnit.MILLISECONDS)
	void qualityInvalidTest() {
		Item actual = new Item("algo", 0, 0);
		assertThrows(Exception.class, () -> actual.setQuality(-1));
	}

}
