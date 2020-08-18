package com.qa.hotels.tests;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;

import com.qa.hotels.page.HomePage;

public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	
	@BeforeTest
	public void setUp() {
		
		basePage =new BasePage();
		prop=basePage.init_properties();	
		String browserName=prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage=new HomePage(driver);		
	}
	@Test(priority=2)
	public void fillTheFormTest() throws InterruptedException {
		homePage.fillTheForm();
	}
	@Test(priority=1)
	public void verifyTitleTest() {
		String title=homePage.getPageTitle();
		
		Assert.assertEquals(title,"Hotels.com - Deals & Discounts for"
				+ " Hotel Reservations from Luxury Hotels to Budget Accommodations");
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}
	
}
