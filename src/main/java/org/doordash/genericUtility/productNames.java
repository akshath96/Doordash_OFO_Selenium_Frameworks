package org.doordash.genericUtility;

public enum productNames {
	YORKSHIRELAMBPATTIES("Yorkshire Lamb Patties"), LOBSTERTHERMIDOR("Lobster Thermidor"), CHICKENMADEIRA("Chicken Madeira"),STUFFEDJACKETPOTATOES("Stuffed Jacket Potatoes"),PINKSPAGHETTIGAMBERONI("Pink Spaghetti Gamberoni"),CHEESYMASHEDPOTATO("Cheesy Mashed Potato");
	
	
	private String productName;
	private productNames(String productName) {
		this.productName=productName;
	}
	public String getproductName() {
		return productName;
	}
}
