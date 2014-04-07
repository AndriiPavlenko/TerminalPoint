package com.woolfer.testtask.base;

public class Product {
	private String code;
	private Double price;
	private Integer numberOfWholesaleProducts;
	private Double wholesalePrise;

	public Product() {
		this.code = null;
		this.price = null;
		this.numberOfWholesaleProducts = null;
		this.wholesalePrise = null;
	}
	
	public Product(String code) {
		this.code = code;
		this.price = new Double("0");
		this.numberOfWholesaleProducts = 0;
		this.wholesalePrise = new Double("0");
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setNumberOfWholesaleProducts(Integer numberOfWholesaleProducts) {
		this.numberOfWholesaleProducts = numberOfWholesaleProducts;
	}

	public void setWholesalePrise(Double wholesalePrise) {
		this.wholesalePrise = wholesalePrise;
	}

	public String getCode() {
		return code;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getNumberOfWholesaleProducts() {
		return numberOfWholesaleProducts;
	}

	public Double getWholesalePrise() {
		return wholesalePrise;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", price=" + price + ", numberOfWholesaleProducts=" + numberOfWholesaleProducts + ", wholesalePrise=" + wholesalePrise + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((numberOfWholesaleProducts == null) ? 0 : numberOfWholesaleProducts.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((wholesalePrise == null) ? 0 : wholesalePrise.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (numberOfWholesaleProducts == null) {
			if (other.numberOfWholesaleProducts != null)
				return false;
		} else if (!numberOfWholesaleProducts.equals(other.numberOfWholesaleProducts))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (wholesalePrise == null) {
			if (other.wholesalePrise != null)
				return false;
		} else if (!wholesalePrise.equals(other.wholesalePrise))
			return false;
		return true;
	}

}
