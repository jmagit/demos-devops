package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GildedRoseTest {
    Item[] samples = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };

    @ParameterizedTest(name = "{index} => sellIn: {0} quality: {1} –> sellIn: {2} quality: {3}")
	@CsvSource({
		"2, 0, 1, 1",
		"-1, 48, -2, 50",
		"2, 50, 1, 50",
		"-2, 49, -3, 50",
		"1, 1, 0, 2",
		})
	void product_Aged_Brie_Test(int sellIn, int quality, int sellInResult, int qualityResult) throws ProductListException {
		String name = "Aged Brie";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}
	@ParameterizedTest(name = "{index} => sellIn: {0} quality: {1} –> sellIn: {2} quality: {3}")
	@CsvSource({
		"1, 0, 1, 0",
		"0, 1, 0, 1",
		"-1, 1, -1, 1",
		})
	void product_Sulfuras_Test(int sellIn, int quality, int sellInResult, int qualityResult) throws ProductListException {
		String name = "Sulfuras, Hand of Ragnaros";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}
	@ParameterizedTest(name = "{index} => sellIn: {0} quality: {1} –> sellIn: {2} quality: {3}")
	@CsvSource({
		"11, 0, 10, 1",
		"7, 1, 6, 3",
		"7, 49, 6, 50",
		"5, 3, 4, 6",
		"0, 3, -1, 0",
		"-1, 3, -2, 0",
		})
	void product_Passes_Test(int sellIn, int quality, int sellInResult, int qualityResult) throws ProductListException {
		String name = "Backstage passes to a TAFKAL80ETC concert";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}
	@ParameterizedTest(name = "{index} => sellIn: {0} quality: {1} –> sellIn: {2} quality: {3}")
	@CsvSource({
		"11, 10, 10, 9",
		"7, 1, 6, 0",
//		"5, -5, 4, 0",
		"0, 3, -1, 1",
		})
	void other_Product_Test(int sellIn, int quality, int sellInResult, int qualityResult) throws ProductListException {
		String name = "Normal Product";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}
	@ParameterizedTest(name = "{index} => sellIn: {0} quality: {1} –> sellIn: {2} quality: {3}")
	@CsvSource({
		"5, -5, 4, 0",
		})
	void other_Product_KO_Test(int sellIn, int quality, int sellInResult, int qualityResult) throws ProductListException {
		String name = "Normal Product";
		Item product = new Item(name, sellIn, 1);
		product.quality = quality;
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}

	@ParameterizedTest(name = "{index} => sellIn: {0} quality: {1} –> sellIn: {2} quality: {3}")
	@CsvSource({
		"5, -5, 5, -5",
		})
	void Item_CTOR_KO_Test(int sellIn, int quality, int sellInResult, int qualityResult) throws ProductListException {
		String name = "Normal Product";
        assertThrows(IllegalArgumentException.class, () -> new Item(name, sellIn, quality));
	}
	@ParameterizedTest(name = "{index} => sellIn: {0} quality: {1} –> sellIn: {2} quality: {3}")
	@CsvSource({
		"11, 10, 10, 8",
		"7, 1, 6, 0",
		"-5, 10, -6, 6",
		"0, 3, -1, 0",
		})
	void product_Conjured_Test(int sellIn, int quality, int sellInResult, int qualityResult) throws ProductListException {
		String name = "Conjured Mana Cake";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}

	@Test
	void getItems_Test() throws ProductListException {
		String name = "Normal Product";
		Item product = new Item("Normal Product", 1, 1);
		Item[] originalItems = new Item[] { 
        		product
        };
        GildedRose app = new GildedRose(originalItems);
        originalItems[0] = null;
        
        Item[] rsltItems = app.getItems();
        rsltItems[0] = null;
        app.updateQuality();
        assertNotNull(rsltItems);
        assertEquals(1, rsltItems.length);
	}

	@Test
	void getItem_Test() throws ProductListException {
		String name = "Normal Product";
		Item product = new Item("Normal Product", 1, 2);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        Item rsltItem = app.getItem(0);
        assertNotNull(rsltItem);
        assertAll(name,
        		() -> assertEquals("Normal Product", rsltItem.name, "name"),
        		() -> assertEquals(1, rsltItem.sellIn, "sellIn"),
        		() -> assertEquals(2, rsltItem.quality, "quality")
        		);
	}

	@ParameterizedTest(name = "{0} => sellIn: {1} quality: {2} –> sellIn: {3} quality: {4}")
	@CsvFileSource(resources = "casos-de-prueba.csv", numLinesToSkip = 1)
	@Disabled
	void datasourceTest(String producto, int sellIn, int quality, int sellInResult, int qualityResult) throws ProductListException {
		String name = producto.replace("\'", "");
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}

}
