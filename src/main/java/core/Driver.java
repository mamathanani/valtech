package core;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.base.Predicate;

public class Driver {
	
	protected FirefoxDriver driver;
	
	public void waitForPageLoad(WebDriver driver){
		new WebDriverWait(driver, 60);
	}
	
	public void waitForPageToLoad(WebDriver driver) {
		new WebDriverWait(driver, 60).until(new Predicate<WebDriver>() 
	    { public boolean apply(WebDriver driver) { return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"); } } );
	}
	
	
	@BeforeMethod
	public void start(){
		//Initialise Broswer - Firefox
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void quit(){
		driver.quit();
	}

}
