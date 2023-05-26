package com.amita.qa.testdata;

public class SpecialtyCareVO {
	private String search;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public SpecialtyCareVO(String search) {
		this.search = search;
	}

	@Override
	public String toString() {
		return "SpecialtyCareVO{" + "search=" + search + '}';
	}
}
