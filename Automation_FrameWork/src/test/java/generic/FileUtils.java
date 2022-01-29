package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.aventstack.extentreports.ExtentTest;


 public class FileUtils 
 {
	 public ExtentTest eTest;
	 public Logger log4j;
		
	 public FileUtils(ExtentTest eTest,Logger log4j)
		{
			this.eTest=eTest;
			this.log4j=log4j;
		}
		
	public static String currentDateTime()
		{
			DateFormat date = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
			String timestamp = date.format(new Date());
			return timestamp;
		}

	public static String getPropertyValue(String path,String key)
	{
		String value="";
		Properties p=new Properties();
		try {
			p.load(new FileInputStream(path));
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		 value = p.getProperty(key);
		return  value;
	}
	
	public static String getExcelData(String path,String sheet,int row,int col) {
		String value="";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			value=wb.getSheet(sheet).getRow(row).createCell(col).getStringCellValue();
			wb.close();
			}
			catch(Exception e) {
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
	
	public static Iterator<String[]> getdatafromExcelforDP(String path,String sheet)  {
		ArrayList<String[]> datalist=new ArrayList<String[]>();
		try {
		Workbook wb= WorkbookFactory.create(new FileInputStream(path));
		Sheet s = wb.getSheet(sheet);
		int rowcount = s.getLastRowNum();				
		for (int i=1;i<=rowcount;i++) {
		try {
				int cellcount = s.getRow(i).getLastCellNum();
				String[] arr=new String[cellcount];
				for (int j=0;j<cellcount;j++) {
					try {
							String data = s.getRow(i).getCell(j).getStringCellValue();
							arr[j]=data;
						}
					catch(Exception e) 
					{
						e.printStackTrace();
					}
				}
				datalist.add(arr);
		}
	
		catch(Exception e) {
		}
		}
		wb.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 Iterator<String[]> idata = datalist.iterator();
		 return idata;
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
	
	public static LinkedHashMap<String, String> getDatafromCSV(String path,int row)
	{
		LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
		//read data from CSV
		try 
		{
			CSVParser csvFilecontent = CSVParser.parse(new FileReader(path), CSVFormat.DEFAULT);
			//get CSV content as list of records
			List<CSVRecord> allrecords = csvFilecontent.getRecords();
			CSVRecord header = allrecords.get(0);
			int colcount = header.size();
			CSVRecord data = allrecords.get(row);
			for(int i=0;i<colcount;i++)
			{
				String key=header.get(i);
				String value=data.get(i);
				map.put(key,value);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	
	public static ArrayList<LinkedHashMap<String, String>> getAllDatafromCSV(String path){
		ArrayList<LinkedHashMap<String, String>> listmap = new ArrayList<LinkedHashMap<String,String>>();
		try
		{
			//read data from CSV
			CSVParser csvFilecontent = CSVParser.parse(new FileReader(path), CSVFormat.DEFAULT);
			//get CSV content as list of records
			List<CSVRecord> allrecords = csvFilecontent.getRecords();
			CSVRecord header = allrecords.get(0);
			int colcount = header.size();
			for(int i=1;i<allrecords.size();i++)
			{
				LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
				CSVRecord data = allrecords.get(i);
				for(int j=0;j<colcount;j++)
				{
					String key=header.get(j);
					String value=data.get(j);
					map.put(key,value);
				}
			listmap.add(map);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listmap;
	}
	
	public static Iterator<String[]> getdatafromCSVforDP(String path)  {
		ArrayList<String[]> datalist=new ArrayList<String[]>();
		try {
			//read data from CSV
			CSVParser csvFilecontent = CSVParser.parse(new FileReader(path), CSVFormat.DEFAULT);
			//get CSV content as list of records
			List<CSVRecord> allrecords = csvFilecontent.getRecords();
		int colcount = allrecords.get(0).size();			
		for (int i=1;i<allrecords.size();i++) 
		{
			String[] data=new String[colcount];
			CSVRecord record = allrecords.get(i);
			for (int j=0;j<colcount;j++) 
			{
				String value = record.get(j);
				data[j]=value;
			}
			datalist.add(data);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 Iterator<String[]> idata = datalist.iterator();
		 return idata;
	}
}