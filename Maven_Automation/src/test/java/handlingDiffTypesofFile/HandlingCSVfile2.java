package handlingDiffTypesofFile;

import java.io.FileReader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class HandlingCSVfile2 {

	public static void main(String[] args) throws Exception {
		//read data from CSV
		FileReader reader = new FileReader("./src/test/resources/CSVfile.csv");
		CSVParser csvFilecontent = CSVParser.parse(reader, CSVFormat.DEFAULT);
		//get CSV content as list of records
		List<CSVRecord> allrecords = csvFilecontent.getRecords();
		int rowcount = allrecords.size();
		System.out.println("Row count: "+rowcount);
		CSVRecord header = allrecords.get(0);
		int colcount = header.size();
		System.out.println("column count: "+colcount);
		for(int i=0;i<colcount;i++)
		{
			String headername=header.get(i);
			System.out.print(headername+"  ");//Print Header
		}
		System.out.println();
		CSVRecord data = allrecords.get(1);
		for(int i=0;i<colcount;i++)
		{
			String value=data.get(i);
			System.out.print(value+"  ");//Print Values
		}
		
		
		
	
	
	}
}
