package org.TourismManagement.POMRepository;

import org.TourishManagement.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageIssuePage {
	
		private String dynamicXpath="//td[.='%s']";
		@FindBy(xpath="//table/tbody/tr[last()]/td[6]/span")
		private WebElement allIssueData;
		@FindBy(xpath = "//span[.='Manage Issues']") 
		private WebElement manageIssueButton; 

		
	public ManageIssuePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		}
	
	public void manageIssueClick() {
		manageIssueButton.click();
	}

	public void ManageIssueAction(WebDriverUtility wdu,WebDriver driver) {
		wdu.initializeJSE(driver);
		wdu.scrollUsingJSE(allIssueData);
		
		//allIssueData.click();
		}

	public String getTextFromTheLastRow(WebDriver driver,String data) {
		String reqXpath = String.format(dynamicXpath, data);
		String text = driver.findElement(By.xpath(reqXpath)).getText();
		return text;
	}
	

}
