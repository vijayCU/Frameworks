package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class generalcodeCountNUMofRows {

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
		int i=0;	
		//print data
		while(rs.next())//row
		{
			
			for(int j=1;j<=colcount;j++)//col
			{
				System.out.print(rs.getString(j));
				System.out.print("  ");
			}
			i++;
		 System.out.println("");
					
		}
		System.out.println("Number of columns: "+i);
		//close connection
		con.close();
		System.out.println("Done");


	}

}
