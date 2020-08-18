package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.page.FourStarPage;
import com.qa.hotels.page.HomePage;
import com.qa.hotels.page.ThreeStarPage;
import com.qa.hotels.util.ElementUtil;

public class FourStarPageTest {


	WebDriver driver;
	ElementUtil elementUtil;
	Properties prop;
	BasePage basePage;
	
	HomePage homePage;
	ThreeStarPage threeStarPage;
	FourStarPage fourStarPage;
	
	@BeforeTest
	public void setUp() throws InterruptedException {

		basePage =new BasePage();
		prop=basePage.init_properties();
		String browserName=prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		
		homePage=new HomePage(driver);
		threeStarPage=homePage.fillTheForm();
		fourStarPage=threeStarPage.selectDestination();
		fourStarPage=new FourStarPage(driver);
		
	
	}
	@Test()
	public void HotelsWithin10MilesTest() throws InterruptedException {
		fourStarPage.selectHotelsWithin10Miles();
	}
	
	@AfterTest()
	public void tearDown() {
	 driver.quit();	
		
	}
}
