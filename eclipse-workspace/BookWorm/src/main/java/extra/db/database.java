package extra.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import extra.utils.Strings;
public class database {
	
	public static String url;
    // Declaration of a class-level variable to hold the database connection
	public static Connection con;	
	
	public static PreparedStatement ps;
	public static ResultSet rs;
	
	public static String dataBaseHot = "localhost";
	public static String dataBasePort = "3306";
	public static String dataBaseName = "jeebd";
	public static String dataBaseUser = "root";
	public static String dataBasePassword = "";
	
	// Method to establish a database connection
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
	
	public static int exist(String email) {
		// TODO Auto-generated method stub
		try {
			
		    ps=con.prepareStatement("SELECT * from users where email=?");	
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(rs.next()) {
				return 1;
			}
			else 
			  return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Permet de se d�connecter de la base de donn�es
     */
	public static void releaseConnection() {
	    try {
	        if (con != null && !con.isClosed()) {
	            con.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}