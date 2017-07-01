package waiterManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class CustomerVIP {
	public boolean flag = false;
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement ps;
	public int id = 1000;

	// ×¢²áÐÂid
	public void search() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/menu?user=root&password=1&useUnicode=true&characterEncoding=utf-8",
							"root", "");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM custor");
			while (resultSet.next()) {
				int sid = resultSet.getInt(1);
				if (id < sid) {
					id = sid;
				}
			}
		} catch (Exception e) {
			System.out.println("HHH");
		}
		id=id+1;

	}

	// Ìí¼ÓÐÂÕË»§
	public int add(String name, long tell) {
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/menu?user=root&password=1&useUnicode=true&characterEncoding=utf-8",
							"root", "");
			statement = connection.createStatement();
			String sql = "insert into custor(id,name,tell) values(?,?,?)";
			ps = connection.prepareStatement(sql);
			search();
			ps.setInt(1, id + 1);
			ps.setString(2, name);
			ps.setLong(3, tell);
			System.out.println("**");
			result = ps.executeUpdate();
			ps.close();
			connection.close();

		} catch (Exception e) {
			System.out.println("HHH");
		}

		return result;
	}

	// ÃÜÂëÆ¥Åä
	public boolean SearchPwsswd(int id, String passwd) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/menu?user=root&password=1&useUnicode=true&characterEncoding=utf-8",
							"root", "");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM custor");

			while (resultSet.next()) {
				int sid = resultSet.getInt(1);
				if (id == sid) {
					flag = true;
					String string = resultSet.getString(3);
					if (string.equals(passwd))
						result = true;
				}
			}
		} catch (Exception e) {
			System.out.println("HHH");
		}
		return result;
	}

	public boolean IfExit(int qid) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/menu?user=root&password=1&useUnicode=true&characterEncoding=utf-8",
							"root", "");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM custor");

			while (resultSet.next()) {
				int sid = resultSet.getInt(1);
				if (qid == sid) {
					flag = true;
					result = true;
				}
			}
		} catch (Exception e) {
			System.out.println("HHH");
		}
		return result;
	}

}
