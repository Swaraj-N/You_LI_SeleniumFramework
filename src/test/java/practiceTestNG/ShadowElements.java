package practiceTestNG;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowElements {
	WebDriver driver=null;
	@Test
	public void ShadowElement() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://watir.com/examples/shadow_dom.html");
		
	JavascriptExecutor jse=(JavascriptExecutor)driver;
WebElement ele = (WebElement)jse.executeScript("return document.querySelector(\"body > a\")");
ele.click();
	

	}
}
