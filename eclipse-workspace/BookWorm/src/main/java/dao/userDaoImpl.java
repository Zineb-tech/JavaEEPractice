package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Users;
import extra.db.database;

public class userDaoImpl implements userDao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private Users user;
	
	
	public userDaoImpl() {
		con = extra.db.database.getConnected();
	}


	@Override
	public int verifylogin(String email, String password) {
		try {
			database.getConnected();
			ps = con.prepareStatement("SELECT * from users where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next())
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : verifyLogin");
		}

		return -1;	}

	
	@Override
	public int addUser(Users users) {
		try {
			ps=con.prepareStatement("INSERT INTO users Values (?, ?, ?)");
			ps.setString(1,users.getEmail());
			ps.setString(2,users.getFullName());
		    ps.setString(3,users.getPassword());
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
	@Override
	public String getUsernameByemail(String email) {
		try {
			ps=con.prepareStatement("SELECT fullName FROM users where email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next())			
				return rs.getString("fullName");
			else
				return "not exist";
		}catch(Exception e) {
			System.out.println("Connection error : getuserbyemail " +e );

		}
		return null;
	}



	

}
