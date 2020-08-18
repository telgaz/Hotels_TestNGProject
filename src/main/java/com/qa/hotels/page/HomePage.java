package com.qa.hotels.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;

public class HomePage extends BasePage {
 
	     WebDriver driver;
         ElementUtil elementUtil;

     	
         By destination = By.xpath("//input[@id='qf-0q-destination']");
         
         By checkIn = By.id("qf-0q-localised-check-in");
         
         By checkOut = By.id("qf-0q-localised-check-out");
   
        
         By adults = By.cssSelector("#qf-0q-room-0-adults");
         By children = By.cssSelector("#qf-0q-room-0-children");
         By search = By.className("cta-strong");
         By child1 = By.xpath("//*[@id='qf-0q-room-0-child-0-age']");
         By child2 =By.xpath("//*[@id='qf-0q-room-0-child-1-age']");
  

  
  public HomePage(WebDriver driver) {
		
		   this.driver=driver;
		   elementUtil=new ElementUtil(driver);
		
	}
      public ThreeStarPage fillTheForm() throws InterruptedException {  
     
    	  elementUtil.doClick(destination);
          WebElement whereToGo=driver.findElement(By.xpath("//table[@class='autosuggest-with-recommended-destinations']/tbody/tr[3]"));
          whereToGo.click();
 
          elementUtil.doSendKeys(checkIn, "08/03/20");
          elementUtil.doSendKeys(checkOut, "08/07/20");
          
         
         elementUtil.selectDropdownByVisibleText(driver, adults, "2");
         elementUtil.selectDropdownByVisibleText(driver, children, "2");
   	     elementUtil.selectDropdownByVisibleText(driver, child1, "9");
    	 elementUtil.selectDropdownByVisibleText(driver, child2, "4");
    	 
   
    	  elementUtil.doClick(search);
    	  
    	  return new ThreeStarPage(driver);
      }
  
  public String getPageTitle() {
	 
	  String title=elementUtil.doGetPageTitle();
	  System.out.println(elementUtil.doGetPageTitle());
	  return title;
  
  
  }
  
  
	
}
