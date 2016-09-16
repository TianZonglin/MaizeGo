package org.search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAsRelations 
{

	public static Connection getConn() 
	{
		String driverName = "com.mysql.jdbc.Driver";
		String userName = "root";
		String userPasswd = "";
		String dbName = "maizego";
		String url = "jdbc:mysql://localhost/" + dbName + "?user=" + userName
				+ "&password=" + userPasswd;
		Connection connection = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url);

		} catch (ClassNotFoundException e) {
			System.out.println("not find mysql driver...getConn"
					+ e.getMessage());
		} catch (SQLException e) {
			System.out.println("connecting DB fail...getConn" + e.getMessage());
		}
		return connection;
	}
	public static ResultSet executeQuery(String StrSQL, Connection connection) 
	{
		ResultSet rs = null;
		Statement statement = null;
		try {
		    statement = connection.createStatement();
			rs = statement.executeQuery(StrSQL);
			
		} catch (SQLException e) {
			System.out.println("connecting DB fail...executeQuery"
					+ e.getMessage());
		}
		return rs;
	}
	public static void main(String[] args) 
	{
		Long beginTime,endTime;
	    Float resultTime;
	    beginTime=System.nanoTime();
	    
	    Connection Conn = getConn();
	    String StrSQL;
	    Statement stmt;
	    int result;


	    
		try 
		{
		    String relation, str_cname_1, str_cname_2;
		    //String str_match="SELECT cname_1,cname_2,r_name FROM concepterelation";
		    //where Experiment_1 like 'L00%' 
		    String str_match="SELECT * FROM metabolic_traits_zy ";
			ResultSet rs_match = executeQuery(str_match, Conn);
			
			while (rs_match.next()) 
			{ 
				str_cname_1=rs_match.getString("n0658");
				str_cname_2=rs_match.getString("N0001");
				
				System.out.println(str_cname_1+"       "+str_cname_2);
		    }//while
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	    
	    endTime=System.nanoTime();
    	resultTime = (float)(endTime-beginTime)/1000000000;
    	System.out.println();
        System.out.println("所用时间为："+resultTime.toString());
        

	}

}
