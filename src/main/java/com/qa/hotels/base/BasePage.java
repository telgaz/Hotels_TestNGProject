package com.qa.hotels.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
//
//	WebDriver driver;
//	Properties prop;
//	
//	public WebDriver init_driver(String browserName) {
//		
//		System.out.println("Browser name is "+ browserName);
//		if(browserName.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		else if(browserName.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		else if(browserName.equalsIgnoreCase("safari")) {
//			WebDriverManager.getInstance(SafariDriver.class).setup();
//			driver = new SafariDriver();
//		}
//		else {
//			System.out.println("Browser name "+ browserName + " is not found");
//		}
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//	
//		return driver;
//	}
//	public Properties init_properties() {
//		
//		prop = new Properties();
//		String path="/Users/tugbaelgaz/eclipse-workspace/Hotels_Project/src/main/java/com/qa/hotels/config/config.properties";
//		try {
//			FileInputStream ip = new FileInputStream(path);
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			System.out.println("some issue happened with config properties... Correct the file");
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return prop;
//	}
//	
	
	WebDriver driver;
	Properties prop;
	public static boolean highlightElement;
	public OptionsManager optionsManager;
	
	public WebDriver init_driver(String browserName){
		
		highlightElement = prop.getProperty("highlight").equals("yes") ? true : false;
		
		System.out.println("Browser name is " +browserName);
		
	    optionsManager = new OptionsManager(prop);// this part
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
		
	    driver = new ChromeDriver(optionsManager.getChromeOptions()); 
		
			
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
	
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
				
			
			
		}
		else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver =new SafariDriver();
		}
		else{System.out.println("Browser name "+browserName+"is not found");
	}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
	    return driver;
	}
	
	public Properties init_properties(){
		
	prop =new Properties();
	String path = null;
	String env = null;
	
      try {
	env = System.getProperty("env");
	if (env.equals("qa")) {
		path ="./src/main/java/com/qa/hotels/config/config.qa.properties";
	}else if (env.equals("stg")) {
		path ="./src/main/java/com/qa/hotels/config/com.qa.stg.properties";
	}
      } catch (Exception e) {
	path ="./src/main/java/com/qa/hotels/config/config.properties";
       
      }
      
	   try {
		FileInputStream ip = new FileInputStream(path);
		prop.load(ip);
	 } catch (FileNotFoundException e) {
		System.out.println("some issue happened with config properties... Correct the File ");

	 }catch(IOException e){
		e.printStackTrace();
		
	}
	   return prop;
	
	}
	
	
	
	
	
}
