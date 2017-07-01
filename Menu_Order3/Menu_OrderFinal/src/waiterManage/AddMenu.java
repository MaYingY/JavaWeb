package waiterManage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import Domain.Dish;


public class AddMenu {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement ps;

	public AddMenu() {
	}

	public int add(int id, String name, int desk, int type) {
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/menu?user=root&password=1&useUnicode=true&characterEncoding=utf-8",
							"root", "");
			statement = connection.createStatement();
			String sql = "insert into menu(id,name,desk,chief,stat,price) values(?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, desk);

			Dish dish = new Dish();
			DishDao dao = new DishDao();
			dish = dao.search(id);
			if (type == 0) {
				ps.setInt(4, 0);
				ps.setInt(5, 1);
			} else {

				int i = dish.chief;
				ps.setInt(4, i);
				ps.setInt(5, 0);
			}

			double t = dish.price;
			ps.setDouble(6, t);
			result = ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (Exception e) {
		}
		return result;
	}

	public double total(JTextArea textArea, int desk) {
		double result = 0.0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/menu?user=root&password=1&useUnicode=true&characterEncoding=utf-8",
							"root", "");
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select * from menu where desk =" + desk);
			while (resultSet.next()) {
				int t = resultSet.getInt(3);
				int stat = resultSet.getInt(5);
				if (t == desk && stat == 1) {
					String name = resultSet.getString(2);
					double price = resultSet.getDouble(6);
					textArea.append(name + " " + price + "\n");
					result = result + price;
				}
			}
			connection.close();
		} catch (Exception e) {
			System.out.println("HHH");
		}
		return result;
	}

	public void del(int desk) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/menu?user=root&password=1&useUnicode=true&characterEncoding=utf-8",
							"root", "");
			statement = connection.createStatement();
			statement.execute("delete from menu where desk =" + desk);
			connection.close();
		} catch (Exception e) {
			System.out.println("HHH");
		}

	}

}

