package HYBD_FW;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Reading_From_Excel2 {

//	https://poi.apache.org/
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Workbook wb= WorkbookFactory.create(new FileInputStream("./Data/input.xlsx"));
		Sheet s = wb.getSheet("Sheet2");
		int rowcount = s.getLastRowNum();
		System.out.println("Total number of Rows: "+(rowcount+1));
		for (int i=0;i<=rowcount;i++) {
		int cellcount = s.getRow(i).getLastCellNum();
		System.out.println("Total number of columns: "+cellcount);
		for (int j=0;j<cellcount;j++) {
		String data = s.getRow(i).getCell(j).getStringCellValue();
		System.out.print(data+"  ");
		}
		System.out.println();
		}
		wb.close();
	}
}
