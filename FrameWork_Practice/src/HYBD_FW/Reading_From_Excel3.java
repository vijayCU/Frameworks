package HYBD_FW;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Reading_From_Excel3 {

//	https://poi.apache.org/
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Workbook wb= WorkbookFactory.create(new FileInputStream("./Data/input.xlsx"));
		Sheet s = wb.getSheet("Sheet3");
		int rowcount = s.getLastRowNum();
				
		for (int i=0;i<=rowcount;i++) {
		try {
				int cellcount = s.getRow(i).getLastCellNum();
		
				for (int j=0;j<cellcount;j++) {
					try {
						String data = s.getRow(i).getCell(j).getStringCellValue();
						System.out.print(data+"  ");
						}
					catch(Exception e) {
						System.out.print("**  ");// for understanding the null value of cell made **
						}
				}
				System.out.println();
		 }
	
		catch(Exception e) {
			System.out.println("-- -- -- --");// for understanding the null value of rows made -- --
		}
		}
		wb.close();
		
	}
}
