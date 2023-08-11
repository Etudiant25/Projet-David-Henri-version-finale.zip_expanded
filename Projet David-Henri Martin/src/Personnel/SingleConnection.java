package Personnel;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {

	private static Connection connect;

	private SingleConnection(String url, String login, String password) {
		try {
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost/tp_jdbc",
					"root", "");
		} catch (SQLException e) {
			e.printStackTrace();}
	}

	public static Connection getInstance(String url, String login, String password) {
		if(connect==null) {
			new SingleConnection(url, login, password);
		}
		return connect;
	}
}
