package com.gildedrose;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculadora {
	public double suma(double a, double b) {
		BigDecimal rslt = BigDecimal.valueOf(a + b);
		return rslt.setScale(15, RoundingMode.HALF_DOWN).doubleValue();
	}
}
