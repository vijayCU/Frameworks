package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class generalcodeExecQuery {

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
		
		//print data
		while(rs.next())//row
		{
			for(int i=1;i<=colcount;i++)//col
			{
			System.out.print(rs.getString(i));
			System.out.print("  ");
			}
			System.out.println("");
			
		}
		//close connection
		con.close();
		System.out.println("Done");


	}

}
