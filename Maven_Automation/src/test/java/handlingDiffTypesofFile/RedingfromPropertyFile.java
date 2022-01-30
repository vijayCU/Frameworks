package handlingDiffTypesofFile;

import java.io.FileInputStream;
import java.util.Properties;

public class RedingfromPropertyFile {

	public static void main(String[] args) throws Exception {
		
		String path="./src/test/resources/config.properties";
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(path);
		p.load(fis);
		String url = p.getProperty("url");
		System.out.println(url);
		
		String browser = p.getProperty("browser");
		System.out.println(browser);
		
		String ito = p.getProperty("ITO");
		System.out.println(ito);
	}

}
