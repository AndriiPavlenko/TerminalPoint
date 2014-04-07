/*
 * XML parser
 */

package com.woolfer.testtask.properties;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.woolfer.testtask.base.Product;

public class ProductProperties {

	private static Map<String, Product> listOfProducts;
	private static Product product;

	static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	static DocumentBuilder builder;

	/*
	 * Method "getProductProperties(String productCode)" return the "Product"
	 * Object from XML properties file use the product code
	 * 
	 * 
	 * // public static Product getProductProperties(String productCode) { // //
	 * DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //
	 * DocumentBuilder builder; // try { // builder =
	 * factory.newDocumentBuilder(); // // File propertiesFile = new //
	 * File("src/com/woolfer/testtask/properties/PriceOfProducts.xml"); //
	 * product = new Product(); // // try { // Document doc =
	 * builder.parse(propertiesFile); // Element root =
	 * doc.getDocumentElement(); // // NodeList listOfProducts =
	 * root.getChildNodes(); // for (int i = 0; i < listOfProducts.getLength();
	 * i++) { // Node elementListOfProducts = listOfProducts.item(i); // // if
	 * (elementListOfProducts instanceof Element) { // // Element element =
	 * (Element) elementListOfProducts; // if
	 * (element.getTagName().equals(productCode)) { //
	 * product.setCode(productCode); //
	 * product.setPrice(Double.parseDouble(element
	 * .getAttribute(NameOfProductProperties.Price.toString()))); //
	 * product.setNumberOfWholesaleProducts
	 * (Integer.parseInt(element.getAttribute
	 * (NameOfProductProperties.NumberOfWholesaleProducts.toString()))); //
	 * product.setWholesalePrise(Double.parseDouble(element.getAttribute(
	 * NameOfProductProperties.WholesalePrise.toString()))); // } // } // } //
	 * // } catch (SAXException e) { // e.printStackTrace(); // } catch
	 * (IOException e) { // e.printStackTrace(); // } // } catch
	 * (ParserConfigurationException e1) { // e1.printStackTrace(); // } // //
	 * return product; // } / /* Method "getListOfProducts()" return the list of
	 * products from XML properties file
	 */

	public static Map<String, Product> getListOfProducts() {

		try {
			builder = factory.newDocumentBuilder();

			File propertiesFile = new File("src/com/woolfer/testtask/properties/PriceOfProducts.xml");

			try {
				Document doc = builder.parse(propertiesFile);
				Element root = doc.getDocumentElement();
				NodeList itemOfProducts = root.getChildNodes();

				listOfProducts = new HashMap<String, Product>();
				for (int i = 0; i < itemOfProducts.getLength(); i++) {
					Node elementListOfProducts = itemOfProducts.item(i);

					if (elementListOfProducts instanceof Element) {
						Element element = (Element) elementListOfProducts;
						String code = element.getTagName();
						String price = NameOfProductProperties.PRICE.toString().toLowerCase();
						String nwp = NameOfProductProperties.NUMBEROFWHOLESALEPRODUCTS.toString().toLowerCase();
						String wholesalePrice = NameOfProductProperties.WHOLESALEPRICE.toString().toLowerCase();
						product = new Product(code);
						if (element.hasAttribute(price))
							product.setPrice(Double.parseDouble(element.getAttribute(price)));
						if (element.hasAttribute(nwp))
							product.setNumberOfWholesaleProducts(Integer.parseInt(element.getAttribute(nwp)));
						if (element.hasAttribute(wholesalePrice))
							product.setWholesalePrise(Double.parseDouble(element.getAttribute(wholesalePrice)));
						listOfProducts.put(code, product);
					}
				}

			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		}
		return listOfProducts;
	}
}
