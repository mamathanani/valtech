package pages;

import org.openqa.selenium.WebElement;

public class ValTechJobsPage extends ValTechHomePage {

	 String h1tag = "header h1";
	 
	public String getH1Tag() {
		WebElement h1Tag = driver.findElementByTagName("h1");
		return h1Tag.getText();
	}
}
