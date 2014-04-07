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
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");
		terminal.scan("D");
		terminal.scan("B");
		terminal.scan("A");
		assertEquals("ABCDDBA", terminal.stringOfScanProduct());
	}

	@Test
	public void testCalculateTotal_1() {
		
		terminal = new PointOfSaleTerminal();
		terminal.setPricing();
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("A");
		assertEquals(BigDecimal.valueOf(13.25), terminal.calculateTotal());
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
		assertEquals(BigDecimal.valueOf(6).setScale(2, BigDecimal.ROUND_UP), terminal.calculateTotal());
	}
	
	@Test
	public void testCalculateTotal_3() {
		
		terminal = new PointOfSaleTerminal();
		terminal.setPricing();
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");
		assertEquals(BigDecimal.valueOf(7.25), terminal.calculateTotal());
	}
	

}
