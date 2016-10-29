package pages;

import org.openqa.selenium.WebElement;

public class ValTechCasesPage extends ValTechHomePage {
	
	public String getH1Tag() {
		WebElement h1Tag = driver.findElementByTagName("h1");
		return h1Tag.getText();
	}

}
