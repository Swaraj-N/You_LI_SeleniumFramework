package org.testNGTourismManagementScriptsTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGrid {
	@Test
	public void test1() throws MalformedURLException {
		DesiredCapabilities DC=new DesiredCapabilities();
		DC.setBrowserName("chrome");
		DC.setPlatform(Platform.WINDOWS);
		URL url=new URL("http://192.168.246.1:4444/wd/hub");
		RemoteWebDriver driver=new RemoteWebDriver(url, DC);
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System");
	}

}
