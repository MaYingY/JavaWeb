package entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Domain.WaiterClass;

public class Enwaiter {
	public boolean flag=false;
	Connection connection=null;
	Statement statement;
	ResultSet resultSet;
	public void  correct(int sid,String passdString) {
		try {
			System.out.println(passdString);
			Class.forName("com.mysql.jdbc.Driver");
			
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/menu","root","");
			 statement= connection.createStatement();
			 statement.execute("update waiter set passwd ="+passdString+" where id ="+sid);
			System.out.println("(*");
			connection.close();
		} catch (Exception e) {
			
		}
		
	}
	public WaiterClass wav(int sid){
		WaiterClass waiterClass = new WaiterClass();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/menu","root","");
			statement=connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM waiter");
			
			while(resultSet.next()){
				int id=resultSet.getInt(1);
				if(id==sid){
					flag=true;
				String name= resultSet.getString(2);
				String passwdString = resultSet.getString(3);
				waiterClass.name=name;
				waiterClass.passwd=passwdString;
				}
			}
		} catch (Exception e) {
			System.out.println("HHH");
		}
		return waiterClass;
	}
}

