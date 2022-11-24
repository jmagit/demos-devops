package com.gildedrose;

import java.util.stream.Stream;

public class Principal {

	public static void main(String[] args) {
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
	    try {
			GildedRose app = new GildedRose(samples);
			app.updateQuality();
			Stream.of(app.getItems())
				.forEach(item -> System.out.println(item.name + "(S: " + item.sellIn + ", Q: " + item.quality + ")" ));
		} catch (ProductListException e) {
			System.out.println("ERROR: " + e.getMessage());;
		}
	}

}
