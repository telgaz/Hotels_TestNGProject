package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.page.HomePage;
import com.qa.hotels.page.ThreeStarPage;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;


public class ThreeStarPageTest {

	WebDriver driver;
	ElementUtil elementUtil;
	Properties prop;

	HomePage homePage;
	ThreeStarPage threeStarPage;
	BasePage basePage;
	
	@BeforeTest
	public void setUp() throws InterruptedException {

		basePage =new BasePage();
		prop=basePage.init_properties();
		String browserName=prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage=new HomePage(driver);
		threeStarPage=homePage.fillTheForm();
	}
	@Test(priority=1)
	public void getTitleTest() {
		threeStarPage.getTitle();
	}
	
	@Test(priority=2)
	public void selectDestinationTest() {
		threeStarPage.selectDestination();
	}
	
	@Test(priority=3)
	public void select3StarTest() throws InterruptedException {
		threeStarPage.select3StarHilton();
	}
	@Test(priority=4,enabled=true)
	public void hotelWithinTenMilesTest() {
		threeStarPage.hotelsWithinTenMiles();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
