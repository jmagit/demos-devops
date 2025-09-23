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

	@Test
	void equalsTest() {
		Item actual = new Item("algo", 0, 0);
		Item nuevo = new Item("nuevo", 1, 2);
		
		nuevo.setName(actual.getName());
		nuevo.setQuality(actual.getQuality());
		nuevo.setSellIn(actual.getSellIn());
		
		assertAll("equals",
				() -> assertTrue(actual.equals(nuevo), "directa"),
				() -> assertTrue(nuevo.equals(actual), "conmutativa"),
				() -> assertTrue(nuevo.equals(nuevo), "igual a si mismo"),
				() -> assertFalse(nuevo.equals(null), "nunca es igual a null"),
				() -> assertTrue(nuevo.hashCode() == actual.hashCode(), "deben coincidir sus hashCode")
		);
	}
	@Test
	void notEqualsTest() {
		Item actual = new Item("algo", 0, 0);
		Item nuevo = new Item("nuevo", 1, 2);
		
		assertAll("equals",
				() -> assertFalse(actual.equals(nuevo), "directa"),
				() -> assertFalse(nuevo.equals(actual), "conmutativa"),
				() -> assertFalse(actual.equals(new Item("algoo", 0, 0)), "name"),
				() -> assertFalse(actual.equals(new Item("algo", 10, 0)), "sellIn"),
				() -> assertFalse(actual.equals(new Item("algo", 0, 10)), "quality"),
				() -> assertFalse(nuevo.equals("otro tipo"), "otro tipo"),
				() -> assertTrue(nuevo.hashCode() != actual.hashCode(), "deben coincidir sus hashCode")
		);
	}

}
