package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.String;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public abstract class Excel {
	public static String getCellValue(String path,String sheet,int row,int col) {
		String value="";
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			value=wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
			wb.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return value;		
	}
	
	public static int getRowCount(String path,String sheet) {
		int rowcount=0;
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rowcount=wb.getSheet(sheet).getLastRowNum();
			wb.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rowcount;
	}
	
	public static int getColumnCount(String path,String sheet,int row) {
		int colcount=0;
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			colcount=wb.getSheet(sheet).getRow(row).getLastCellNum();
			wb.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return colcount;
	}
	
	public static void setCellValue(String path,String sheet,int row,int col,String value) {
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			try {
			wb.getSheet(sheet).getRow(row).createCell(col).setCellValue(value);
			}
			catch(Exception e) {
				wb.getSheet(sheet).createRow(row).createCell(col).setCellValue(value);
			}
			wb.write(new FileOutputStream(path));
			wb.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static Iterator<String[]> getdatafromExcel(String path,String sheet)  {
		ArrayList<String[]> al=new ArrayList<String[]>();
		try {
		Workbook wb= WorkbookFactory.create(new FileInputStream(path));
		Sheet s = wb.getSheet(sheet);
		int rowcount = s.getLastRowNum();
				
		for (int i=0;i<=rowcount;i++) {
		try {
				int cellcount = s.getRow(i).getLastCellNum();
				String[] arr=new String[cellcount];
				for (int j=0;j<cellcount;j++) {
					try {
						String data = s.getRow(i).getCell(j).getStringCellValue();
						arr[j]=data;
					}
					catch(Exception e) {
						}
				}
				al.add(arr);
		}
	
		catch(Exception e) {
		}
		}
		wb.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 Iterator<String[]> idata = al.iterator();
		 return idata;
	}
}
