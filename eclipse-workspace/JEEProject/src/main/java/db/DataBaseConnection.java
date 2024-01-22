
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;



public class DataBaseConnection {
	
	public static String url;
	public static String dataBaseHot = "localhost";
	public static String dataBasePort = "3306";
	public static String dataBaseName = "jeedb";
	public static String dataBaseUser = "root";
	public static String dataBasePassword = "";
	
	public static Connection con;
	public static PreparedStatement ps;
	public static Statement st;
	public static ResultSet rs;
	String query;
	

	
	public static Connection getConnected()   {
		try{
			url = "jdbc:mysql://"+dataBaseHot+":"+dataBasePort+"/"+dataBaseName;
			
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, dataBaseUser, dataBasePassword);
		}
		catch(Exception e){
			System.out.println("Connection failed : "+e);
			return null;
		}
		
		return con;
	}
	 
	
	public static void releaseConnection()  {
		try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		

    
	public static int verifyLogin(String email, String password) {
		 try {
			  ps=con.prepareStatement("SELECT * from users where email=? and password=?");
			  ps.setString(1, email);
			  ps.setString(2, password);
			  rs=ps.executeQuery();
			  if(rs.next())
				  return 1;
			  else
				  return 0;
		}catch(Exception e) {
				System.out.println("Connection error : verifyLogin");
			}
			
		return -1;
	}
	
	public static int exist(String email) {
		 try {
			  ps=con.prepareStatement("SELECT * from users where email=?");
			  ps.setString(1, email);
			  rs=ps.executeQuery();
			  if(rs.next())
				  return 1;
			  else
				  return 0;
		}catch(Exception e) {
				System.out.println("Connection error : exist");
			}
			
		return -1;
	}
	
	
	
	public static int createUser(String email, String fullName, String password) {
		try {
			getConnected();
			ps=con.prepareStatement("INSERT INTO users Values (?, ?, ?)");
			ps.setString(1,email);
			ps.setString(2,fullName);
		    ps.setString(3,password);
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : createUser " +e );
		}
		return -1;		
	}
	
	
	
	public static String getUserNameByEmail(String email) {
	    try {
	        ps = con.prepareStatement("SELECT fullName from users where email=?");
	        ps.setString(1, email);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            String fullName = rs.getString("fullName");
	            System.out.println("Full Name: " + fullName);
	            return fullName;
	        }
	    } catch (Exception e) {
	        System.out.println("Connection error: " + e);
	    } finally {
	        releaseConnection(); // Close the connection in a finally block
	    }
	    return null;
	}


	
}
