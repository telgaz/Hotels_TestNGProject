package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.page.FiveStarPage;
import com.qa.hotels.page.FourStarPage;
import com.qa.hotels.page.HomePage;
import com.qa.hotels.page.ThreeStarPage;
import com.qa.hotels.util.ElementUtil;

public class FiveStarPageTest {

	
	WebDriver driver;
	ElementUtil elementUtil;
	Properties prop;
	BasePage basePage;
	
	HomePage homePage;
	ThreeStarPage threeStarPage;
	FourStarPage fourStarPage;
	FiveStarPage fiveStarPage;
	
	@BeforeTest
	public void setUp() throws InterruptedException {

		basePage =new BasePage();
		prop=basePage.init_properties();
		String browserName=prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		
		homePage=new HomePage(driver);
		threeStarPage=homePage.fillTheForm();
		fourStarPage=new FourStarPage(driver);
		fourStarPage=threeStarPage.selectDestination();
		fiveStarPage=new FiveStarPage(driver);
		fiveStarPage=fourStarPage.moveToNextPage();
	}
	
	@Test()
	public void FiveStarHotelsTest() throws InterruptedException {
		
		fiveStarPage.select5StarHotelsWithin10Miles();
	}
	
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}
}
