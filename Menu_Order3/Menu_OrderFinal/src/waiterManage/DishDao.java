package waiterManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Domain.Dish;


public class DishDao {
	Connection connection = null;
	Statement statement;
	ResultSet resultSet;

	public Dish search(int sid) {
		Dish dish = new Dish();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/menu?user=root&password=1&useUnicode=true&characterEncoding=utf-8",
							"root", "");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM dishes");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				if (id == sid) {
					dish.id = id;
					dish.name = resultSet.getString(2);
					dish.price = resultSet.getDouble(3);
					dish.chief = resultSet.getInt(4);
				}
			}
		} catch (Exception e) {
			System.out.println("HHH");
		}
		return dish;

	}

	public int searchAll() {
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/menu?user=root&password=1&useUnicode=true&characterEncoding=utf-8",
							"root", "");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM dishes");
			while (resultSet.next()) {
				i++;
				System.out.println("**");
			}
		} catch (Exception e) {
			System.out.println("HHH");

		}
		return i;

	}
}
