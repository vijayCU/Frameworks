package excelasDB;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

/*Accessing Excel as DB add jar Fillo dependency
 * 
 * 
 */
public class DeleteQueryforExcel {

	public static void main(String[] args) throws FilloException {
		Fillo fillo=new Fillo();
		Connection con = fillo.getConnection("./src/test/resources/ERP.xlsx");//file name is Database & sheetname is table
		String query="delete from emp where id=5";
		con.executeUpdate(query);
				
		con.close();
		System.out.println("Done");
	
	}

}
