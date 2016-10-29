package pages;

import java.util.ArrayList;

import org.openqa.jetty.html.List;
import org.openqa.selenium.WebElement;

import core.Driver;

public class ValTechHomePage extends Driver {
	
	protected String homepageUrl = "https://www.valtech.com/";
	protected String title = "Where Experiences are Engineered - Valtech";
	public String latestNews = "div.bloglisting.news-post__listing";
	public String burgerMenu = "[data-icon='hamburger2']";
	public String contacts = "[data-icon='earth-contact']";
	public String cities = "ul.contactcities li> a";
	
	
	protected ValTechCasesPage casesPage;
	protected ValTechJobsPage jobsPage;
	protected ValTechServicesPage servicesPage;
	
	
	public ValTechHomePage  getValTechHomePag() {
		driver.get(homepageUrl);
		waitForPageToLoad(driver);
		return new ValTechHomePage();
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public String getH1Text(){
		WebElement h1 = driver.findElementByTagName("h1");
		return h1.getText();
	}
	
	public boolean latestNewsSectionDisplayed(){
		WebElement latestNewsSection = driver.findElementByCssSelector(latestNews);
	    return latestNewsSection.isDisplayed();
	}
	
	public void clickBurgerMenu(){
		WebElement menu = driver.findElementByCssSelector(burgerMenu);
		menu.click();
		waitForPageToLoad(driver);
	}
	
	public int getOfficeLocationsList(){
		ArrayList<WebElement> offices = (ArrayList<WebElement>) driver.findElementsByCssSelector(cities);
		/*ArrayList<String> officeList = null;
		for (WebElement office: offices) {
		officeList.add(office.getText());
		}*/
		return offices.size();
	}
	
	public ValTechContactsPage clickContacts(){
		WebElement contactsSection = driver.findElementByCssSelector(contacts);
		contactsSection.click();
		waitForPageLoad(driver);
		getOfficeLocationsList();
		return new ValTechContactsPage();
	}
	
	public void goToPage(String pagename){
		driver.get(homepageUrl+pagename);
		waitForPageToLoad(driver);
	}

	public ValTechCasesPage navigateToValtechCasesPage(){
		clickBurgerMenu();
		waitForPageLoad(driver);
		goToPage("cases");
		waitForPageLoad(driver);
		return new ValTechCasesPage();
	}
	
	public ValTechJobsPage navigateToValtechJobsPage(){
		clickBurgerMenu();
		waitForPageLoad(driver);
		goToPage("jobs");
		waitForPageLoad(driver);
		return new ValTechJobsPage();
	}
	
	public ValTechServicesPage navigateToValtechServicesPage(){
		clickBurgerMenu();
		waitForPageLoad(driver);
		goToPage("services");
		waitForPageLoad(driver);
		return new ValTechServicesPage();
	}
	
	public ValTechContactsPage navigateToValtechContactsPage(){
		clickContacts();
		return new ValTechContactsPage();
	}
	


}
