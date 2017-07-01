package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChiefOperate {
	
	static Main newMain = new Main();
    static Connection con = newMain.getConn();
	//Ìí¼Ó¾ÆÆ·
	public void addWine(int id, String name, double price, int type) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into wine(id, name, price, type) values(?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setDouble(3, price);
		preparedStatement.setInt(4, type);
		preparedStatement.executeUpdate();
	}
	public void deleteWine(String name) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from wine where name=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.executeUpdate();
	}
	public void modMenu(int id, String name, double price, int type) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update wine set name=?,price=?,type=? where id=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setDouble(2, price);
		preparedStatement.setInt(3, type);
		preparedStatement.setInt(4, id);
		preparedStatement.executeUpdate();
	}
	public void modInfo(String name, String passwd) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update chief set passwd=? where name=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, passwd);
		preparedStatement.executeUpdate();
	}
}
