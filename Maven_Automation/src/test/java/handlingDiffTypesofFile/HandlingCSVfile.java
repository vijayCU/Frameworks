package handlingDiffTypesofFile;

import java.io.FileReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class HandlingCSVfile {

	public static void main(String[] args) throws Exception {
	FileReader reader = new FileReader("./src/test/resources/CSVfile.csv");
	CSVParser csvFile = CSVParser.parse(reader, CSVFormat.DEFAULT);
	for(CSVRecord record:csvFile)
	{
		String id = record.get(0);
		String name = record.get(1);
		String city = record.get(2);
		String area = record.get(3);
		System.out.print(id+" "+name+" "+city+" "+area);
		System.out.println();
	}
	System.out.println("#####################################");
	System.out.println();
	
	//considering first record as header
	FileReader reader1 = new FileReader("./src/test/resources/CSVfile.csv");
	CSVParser csvFile1 = CSVParser.parse(reader1, CSVFormat.DEFAULT.withFirstRecordAsHeader());
	for(CSVRecord record:csvFile1)
	{
		String id = record.get(0);
		String name = record.get(1);
		String city = record.get(2);
		String area = record.get(3);
		System.out.print(id+" "+name+" "+city+" "+area);
		System.out.println();
	}
	System.out.println("########################################");
	FileReader reader2 = new FileReader("./src/test/resources/CSVfile.csv");
	CSVParser csvFile2 = CSVParser.parse(reader2, CSVFormat.DEFAULT.withFirstRecordAsHeader());
	for(CSVRecord record:csvFile2)
	{
		String id = record.get("id");
		String name = record.get("name");
		String city = record.get("city");
		String area = record.get("area");
		System.out.print(id+" "+name+" "+city+" "+area);
		System.out.println();
	}
	
	
	}

}
