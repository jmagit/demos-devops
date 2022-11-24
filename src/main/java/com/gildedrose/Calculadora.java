package com.gildedrose;

public class Calculadora {
	public double suma(double a, double b) {
//		return a + b;
		return (new java.math.BigDecimal(a + b)).setScale(15, java.math.RoundingMode.HALF_DOWN).doubleValue();
	}
	
	public void kk(double a, double b) {
		if(a<b || b> a) {
			a = b;
			b = b;
		}
		double c = a * b;
		a -= c;
	}
}
