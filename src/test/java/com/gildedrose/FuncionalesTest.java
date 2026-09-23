package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.example.test.annotation.SmokeTest;

class FuncionalesTest {

	@Test
	void test() {
		assertDoesNotThrow(() -> TexttestFixture.main(null));
	}

	@Test
	void resultTest() throws ProductListException {
        Item[] items_in = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
//                new Item("Conjured Mana Cake", 3, 6) 
                };
        Item[] items_out = new Item[] {
                new Item("+5 Dexterity Vest", 9, 19), //
                new Item("Aged Brie", 1, 1), //
                new Item("Elixir of the Mongoose", 4, 6), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
                // this conjured item does not work properly yet
//                new Item("Conjured Mana Cake", 2, 4) 
                };
        GildedRose app = new GildedRose(items_in);
        app.updateQuality();
        assertArrayEquals(items_out, app.getItems());
	}
        
	@Test
    @SmokeTest
	void instantanea() throws ProductListException {
		Item[] items = new Item[] { 
				new Item("+5 Dexterity Vest", 10, 20), 
				new Item("Aged Brie", 2, 0),
				new Item("Elixir of the Mongoose", 5, 7), 
				new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6) 
				};

		GildedRose app = new GildedRose(items);
		StringBuilder output = new StringBuilder();
		output.append("day,name, sellIn, quality\n");
                Arrays.stream(items).forEach(item -> output.append("0," + item + "\n"));
		for (int i = 1; i <= 31; i++) {
			app.updateQuality();
			for(Item item: items)
				output.append(i + "," + item + "\n");
		}
		Approvals.verify(output);
	}

}
