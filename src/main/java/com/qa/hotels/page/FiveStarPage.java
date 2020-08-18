package com.qa.hotels.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

public class FiveStarPage {

	WebDriver driver;
	ElementUtil elementUtil;
	HomePage homePage;
	ThreeStarPage threeStarPage;
	 
	By starCheckBox=By.id("f-star-rating-5");
	By hotelMiles=By.xpath("//ul[@class='property-landmarks']//li[contains(text(),'miles to City center')]");
	By hotels=By.xpath("//a[@class='property-name-link']");
	By expectedText=By.xpath("//div[@class='info unavailable-info']");
	
	public FiveStarPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		homePage=new HomePage(driver);	
		threeStarPage=new ThreeStarPage(driver);
	}
	
	public void select5StarHotelsWithin10Miles() throws InterruptedException {
		
		elementUtil.doClick(starCheckBox);
		
		Thread.sleep(3000);
		List<WebElement> hotelNames = driver.findElements(hotels);
		//		(By.xpath("//*[@class='hotel-wrap']//h3"));
		List<WebElement> miles = driver.findElements(hotelMiles);
		for (int i = 0; i < hotelNames.size(); i++) {
			JavaScriptUtil.scrollDownPage(700, driver);
	
		String text1 = miles.get(i).getText();
		String hotelMilesr=text1.replaceAll("[a-zA-a ]", " ");
		double radius = Double.parseDouble(hotelMilesr);
		
		if (radius<10) {
			System.out.println("5 star hotel is " +hotelNames.get(i).getText() + " " + radius);
		}
	}	
}		
}            	
	

