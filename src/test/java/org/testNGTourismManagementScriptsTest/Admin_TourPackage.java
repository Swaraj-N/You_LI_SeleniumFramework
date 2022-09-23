package org.testNGTourismManagementScriptsTest;


import java.util.Map;

import org.TourishManagement.GenericUtilities.DataTypes;
import org.testng.annotations.Test;
import java.util.List;

public class Admin_TourPackage extends org.TourishManagement.GenericUtilities.BaseClass{
	@Test
	public void createPackage() {
		wp.AdminLoginAction(AUser, APass);
		String packageNumber = afp.packageNumber();
		int packCountBefore=(int) jou.convertStringIntoAnyDatatype(packageNumber, DataTypes.INT);
		System.out.println("Package count Before creating package:"+packCountBefore);
		afp.Tourpackagebutton();
		afp.CreateOptionbutton(wdu);
		List<Map<String, String>>listmap=eu.getDataFromExcelInList("CreatePackage");
		cpp.CreatPackagedetails2(listmap,RandomNumber,wdu);
		cpp.CreateButton();
		afp.DashBoardButton();
		System.out.println(listmap);
		int packCountAfter=(int) jou.convertStringIntoAnyDatatype(packageNumber, DataTypes.INT);
		System.out.println("Package count After creating package:"+packCountAfter);
		wdu.performValidationUsingAssert(packCountAfter,packCountBefore );
		System.out.println("TestCase Pass");
		afp.adminLogoutAction(wdu, driver);
		
		
		
		
		//Map<String, String> map=elib.getDataFromExcelMap("Sheet1");
		//admin_TourPackagePage.packageFillAction2(random, listmap, wlib, driver);
		
		//commonpage.clickonAdminLogout(wlib, driver);
	//	DynamicConversationPage d=new DynamicConversationPage();
		//d.performActiononDynamicElement(driver,WelComePageLinks.SignIN);
		
	//	loginpage.UserloginAction(un, pwd);
	//	commonpage.UserTourPackageLink();
		//d.performActiononDynamicElement(driver,WelComePageLinks.TourPackage);
		//user_TourPackagePage.scrollTillalldataSelect(wlib, driver);
//		String ActualpackageName=user_TourPackagePage.getTextFromTheLastRow(driver,expectedPackageName );
//		System.out.println(ActualpackageName);
//		wlib.verifyResult(ActualpackageName,expectedPackageName);
//		Reporter.log("Admin TC Pass",true);
//		commonpage.logoutAction();
//		
//		
//		
		
		
		
		
		
		
		//admin_TourPackagePage.packageFillAction(map, wlib, driver);
		
		//commonpage.clickonAdminLogout(wlib, driver);
		//loginpage.UserloginAction(un, pwd);
		//user_TourPackagePage.user_TourPackageLinkAction(wlib, driver);
		
		
		//wlib.goBackToAdminHomePage(driver);
		
		//wlib.mouseHoverAction(driver, administratorLink);
		//commonpage.adminLoginAction();
		//loginpage.UserloginAction(un, pwd);
		//user_TourPackagePage.user_TourPackageLinkAction();
		}
}

