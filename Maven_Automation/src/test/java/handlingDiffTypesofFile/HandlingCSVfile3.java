package handlingDiffTypesofFile;

import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class HandlingCSVfile3 {
	
	public static LinkedHashMap<String, String> getDatafromCSV(String path,int row) throws Exception {
		LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
		//read data from CSV
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
		return map;
		
	}

	public static void main(String[] args) throws Exception {
	LinkedHashMap<String, String> data = getDatafromCSV("./src/test/resources/CSVfile.csv",1);
	System.out.println(data);
	
	}
}
