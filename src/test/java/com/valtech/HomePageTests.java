package com.valtech;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ValTechHomePage;

public class HomePageTests extends ValTechHomePage {
	
	@Test
	public void navigateToValtechHomePage(){
		getValTechHomePag();
		Assert.assertEquals(getTitle(), title);
		//Assert "Latest News" is displayed
		Assert.assertTrue(latestNewsSectionDisplayed());
	}
	
	@Test
	public void navigateToCasesTest(){
		getValTechHomePag();
		navigateToValtechCasesPage();
		//Assert "H1Tag" text
		Assert.assertEquals("Cases", getH1Text());
	}
		
	@Test
	public void navigateToJobsPageTest(){
		getValTechHomePag();
		navigateToValtechJobsPage();
		//Assert "H1Tag" text
		Assert.assertEquals("Jobs", getH1Text());
	}
	
	@Test
	public void navigateToServicesPageTest(){
		getValTechHomePag();
		navigateToValtechServicesPage();
		//Assert "H1Tag" text
		Assert.assertEquals("Services", getH1Text());
	}
	
	@Test
	public void navigateToContactsPageTest(){
		getValTechHomePag();
		clickContacts();
		int offices = getOfficeLocationsList();
		//Office list
		Assert.assertEquals(60,offices);
		
	}
	
}
