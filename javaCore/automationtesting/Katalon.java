package automationtesting;

public class Katalon {

	public static void main(String[] args) {
		Selenium selenium = new Selenium();
		
		//default
		System.out.println(selenium.organization);
		System.out.println(selenium.getOrganization());
		
		//protected
		System.out.println(selenium.sponser);
		System.out.println(selenium.getSponsor());
		
		//public
		selenium.version="5.10";
		System.out.println(selenium.version);
		
	

	}

}
