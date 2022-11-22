package org.testNGTourismManagementScriptsTest;

import org.TourishManagement.GenericUtilities.BaseClass;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class WriteUsCancellationTest extends BaseClass{
	@Test
	public void CancellationTest() {
		wp.userSignInAction(UUser, UPassword, wdu, driver);
		wdu.waitImplicityInSeconds(driver, longtime);
		uhp.clickOnWriteusMajorTab();
		uhp.createIssue(driver, longtime, visibleText2, Canceldesc, RandomNumber, wdu);
		uhp.clickOnIssueTickets(driver, 10, wdu);
	    itp.scrolllastUpdatedemark(wdu);
		String Actualdesc = itp.getTextFromTheLastRow(driver,Canceldesc+RandomNumber);
		System.out.println(Actualdesc);
		wdu.performValidationUsingAssert(Actualdesc, Canceldesc+RandomNumber);
		Reporter.log("User TC Pass",true);
		uhp.userSignout(wdu);
		wp.AdminLoginAction(AUser, APass);
		mip.manageIssueClick();
		mip.ManageIssueAction(wdu, driver);
		String Actualdesc1=mip.getTextFromTheLastRow(driver,Canceldesc+RandomNumber);
		System.out.println(Actualdesc1);
		wdu.performValidationUsingAssert(Actualdesc1, Canceldesc+RandomNumber);
		Reporter.log("Admin TC Pass",true);
		afp.adminLogoutAction(wdu, driver);
		afp.backtohome();
	}
	
}
	

