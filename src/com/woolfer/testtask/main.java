package com.woolfer.testtask;

import com.woolfer.testtask.saleTerminal.PointOfSaleTerminal;

public class main {

	public static void main(String[] args) {
		PointOfSaleTerminal terminal = new PointOfSaleTerminal();
		terminal.setPricing();
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("A");
		System.out.println("Scan these items in this order: " + terminal.stringOfScanProduct() + "; Verify the total price is $" + terminal.calculateTotal());

		terminal = new PointOfSaleTerminal();
		terminal.setPricing();
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		terminal.scan("C");
		System.out.println("Scan these items in this order: " + terminal.stringOfScanProduct() + "; Verify the total price is $" + terminal.calculateTotal());

		terminal = new PointOfSaleTerminal();
		terminal.setPricing();
		terminal.scan("A");
		terminal.scan("B");
		terminal.scan("C");
		terminal.scan("D");
		System.out.println("Scan these items in this order: " + terminal.stringOfScanProduct() + "; Verify the total price is $" + terminal.calculateTotal());

	}
}
