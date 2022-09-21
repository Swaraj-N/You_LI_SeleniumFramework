package org.tourismManagement.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataWithoutUsingIndex {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		try {
		Sheet sheet = wb.getSheet("Sheet1");
		DataFormatter df=new DataFormatter();
		String key=null;
		String value=null;
		for(int i=0;i<sheet.getLastRowNum()+1;i++)
		{
		key=df.formatCellValue(sheet.getRow(i).getCell(0));
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
			{
				value = df.formatCellValue(sheet.getRow(i).getCell(j));
			}
			System.out.println(key+ " || " +value);
			}
		}
		finally { wb.close();}
	}
}
