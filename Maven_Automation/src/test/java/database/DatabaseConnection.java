package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
/*https://www.connectionstrings.com/
 * Instal XAMPP S/W
 *Add database connector dependancy to pom.xml for searching mysql connector maven from google and save pom.xml 
 * open XAMPP control
 * Start Mysql and Apache
 * Click on Admin button of Mysql
 * Info Req: 
 * which type of s/w:MySql,
 * DB name:erp,
 * table name: employee, 
 * schema:id name city,
 * username:root,
 * password
 * which system:localhost
 * port no:3306
 */
	public static void main(String[] args) throws SQLException {
		System.out.println("Start");
		String dbURL="jdbc:mysql://localhost:3306/erp";
		//open connection
		Connection con = DriverManager.getConnection(dbURL,"root","");
		
		//create statement &execute query and retun result
		String myquery="select * from employee";
		Statement sqlstmt = con.createStatement();
		ResultSet rs = sqlstmt.executeQuery(myquery);
		
		//Print column info
		ResultSetMetaData allcolumns = rs.getMetaData();
		int colcount = allcolumns.getColumnCount();
		System.out.println("Number of columns are: "+colcount);
		for(int i=1;i<=colcount;i++)
		{
			String colname = allcolumns.getColumnName(i);
			System.out.print(colname+"  ");
		}
		System.out.println();
		
		//print data
		while(rs.next())
		{
			System.out.print(rs.getString("id"));
			System.out.print("  ");
			System.out.print(rs.getString("name"));
			System.out.print("  ");
			System.out.print(rs.getString("city"));
			System.out.print("  ");
			System.out.println("");
			
		}
		//close connection
		con.close();
		System.out.println("Done");


	}

}
