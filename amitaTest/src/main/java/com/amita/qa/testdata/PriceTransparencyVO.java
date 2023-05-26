package com.amita.qa.testdata;

public class PriceTransparencyVO {

	private String zip;

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public PriceTransparencyVO(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "PriceTransparencyVO{" + "zip=" + zip + '}';
	}
}
