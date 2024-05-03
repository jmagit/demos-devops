package com.gildedrose;

import java.util.Objects;

public class Item {
	public String name;

	public int sellIn;

	public int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.sellIn = sellIn;
//		try {
			setQuality(quality);
//		} catch (Exception e) {
//			// e.printStackTrace();
//		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSellIn() {
		return sellIn;
	}

	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) throws IllegalArgumentException {
		if (quality < 0)
			throw new IllegalArgumentException("La cantidad no puede ser negativa.");
		this.quality = quality;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.sellIn + ", " + this.quality;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, quality, sellIn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(name, other.name) && quality == other.quality && sellIn == other.sellIn;
	}

}
