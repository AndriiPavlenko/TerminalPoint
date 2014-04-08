package com.woolfer.testtask.testCase;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.woolfer.testtask.saleTerminal.PointOfSaleTerminal;

public class testPointOfSaleTerminal {
	
	private PointOfSaleTerminal terminal;
	
	@Test
	public void testStringOfScanProduct() {
		
		terminal = new PointOfSaleTerminal();
		terminal.setPricing();
		terminal.scan("B");
		terminal.scan("B");
		terminal.scan("B");
		terminal.scan("D");
		terminal.scan("D");
		terminal.scan("B");
		terminal.scan("A");
		assertEquals("BBBDDBA", terminal.stringOfScanProduct());
	}

	@Test
	public void testCalculateTotal_1() {
		
		terminal = new PointOfSaleTerminal();
		terminal.setPricing();
		terminal.scan("C");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("A");
		assertEquals(BigDecimal.valueOf(20.72), terminal.calculateTotal());
	}
	
	@Test
	public void testCalculateTotal_2() {
		
		terminal = new PointOfSaleTerminal();
		terminal.setPricing();
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		assertEquals(BigDecimal.valueOf(24).setScale(2, BigDecimal.ROUND_UP), terminal.calculateTotal());
	}
	
	@Test
	public void testCalculateTotal_3() {
		
		terminal = new PointOfSaleTerminal();
		terminal.setPricing();
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");
		assertEquals(BigDecimal.valueOf(11.42), terminal.calculateTotal());
	}
	

}
