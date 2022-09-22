package org.TourismManagement.POMRepository;

import org.TourishManagement.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IssueTicketsPage {

	private WebDriver driver;
	//Declaration
	@FindBy(xpath = "(//table/descendant::td/ancestor::tr)[last()]") private WebElement lastEntry;
	
	private String dynamicXpath="//td[.='%s']";
	@FindBy(xpath="(//th[.='Description']/ancestor::table/descendant::td[.='refund_not_available']/parent::tr)[last()]")
	private WebElement alldataSelect;
	
	//Initialization
	
	public IssueTicketsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Business Library
	public void scrolllastUpdatedemark(WebDriverUtility wdu)
	{
		wdu.scrollUsingJSE(lastEntry);
	}
	
	public void scrollTillalldataSelect(WebDriverUtility wdu,WebDriver driver){
		wdu.initializeJSE(driver);
		wdu.scrollUsingJSE(alldataSelect);
	}
	
	public String getTextFromTheLastRow(WebDriver driver,String data)
	{
		String reqXpath = String.format(dynamicXpath, data);
		String text = driver.findElement(By.xpath(reqXpath)).getText();
		return text;
	}
	
	
	
}
