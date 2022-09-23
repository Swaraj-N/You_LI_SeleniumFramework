package org.testNGTourismManagementScriptsTest;

import org.TourishManagement.GenericUtilities.BaseClass;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class Write_Us_1RefundTest extends BaseClass{
	@Test
	public  void write_Us_RefundTest(){
		//CommonPage cp=new CommonPage();
		//cp.performclick(driver, WelcomePageLinks.SIGNIN);
		wp.userSignInAction(UUser, UPassword, wdu, driver);
		wdu.waitImplicityInSeconds(driver, longtime);
		uhp.clickOnWriteusMajorTab();
		uhp.createIssue(driver, longtime, visibleText1, Refunddesc, RandomNumber, wdu);
		uhp.clickOnIssueTickets(driver, 10, wdu);
	    itp.scrolllastUpdatedemark(wdu);
	    
		String Actualdesc = itp.getTextFromTheLastRow(driver,Refunddesc+RandomNumber);
		System.out.println(Actualdesc);
		
		wdu.performValidationUsingAssert(Actualdesc, Refunddesc+RandomNumber);
		Reporter.log("User TC Pass",true);
		uhp.userSignout(wdu);
		
		wp.AdminLoginAction(AUser, APass);
			
		//afp.manageIssueAction(wdu, driver);
		
	    mip.manageIssueClick();
		mip.ManageIssueAction(wdu, driver);
		String Actualdesc1=mip.getTextFromTheLastRow(driver,Refunddesc+RandomNumber);
		System.out.println(Actualdesc1);

		wdu.performValidationUsingAssert(Actualdesc1, Refunddesc+RandomNumber);
		Reporter.log("Admin TC Pass",true);
		afp.adminLogoutAction(wdu, driver);
		afp.backtohome();
		
	}
	
}




