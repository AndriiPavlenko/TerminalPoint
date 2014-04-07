package com.woolfer.testtask.base;

import java.math.BigDecimal;

public interface SaleTerminal {

	public void setPricing();

	public boolean scan(String c);

	public BigDecimal calculateTotal();

}
