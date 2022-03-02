package com.gildedrose;

public class ProductListException extends GildedRoseException {

	public ProductListException() {
	}

	public ProductListException(String messaje) {
		super(messaje);
	}

	public ProductListException(Throwable origin) {
		super(origin);
	}

	public ProductListException(String messaje, Throwable origin) {
		super(messaje, origin);
	}

	public ProductListException(String messaje, Throwable origin, boolean arg2, boolean arg3) {
		super(messaje, origin, arg2, arg3);
	}

}
