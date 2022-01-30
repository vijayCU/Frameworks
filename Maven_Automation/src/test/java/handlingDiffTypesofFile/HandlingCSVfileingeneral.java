package handlingDiffTypesofFile;

import java.io.FileReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class HandlingCSVfileingeneral {

	public static void main(String[] args) throws Exception {
	
	FileReader reader = new FileReader("./src/test/resources/CSVfile.csv");
	CSVParser csvFile = CSVParser.parse(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
	for(CSVRecord record:csvFile)
	{
		int colcount = record.size();
		for(int i=0;i<colcount;i++) 
		{
		String value = record.get(i);
		System.out.print(" "+value+" ");
		}
		System.out.println();
	}
	}

}
