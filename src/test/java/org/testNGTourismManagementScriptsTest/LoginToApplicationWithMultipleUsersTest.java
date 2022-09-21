package org.testNGTourismManagementScriptsTest;

import org.TourishManagement.GenericUtilities.BaseClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginToApplicationWithMultipleUsersTest extends BaseClass {
	
	@Test(dataProvider = "getFromExcel")
	public void loginWithMultipleUsers(String UserName,String Password)
	{
		wp.userSignInAction(UserName, Password, wdu, driver);
		uhp.userSignout(wdu);
	}
	
	@DataProvider
	public String[][] getFromExcel()
	{
		String[][] obj = eu.getDataFromDataProvider("UserCredentials");
		return obj;
	}

}
