package com.amita.qa.testdata;

public class LocationVO {
	private String citystatezip;

	@Override
	public String toString() {
		return "LocationVO [citystatezip=" + citystatezip + "]";
	}

	public LocationVO(String citystatezip) {
		super();
		this.citystatezip = citystatezip;
	}

	public String getCitystatezip() {
		return citystatezip;
	}

	public void setCitystatezip(String citystatezip) {
		this.citystatezip = citystatezip;
	}

}
