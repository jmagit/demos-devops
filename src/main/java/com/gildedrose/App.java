package com.gildedrose;

import java.util.logging.Logger;

public class App {
    private static final String CONJURED = "Conjured Mana Cake";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String ELIXIR = "Elixir of the Mongoose";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String DEXTERITY_VEST = "+5 Dexterity Vest";

    private static Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        App app = new App();

        try {
            app.run(args);
        } catch (Exception e) {
            notificarExcepcion(e);
        }
    }

    private Item[] items = new Item[] {
            new Item(DEXTERITY_VEST, 10, 20), 
            new Item(AGED_BRIE, 2, 0), 
            new Item(ELIXIR, 5, 7), 
            new Item(SULFURAS, 0, 80),
            new Item(SULFURAS, -1, 80),
            new Item(BACKSTAGE_PASSES, 15, 20),
            new Item(BACKSTAGE_PASSES, 10, 49),
            new Item(BACKSTAGE_PASSES, 5, 49),
            new Item(CONJURED, 3, 6) };

    public void run(String[] args) throws ProductListException {
        GildedRose app = new GildedRose(items);

        int days = 10;
        if (args != null && args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            print("-------- day " + i + " --------");
            print("name, sellIn, quality");
            for (Item item : items) {
                print(item.toString());
            }
            print("");
            app.updateQuality();
        }
    }

    private void print(String message) {
        logger.info(message);
    }

    private static void notificarExcepcion(Exception e) {
        logger.severe(e.getMessage());
    }
}
