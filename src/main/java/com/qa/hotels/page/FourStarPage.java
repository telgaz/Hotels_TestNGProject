package com.qa.hotels.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

public class FourStarPage {

	WebDriver driver;
	ElementUtil elementUtil;
	HomePage homePage;
	ThreeStarPage threeStarPage;
	
	
	By fourStarCheckBox=By.id("f-star-rating-4");
	By hotels=By.xpath("//a[@class='property-name-link']");
	By hotelMiles=By.xpath("//ul[@class='property-landmarks']//li[contains(text(),'miles to City center')]");
	By expectedText=By.xpath("//div[@class='info unavailable-info']");
	
	public FourStarPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		homePage=new HomePage(driver);
		threeStarPage=new ThreeStarPage(driver);
	}

	
	public void selectHotelsWithin10Miles() throws InterruptedException {
		
		elementUtil.doClick(fourStarCheckBox);
	
	
	
		Thread.sleep(3000);
	
		List<WebElement> hotelNames = driver.findElements(hotels);
		  List<WebElement> miles = driver.findElements(hotelMiles);
		
		     for (int i = 0; i < hotelNames.size(); i++) {
			
		JavaScriptUtil.scrollDownPage(1000, driver);
		
		
		String text = miles.get(i).getText();
		
		String hotelMiles=text.replaceAll("[a-zA-Z ]", " ");
		
		double radius = Double.parseDouble(hotelMiles);
		
		if (radius<10) {
			System.out.println(hotelNames.get(i).getText() + "  " + radius);
		     }
		
		  }
      }	
	
	public FiveStarPage moveToNextPage() {
		return new FiveStarPage(driver);
	}
	
	
	
	
	
}
