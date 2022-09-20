package org.doordash.genericUtility;

public enum restoNames{
 AMERICAN("American"),CHINESE(" Chinese"),ITALIAN(" Italian"),;
	
	
	private String restoname;
	private restoNames(String restoname) {
		this.restoname=restoname;
	}
	public String getrestoName() {
		return restoname;
	}
}

