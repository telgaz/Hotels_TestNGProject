package com.qa.hotels.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;


public class ThreeStarPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	HomePage homePage;
	ThreeStarPage threeStarPage;

	By checkBox3Star=By.id("f-star-rating-3");
//	By checkBox3Star=By.xpath("//input[@id='f-star-rating-3']");
//	By checkBox3Star=By.cssSelector("#f-star-rating-3");
	By cityCenter=By.xpath("//a[contains(text(),'City center')]");
	By destinationMenu=By.xpath("//a[@data-menu='sort-submenu-distance']");
	By hotels=By.xpath("//a[@class='property-name-link']");
	By hiltons=By.xpath("//a[contains(text(),'Hilton')]");
	
	By miles=By.xpath("//ul[@class='property-landmarks']//li[contains(text(),'miles to City center')]");
	
	public ThreeStarPage(WebDriver driver) {
	 this.driver=driver;
	 elementUtil=new ElementUtil(driver);
	 homePage=new HomePage(driver);	
		
	}
	public void getTitle() {
		elementUtil.doGetPageTitle();
		System.out.println(elementUtil.doGetPageTitle());
	}

	public FourStarPage selectDestination() {
		WebElement cityCenterElement=driver.findElement(cityCenter);
		elementUtil.mouseOverClick(destinationMenu, cityCenterElement);
		return new FourStarPage(driver);
		}
	
	
	public void select3StarHilton() throws InterruptedException {
		
		Thread.sleep(4000);
     	elementUtil.doClick(checkBox3Star);
     	Thread.sleep(3000);
    //    JavaScriptUtil.scrollDownPage(700, driver);
	
		List<WebElement> hotelsList = driver.findElements(hotels);
		for (WebElement hotels : hotelsList) {
			
			JavaScriptUtil.scrollDownPage(500, driver);
		  
			System.out.println(hotels.getText());
		} 
	              
	
        List<WebElement> hiltonList=driver.findElements(hiltons);
        for (int i = 0; i < hiltonList.size(); i++) {
        	
        	JavaScriptUtil.scrollDownPage(700, driver);
        	
        	String threeStarHilton=(hiltonList).get(i).getText();
        	System.out.println("The Hilton hotel is  "+ threeStarHilton + "  among 3 star Hotels");
	
		}
	}
        
	public void hotelsWithinTenMiles() {
		
		System.out.println("\n"+"****************"+"\n");
		
		List<WebElement> hotelsList = driver.findElements(hotels);
	       List<WebElement> withinTenMiles=driver.findElements(miles);
               for(int i=0;i<hotelsList.size();i++) {
        	
        	JavaScriptUtil.scrollDownPage(700, driver);
	
			String text=withinTenMiles.get(i).getText();
			String newText=text.replaceAll("[a-zA-Z ]", " ");
			Double radius=Double.parseDouble(newText);
			if(radius<10) {
				System.out.println(hotelsList.get(i).getText() + "  " + radius);
		
			}
		
        
   	
	}
	
		
	
	
	}	
	
}	
	
		
	
	
