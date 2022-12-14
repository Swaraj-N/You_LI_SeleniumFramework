package org.TourismManagement.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminRemarkUpdateWindowPage {
	
	//Declaration
	@FindBy(name = "remark") private WebElement remarkTextAreaField;
	@FindBy(name = "submit2") private WebElement submitutton;
	
	//Initialization
	public AdminRemarkUpdateWindowPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business Library
	public String updateRemark(String remark,int randomNumber)
	{
		remarkTextAreaField.sendKeys(remark+randomNumber);
		submitutton.click();
		return remark+randomNumber;
	}
}
