package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class LookMenu {

	Connection connection;
	Statement statement;
	
	public void  name(int c,int id) {
		try {
			PreparedStatement ps;
			Class.forName("com.mysql.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/menu","root","");
			ps=connection.prepareStatement("update menu set stat = 1 where chief = "+c+" and id = "+id);
			ps.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println("HHH");
		}
		
	}
}

