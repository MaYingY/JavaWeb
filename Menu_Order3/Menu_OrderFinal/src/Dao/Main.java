package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
	/*public static void main(String[] args) {
		getConn();
	}*/
	public Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/menu?user=root&password=1&useUnicode=true&characterEncoding=utf8","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
