package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Tests {
	Logger log = LogManager.getLogger(Tests.class.getClass());
    
	@Test
	public void doLogin() {
		log.debug("Login failed ");
		System.out.println("Login failed");
	}

	@Test
	public void doRegistration() {
		log.debug("Registration done Successfully");
		System.out.println("Registration done Successfully");
	}

	@Test
	public void navigateToHomePage() {
		log.debug("NavigateToHomePage Skipped");
		System.out.println("NavigateToHomePage Skipped");

	}

}
