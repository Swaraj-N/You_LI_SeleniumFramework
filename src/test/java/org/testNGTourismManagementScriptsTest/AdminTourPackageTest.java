package org.testNGTourismManagementScriptsTest;


import java.util.List;
import java.util.Map;

import org.TourishManagement.GenericUtilities.BaseClass;
import org.TourishManagement.GenericUtilities.DataTypes;
import org.testng.annotations.Test;

public class AdminTourPackageTest extends BaseClass{
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
	}
}

