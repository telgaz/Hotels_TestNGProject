package com.qa.hotels.util;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hotels.base.BasePage;


public class ElementUtil extends BasePage{

WebDriver driver;
	
	public ElementUtil(WebDriver driver){
		this.driver = driver;
	}

	public void mouseOver(By locator) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(locator);
		action.moveToElement(element).build().perform();	
	}

	public WebElement getElement(By locator) {	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		return element; 
	}
	
	public void waitForElement(By locator){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void clickOn(By locator) {
		driver.findElement(locator).click();
	}
	
	public void sendKeys(By locator, String key) {
		driver.findElement(locator).sendKeys(key);	
	}
	public void doSendKeys(By locator, String value) {
	     
	    try {
	      WebElement element = getElement(locator);
	      element.clear();
	      element.sendKeys(value);
	    } catch (Exception e) {
	      System.out.println("some exception got occured while entering values in a field");
	    }
	  }
	
	public String  verifyGetText(By locator, String verifyText ) {
		String text = driver.findElement(locator).getText();
		if (text.equals(verifyText)) {
			System.out.println("Text is correct.");
		} else {
			System.out.println("Text is not correct.");
		}
		return text;
	}
	public String doGetPageTitle() {
		
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting the title...");
		}
		return null;
	}	
	
	public void doClick(By locator) {
		
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occured while clicking the web element");
		}
	}
	public void mouseOverClick(By locator, WebElement elementClicked) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement mouseOverAction = driver.findElement(locator);
		action.moveToElement(mouseOverAction).click(elementClicked).build().perform();	
	}
	public String doGetText(By locator) {
		
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting text...");
		}
		return null;
	}
	
    public  void selectDropdownByVisibleText(WebDriver driver,By locator,String value) {
		
		WebElement element=driver.findElement(locator);
		Select select=new Select(element);
		select.selectByVisibleText(value);
		
	}
}