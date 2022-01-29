package HYBD_FW;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Reading_From_Excel {

//	https://poi.apache.org/
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Workbook wb= WorkbookFactory.create(new FileInputStream("./Data/input.xlsx"));
		Sheet s = wb.getSheet("Sheet1");
		Row r= s.getRow(0);
		Cell c=r.getCell(0);
		String v = c.getStringCellValue();
				
		Cell c1=r.getCell(1);
		double v1 = c1.getNumericCellValue();
		int i=(int)v1;

		s.createRow(1).createCell(0).setCellValue("UDAGATTI");   
		s.getRow(1).createCell(1).setCellValue("OLD GOVT");
		
		s.createRow(2).createCell(0).setCellValue("HOSPITAL");   
		s.getRow(2).createCell(1).setCellValue("RANEBENNUR");

		wb.write(new FileOutputStream("./Data/input.xlsx"));
		wb.write(new FileOutputStream("./Data/input1.xlsx"));
		System.out.println(v);
		System.out.println(v1);
		System.out.println(i);
		wb.close();
		
	}
	

}
