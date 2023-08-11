package InterfaceGraphique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnectionInterface {

	private static Connection connect;

	private SingleConnectionInterface(String url, String login, String password) {
		try {
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost/tp_jdbc",
					"root", "");
		} catch (SQLException e) {
			e.printStackTrace();}
	}

	public static Connection getInstance(String url, String login, String password) {
		if(connect==null) {
			new SingleConnectionInterface(url, login, password);
		}
		return connect;
	}
}
