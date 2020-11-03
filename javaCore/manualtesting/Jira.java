package manualtesting;

import automationtesting.Selenium;

public class Jira extends Selenium {

	public String getParentSponsor() {
		return sponser;
	}

	public void setParentSponsor(String sponsorName) {
		sponser = sponsorName;
		
		getSponsor();
		
		version = "6.20.19";
		
		getVersion();
	}

	public static void main(String[] args) {
		

	}

}
