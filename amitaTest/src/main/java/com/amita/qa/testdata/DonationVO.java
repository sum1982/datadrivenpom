package com.amita.qa.testdata;

public class DonationVO {

	private String donation;

	@Override
	public String toString() {
		return "DonationVO{" + "donation=" + donation + '}';
	}

	public DonationVO(String donation) {
		this.donation = donation;
	}

	public String getDonation() {
		return donation;
	}

	public void setDonation(String donation) {
		this.donation = donation;
	}

}
