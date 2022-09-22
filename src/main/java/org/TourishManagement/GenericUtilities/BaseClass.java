
package org.TourishManagement.GenericUtilities;

import org.TourismManagement.POMRepository.AdminFunctionalitiesPage;

import org.TourismManagement.POMRepository.AdminRemarkUpdateWindowPage;
import org.TourismManagement.POMRepository.CommonPage;
import org.TourismManagement.POMRepository.CreatePackagePage;
import org.TourismManagement.POMRepository.EnquiryPage;
import org.TourismManagement.POMRepository.IssueTicketsPage;
import org.TourismManagement.POMRepository.ManageBookingPage;
import org.TourismManagement.POMRepository.ManageIssuePage;
import org.TourismManagement.POMRepository.PackageDetailsPage;
import org.TourismManagement.POMRepository.UserHomePage;
import org.TourismManagement.POMRepository.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	protected WebDriver driver;
	protected WebDriverUtility wdu;
	protected ExcelUtilities eu;
	protected String AUser;
	protected String APass;
	protected String comment;
	protected int RandomNumber;
	protected String UPassword;
	protected String UUser;
	protected String issuedesc;
	protected String issue;
	protected String remark;
	protected JavaOperationUtilities jou;
	protected WelcomePage wp;
	protected AdminFunctionalitiesPage afp;
	protected UserHomePage uhp;
	protected long longtime;
	protected CreatePackagePage cpp;
	protected ManageBookingPage mbp;
	protected PackageDetailsPage pdp;
	protected CommonPage cp;
	protected AdminRemarkUpdateWindowPage aruw;
	public static WebDriver sdriver;
	public static JavaOperationUtilities sjou;
	protected EnquiryPage ep;
	protected String Refunddesc;
	protected String Canceldesc;
	protected String visibleText1;
	protected String visibleText2;
	protected IssueTicketsPage itp;
	protected ManageIssuePage mip;
	//@Parameters(value="browser")
	@BeforeClass
	public void classSetup()
	{
		//Initialize all the utilities
		PropertyUtilities Pu=new PropertyUtilities();
		wdu=new WebDriverUtility();
		GenerateRandomNumberUtility Grnu=new GenerateRandomNumberUtility();
		RandomNumber = Grnu.setRandomNumber(1000);
		jou=new JavaOperationUtilities();
		String Browser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "Browser");
		String Url = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "URL");
		String time = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "TimeUnit");
		issue = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "bookingissue");
		issuedesc = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "issuedesc");
		remark = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "remark");
		UUser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "UUserName");
		UPassword = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "UPassword");
		AUser = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "AdminUser");
		APass = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "AdminPassword");
		remark = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "remark");
		comment = Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "comment");
		Refunddesc=Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "Refunddesc");
		Canceldesc=Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "Canceldesc");
		visibleText1=Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "visibleText1");
		visibleText2=Pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "visibleText2");
		longtime = (long)jou.convertStringIntoAnyDatatype(time, DataTypes.LONG);
		driver = wdu.commonOperation(Browser, Url, longtime);
		sdriver = driver;
		sjou=jou;
		wdu.waitImplicityInSeconds(driver, longtime);
		wdu.initializeJSE(driver);
		wp=new WelcomePage(driver);
		afp=new AdminFunctionalitiesPage(driver);
		eu=new ExcelUtilities();
		eu.openExcel(IConstantPath.EXCEL_PATH);
//		Refunddesc=RandomNumber+Refunddesc;
//		Canceldesc=RandomNumber+Canceldesc;
	}

	@BeforeMethod
	public void methodSetup()
	{

		wp=new WelcomePage(driver);
		afp=new AdminFunctionalitiesPage(driver);
		uhp=new UserHomePage(driver);
		cpp=new CreatePackagePage(driver);
		mbp=new ManageBookingPage(driver);
		pdp=new PackageDetailsPage(driver);
		aruw=new AdminRemarkUpdateWindowPage(driver);
		cp=new CommonPage();
		ep=new EnquiryPage(driver);
		itp=new IssueTicketsPage(driver);
		mip=new ManageIssuePage(driver);
	}


	@AfterClass
	public void classTearDown()
	{
		eu.closeExcel();
		//wdu.closeTheBrowser(driver);
	}

}
