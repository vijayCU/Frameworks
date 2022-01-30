package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {

	public static void main(String[] args) throws SQLException {
		System.out.println("Start");
		String dbURL="jdbc:mysql://localhost:3306/erp";
		//open connection
		Connection con = DriverManager.getConnection(dbURL,"root","");
		
		//create statement &execute query and retun result
		String myquery="insert into employee values(1,'Raju','RNR')";
		Statement sqlstmt = con.createStatement();
		sqlstmt.executeUpdate(myquery); //for update query use executeUpdate,select query executeQuery
		
		con.close();
		System.out.println("Done");


	}

}
