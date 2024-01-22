package dao;
import Model.Users;
//using interface(completly abstract) to achieve security hide certain details and show only the important one
//an interface can be defined as a container that stores the signatures of the methods to be implemented in the code segment.
public interface userDao {
	
     public int verifylogin(String email, String password);
     public String getUsernameByemail(String email);
     public int addUser(Users users);
     
}
