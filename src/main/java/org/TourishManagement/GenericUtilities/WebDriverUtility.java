package org.TourishManagement.GenericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all the WebDriver Operations
 * @author SWARAJ-PC
 *
 */
public class WebDriverUtility {
	private	Actions a;
	private	Select s;
	private	JavascriptExecutor jse;
	/**
	 * This method is used to launch the browser
	 * @param browser
	 * @return 
	 */
	public WebDriver launchTheBrowser(String browser)
	{
		WebDriver driver=null;
		switch (browser)
		{
		case "Firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		case "Chrome" :
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;

		case "ie" :
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		default :
			System.out.println("Please Enter Valid Browser Key");
			break;
		}
		return driver;

	}
	/**
	 * This method is used to Maximize the Browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to Specify Implicit Wait in Seconds
	 * By passing following arguments to the method
	 * @param driver
	 * @param timeInSeconds
	 */
	public void waitImplicityInSeconds(WebDriver driver,long timeInSeconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
	}
	/**
	 * This method is used to Navigate to the Application
	 * @param driver
	 * @param url
	 */
	public void openTheApplication(WebDriver driver,String url)
	{
		driver.get(url);
	}
	/**
	 * This method is used to Close the Browser
	 * @param driver
	 */
	public void closeTheTab(WebDriver driver)
	{
		driver.close();
	}
	/**
	 * This method is used to close the entire browser
	 * @param driver
	 */
	public void closeTheBrowser(WebDriver driver)
	{
		driver.quit();
	}
	/**
	 * This method is to Perform common Operation from launching the specified browser
	 * followed by maximizing the browser and specifying implicit wait and navigating to the application
	 * @param browser
	 * @param url
	 * @param timeInSeconds
	 * @return 
	 */
	public WebDriver commonOperation(String browser,String url,long timeInSeconds)
	{
		WebDriver driver=launchTheBrowser(browser);
		maximizeTheBrowser(driver);
		waitImplicityInSeconds(driver, timeInSeconds);
		openTheApplication(driver, url);
		return driver;
	}
	/**
	 * This method is used to MouseHover to a particular element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		a.moveToElement(element).perform();
	}
	/**
	 * This method is used to MouseHover to a particular element
	 * when horizontalAxis and VerticalAxis is Specified
	 * @param driver
	 * @param element
	 * @param horizontalAxis
	 * @param verticalAxis
	 */
	public void mouseHoverAction(WebElement element,int horizontalAxis,int verticalAxis)
	{
		a.moveToElement(element, horizontalAxis, verticalAxis).perform();
	}
	/** This Method is used to Initialize Actions Class
	 * @param driver
	 */

	public void initializeActions(WebDriver driver)
	{
		a=new Actions(driver);
	}
	/**
	 * This method is used to switch to different window
	 * @param driver
	 * @param partialText
	 */
	public void switchToWindow(WebDriver driver,String partialText)
	{
		Set<String> WindowIDS = driver.getWindowHandles();
		for (String ID : WindowIDS) {
			driver.switchTo().window(ID);
			if(driver.getCurrentUrl().contains(partialText))
			{
				break;
			}
		}
	}
	/**
	 * This Method is used to perform double click on a WebElement
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element)
	{
		a.doubleClick(element).perform();	
	}
	/**
	 * This Method is used to perform double click on a WebPage
	 * @param element
	 */
	public void doubleClickOnWebPage()
	{
		a.doubleClick().perform();	
	}
	/**
	 * This Method is used to perform Right Click on WebElement
	 * @param element
	 */
	public void rightClickOnElement(WebElement element)
	{
		a.contextClick(element).perform();	
	}
	/**
	 * This Method is used to perform Right Click on WebPage
	 * @param element
	 */
	public void rightClickOnPage()
	{
		a.contextClick().perform();	
	}
	/**
	 * This Method is used to Initialize the Drop Down
	 * @param element
	 */
	public void initializeDropDown(WebElement element)
	{
		s=new Select(element);	
	}
	/**
	 * This method is used to select Option from Drop down by visible text
	 * @param visibleText
	 */
	public void selectOptionFromDropDownVisibletext(String visibleText)
	{
		s.selectByVisibleText(visibleText);	
	}
	/**
	 * This method is used to specify explicit wait
	 * @param driver
	 * @param timeDuration
	 * @param element
	 */
	public void waitTillElementIsVisible(WebDriver driver,long timeInSeconds, WebElement element)
	{
		WebDriverWait wdw=new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds));
		wdw.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * Get Y Axis of a particular element
	 * @param ele
	 * @param x
	 * @return 
	 */
	public int scrollToElement(WebElement ele)
	{
		org.openqa.selenium.Point location = ele.getLocation();
		int yaxis=location.getY();
		return yaxis;
	}
	/**
	 * This method is used to perform scroll action by specifying xaxis and yaxis as parameter
	 * @param driver
	 * @param xaxis
	 * @param yaxis
	 */
	public void scrollAction( WebDriver driver, int xaxis, int yaxis)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+xaxis+","+yaxis+")");
	}

	/**
	 * This method is used to Initialize the JavaScriptExecutor
	 * @param driver
	 */
	public void initializeJSE(WebDriver driver)
	{
		jse=(JavascriptExecutor)driver;	
	}

	/**
	 * This method is used to pass the value using JavaScriptExecutor
	 * @param element
	 * @param data
	 */
	public void sendkeysUsingJSE(WebElement element,String data)
	{
		jse.executeScript("arguments[0].value=arguments[1]", element, data);
	}
	/**
	 * This method is used to scroll to a particular element using JavaScriptExecutor
	 * @param elementpath
	 */
	public void scrollUsingJSE(WebElement elementpath)
	{
		jse.executeScript("arguments[0].scrollIntoView()",elementpath);
	}
	/**
	 * This method is used to perform click action using JavaScriptExecutor
	 * @param element
	 */
	public void clickUsingJSE(WebElement element)
	{
		jse.executeScript("arguments[0].click()",element);
	}

	/**
	 * This method is used to convert DynamicXpath to Locator
	 * @param dynamicXpath
	 * @param replaceData
	 * @param driver
	 * @return
	 */
	public By convertDynamicXpathIntoClass(String dynamicXpath,String replaceData)
	{
		String requiredXpath = String.format(dynamicXpath,replaceData);
		By element=By.xpath(requiredXpath);
		return element;
	}

	/**
	 * This method is used to Validate Actual and Expected result by comparing two strings
	 * @param actual
	 * @param expected
	 */
	public void performValidationUsingAssert(String actual,String expected)
	{
		Assert.assertEquals(actual, expected);
	}

	/**
	 * This method is used to Validate Actual and Expected result by comparing two integers
	 * @param actual
	 * @param expected
	 */
	public void performValidationUsingAssert(int actual,int expected)
	{
		Assert.assertEquals(actual, expected);
	}

	/**
	 * This method is used to take ScreenShot when Test Case is Failed
	 * @param driver
	 * @param jou
	 * @param className
	 * @return 
	 */
	public File screenShot(WebDriver driver,JavaOperationUtilities jou,String className)
	{
		String cur = jou.getCurrentDateandTime();
		TakesScreenshot tss = (TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshots/"+className+"_"+cur+".png");
		return dst.getAbsoluteFile();
		//File dst=new File("./screenshots/"+className+"_"+cur+".png");
		//try {
			//FileUtils.copyFile(src, dst);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

	/**
	 * This Method is Used to Click on OK for the Alert Popup
	 * @param driver
	 */
	public void clickOnOK(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}

	/**
	 * This Method is Used to Click on Cancel for the Alert Pop-up
	 * @param driver
	 */
	public void clickOnCancel(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}

	/**
	 * This method is Used Save the screenshot in Report
	 * @param driver
	 * @return
	 */
	public String screenShot(WebDriver driver)
	{
		TakesScreenshot tss = (TakesScreenshot)driver;
		String tempPath = tss.getScreenshotAs(OutputType.BASE64);
		return tempPath;
	}
	
	/**
	 * This method is Used to Refresh the Page
	 * @param driver
	 */
	public void refreshThePage(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
	public void waitTillElementisInteractable(WebDriver driver,long timeInSeconds)
	{
		WebDriverWait wdw=new WebDriverWait(driver,Duration.ofSeconds(timeInSeconds));
	}
	public void selectByVisibleTextFromDropDown(String visibleText) {
		// TODO Auto-generated method stub
		
	}

}
