package handlingDiffTypesofFile;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class PrintingMultiplevaluefromCSV {
	
	public static ArrayList<LinkedHashMap<String, String>> getDatafromCSV(String path) throws Exception {
		ArrayList<LinkedHashMap<String, String>> listmap = new ArrayList<LinkedHashMap<String,String>>();
		
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
			
		return listmap;
		
	}

	public static void main(String[] args) throws Exception {
	ArrayList<LinkedHashMap<String,String>> data = getDatafromCSV("./src/test/resources/CSVfile.csv");
	System.out.println(data);
	System.out.println("##########################");
	//Hardcoded using key
	for(LinkedHashMap<String, String> a:data)
	{
		System.out.print(a.get("id")+" ");
		System.out.print(a.get("name")+" ");
		System.out.print(a.get("city")+" ");
		System.out.print(a.get("area")+" ");
		System.out.println();
	}
	System.out.println("##########################");
	//general for loop
	for(LinkedHashMap<String, String> map:data)
	{
		Set<String> allkeys = map.keySet();
		for(String key:allkeys)
		{
		System.out.print(key+"="+map.get(key)+" ");
		}
		System.out.println();
	}
	}
}
