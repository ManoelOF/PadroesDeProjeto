package Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/upis";
	private static String USER = "root";
	private static String PASS = "admin";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);

			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException ex) {
			throw new RuntimeException("Erro na conexção: ", ex);

		}
	}

	public static void closeConnection(Connection con) {

		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
}
