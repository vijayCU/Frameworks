package handlingDiffTypesofFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class WritingintoPropertyFile {

	public static void main(String[] args) throws Exception {
		
		String path="./src/test/resources/config.properties";
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(path);
		p.load(fis);
		p.setProperty("browser", "forefox");
		p.setProperty("city", "Ranbennur");
		
		p.remove("dog");
		p.store(new FileOutputStream(path), "Updated by VIJAY UDAGATTI");
	}

}
