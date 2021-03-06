package com.thoughtworks.selenium.verifysetup;

import static org.junit.Assert.*;
import org.junit.*;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.FlashSelenium;
import com.thoughtworks.selenium.Selenium;


/**
 * This test only run properly if:
 * selenium-server is running
 * selenium-java-client-driver.jar and junit.jar have been added to the project or classpath
 * flashselenium.jar has been added to the project or classpath
 */
public class FlashSeleniumTest {
	private final static String URL = "http://www.geocities.com/paulocaroli/flash/sum.html";
	private Selenium selenium;
	private FlashSelenium flashApp;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*iexplore",URL);
		selenium.start();
		flashApp = new FlashSelenium(selenium, "compareSumFlexObjId");		
		selenium.open(URL);
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}

	@Test
	public void verifyFlashMovieIsLoaded() {
		assertEquals(100, flashApp.PercentLoaded());
	}

}
