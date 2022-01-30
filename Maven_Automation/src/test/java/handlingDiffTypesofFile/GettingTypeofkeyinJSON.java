package handlingDiffTypesofFile;

import java.io.FileInputStream;
import io.restassured.path.json.JsonPath;

public class GettingTypeofkeyinJSON {

	public static void main(String[] args) throws Exception {

		JsonPath j=new JsonPath(new FileInputStream("./src/test/resources/info.json"));
		for(int i=1;i<=8;i++)
		{
			Object obj = j.get("key"+i);
			String actualDataType = obj.getClass().getName();//fully Qualified path
			System.out.println("fully Qualified Data type of key"+i+" is: "+actualDataType);
		
			String actualDataType1 = obj.getClass().getSimpleName();//fully Qualified path
			System.out.println("Data type of key"+i+" is: "+actualDataType1);
			System.out.println("-----------------------------------------------------------");
		}
	}
}
