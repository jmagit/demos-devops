package com.gildedrose;

public class GildedRoseException extends Exception {
	private static final long serialVersionUID = 1L;

	public GildedRoseException() {
	}

	public GildedRoseException(String messaje) {
		super(messaje);
	}

	public GildedRoseException(Throwable origin) {
		super(origin);
	}

	public GildedRoseException(String messaje, Throwable origin) {
		super(messaje, origin);
	}

	public GildedRoseException(String messaje, Throwable origin, boolean arg2, boolean arg3) {
		super(messaje, origin, arg2, arg3);
	}

}
