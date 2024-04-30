package com.gildedrose;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculadora {
	public double suma(double a, double b) {
		BigDecimal rslt = BigDecimal.valueOf(a + b);
		return rslt.setScale(15, RoundingMode.HALF_UP).doubleValue();
	}
	
	public double add(double a, double b) {
		return a + b;
	}
	
	public double div(double a, double b) {
		if(b == 0) throw new ArithmeticException("Divide by 0");
		return a / b;
	}
	
	public int div(int a, int b) {
		return a / b;
	}
}
