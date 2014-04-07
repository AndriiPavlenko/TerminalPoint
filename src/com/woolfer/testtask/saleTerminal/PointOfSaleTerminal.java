package com.woolfer.testtask.saleTerminal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.woolfer.testtask.base.Product;
import com.woolfer.testtask.base.SaleTerminal;
import com.woolfer.testtask.properties.ProductProperties;

public class PointOfSaleTerminal implements SaleTerminal {
	private Map<String, Product> mapOfProductsList;
	private static List<String> scanProducts;
	private static Map<String, Integer> mapOfQuantityProducts;

	public PointOfSaleTerminal() {
		scanProducts = new ArrayList<String>();
	}

	@Override
	// Get products properties from XML file
	public void setPricing() {
		mapOfProductsList = ProductProperties.getListOfProducts();
	}

	@Override
	public boolean scan(String c) {
		if (mapOfProductsList.containsKey(c))
			return scanProducts.add(c);
		return false;
	}

	@Override
	public BigDecimal calculateTotal() {
		PointOfSaleTerminal.quantityOfProducts();
		Double res = new Double(0);

		Set<Map.Entry<String, Integer>> set = mapOfQuantityProducts.entrySet();

		for (Map.Entry<String, Integer> entry : set) {
			String codeOfProduct = entry.getKey();
			Integer quantityOfProduct = entry.getValue();

			if (mapOfProductsList.containsKey(codeOfProduct)) {
				Product product = mapOfProductsList.get(codeOfProduct);
				Double price = product.getPrice();
				Integer nwp = product.getNumberOfWholesaleProducts();
				Double wholesalePrice = product.getWholesalePrise();
				if (nwp >= 1) {
					res += (quantityOfProduct / nwp) * wholesalePrice + (quantityOfProduct % nwp) * price;
				} else {
					res += quantityOfProduct * price;
				}
			}
		}
		return (BigDecimal.valueOf(res).setScale(2, BigDecimal.ROUND_UP));
	}

	// calculate the quantity of the similar products after scan
	private static void quantityOfProducts() {
		mapOfQuantityProducts = new HashMap<String, Integer>();
		for (String entry : scanProducts) {
			if (mapOfQuantityProducts.containsKey(entry)) {
				mapOfQuantityProducts.put(entry, (mapOfQuantityProducts.get(entry) + 1));
			} else {
				mapOfQuantityProducts.put(entry, 1);
			}
		}
	}

	// return the scanned products as string
	public String stringOfScanProduct() {

		StringBuilder products = new StringBuilder();
		for (String s : scanProducts) {
			products.append(s);
		}
		return products.toString();
	}
}
