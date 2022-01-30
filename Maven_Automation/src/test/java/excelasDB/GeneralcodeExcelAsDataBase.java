package excelasDB;

import java.util.ArrayList;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

/*Accessing Excel as DB add jar Fillo dependency
 * 
 * 
 */
public class GeneralcodeExcelAsDataBase {

	public static void main(String[] args) throws FilloException {
		Fillo fillo=new Fillo();
		Connection con = fillo.getConnection("./src/test/resources/ERP.xlsx");//file name is Database & sheetname is table
		String query="select * from emp";
		Recordset recordSet = con.executeQuery(query);
		ArrayList<String> allColumns = recordSet.getFieldNames();
		int count = allColumns.size();
		for(String column:allColumns)
		{
			System.out.print(column+" ");
		}
		System.out.println();
		while(recordSet.next())
		{
			for(int i=0;i<count;i++)
			{
			System.out.print(recordSet.getField(i).value()+" ");
			}
			System.out.println();
		}
		
		con.close();
		System.out.println("Done");
	
	}

}
