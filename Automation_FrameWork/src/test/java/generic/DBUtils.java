package generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DBUtils {
	
	public ExtentTest eTest;
	public Logger log4j;
	public DBUtils(ExtentTest eTest,Logger log4j)
	{
		this.eTest=eTest;
		this.log4j=log4j;
	}
	
	public static ArrayList<LinkedHashMap<String, String>> getDataFromMySQL(String dbURL,String un,String pw,String query)
	{
		ArrayList<LinkedHashMap<String, String>> listmap = new  ArrayList<LinkedHashMap<String, String>>();
		try 
		{	
			Connection connection = DriverManager.getConnection(dbURL,un,pw);
			Statement sqlstmt = connection.createStatement();
			ResultSet resultset = sqlstmt.executeQuery(query);
			ResultSetMetaData allcolumns = resultset.getMetaData();
		
			int colcount = allcolumns.getColumnCount();
			while(resultset.next())
			{
				LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
				for(int i=1;i<=colcount;i++)
				{
					String colName=allcolumns.getColumnName(i);
					String value=resultset.getString(i);
					map.put(colName,value);
				}
				listmap.add(map);
			}
			connection.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return listmap;
	}
	
	public static void executeDMLInSQL(String dbURL,String un,String pw,String query)
	{
		try
		{
			Connection connection = DriverManager.getConnection(dbURL,un,pw);
			Statement sqlstmt = connection.createStatement();
			sqlstmt.executeUpdate(query);
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static Iterator<String[]> getDataFromMySQLToDP(String dbURL,String un,String pw,String query)
	{
		ArrayList<String[]> list = new  ArrayList<String[]>();
		try 
		{	
			Connection connection = DriverManager.getConnection(dbURL,un,pw);
			Statement sqlstmt = connection.createStatement();
			ResultSet resultset = sqlstmt.executeQuery(query);
			ResultSetMetaData allcolumns = resultset.getMetaData();
		
			int colcount = allcolumns.getColumnCount();
			while(resultset.next())
			{
				String[] data=new String[colcount];
				for(int i=0;i<colcount;i++)
				{
					String value=resultset.getString(i+1);
					data[i]=value;
				}
				list.add(data);
			}
			connection.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list.iterator();
	}
	
	public Iterator<String[]> getDataFromXLasDBtoDP(String path,String sheet) {
		ArrayList<String[]> list=new ArrayList<String[]>();
		try 
		{
			Fillo fillo=new Fillo();
			com.codoid.products.fillo.Connection con = fillo.getConnection(path);//file name is Database & sheetname is table
			String query="select * from "+sheet;
			Recordset recordSet = con.executeQuery(query);
			int colcount = recordSet.getCount();
			while(recordSet.next())
			{
				String[] data=new String[colcount];
				for(int i=0;i<colcount;i++)
				{
					data[i]=recordSet.getField(i).value();
				}
			list.add(data);
			}
			recordSet.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return list.iterator();
	}
	
	public void UpdateQueryforExcelasDB(String path,String query)
	{
		try
		{
			Fillo fillo=new Fillo();
			com.codoid.products.fillo.Connection con = fillo.getConnection(path);//file name is Database & sheetname is table
			con.executeUpdate(query);
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}