package handlingDiffTypesofFile;

import java.io.FileInputStream;
import io.restassured.path.json.JsonPath;

public class HandlingJSON {

	public static void main(String[] args) throws Exception {

		JsonPath j=new JsonPath(new FileInputStream("./src/test/resources/info.json"));
		System.out.println("Key1 value: "+j.getString("key1"));
		System.out.println("Key2 value: "+j.getString("key2"));
		System.out.println("Key3 value: "+j.getString("key3"));
		System.out.println("Key4 value: "+j.getString("key4"));
		
		System.out.println("Key5 size is: "+j.getString("key5.size()"));
		System.out.print("Key5 Values are :");
		System.out.print(j.getString("key5[0]")+", ");
		System.out.println(j.getString("key5[1]"));
		
		System.out.println("Key6 value: "+j.getString("key6.K6a"));
		
		System.out.print("Key7 value: "+j.getString("key7[0].K7a"));
		System.out.println(", "+j.getString("key7[1].K7b"));
		
		System.out.println("Key8 value: "+j.getString("key8.key8a.key8b.k"));
	}

}
