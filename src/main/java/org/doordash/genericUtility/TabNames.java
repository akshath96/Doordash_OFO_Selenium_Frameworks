package org.doordash.genericUtility;

public enum TabNames {
	HOME("Home ") ,RESTAURANTS("Restaurants "),LOGIN("Login"),REGISTER("Register"),MYORDERS("My Orders"),LOGOUT("Logout");
	
	private String TabName;
	private TabNames(String TabName) {
		this.TabName=TabName;
	}
	public String getTabName() {
		return TabName;
}
	
	}
