package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCutil3 {
	public static Connection getConnection() {
		Connection c = null;
		try {
			String username = "root";
			String password = "";
			String databaseName = "student";
			String url = "jdbc:mysql://localhost/" + databaseName;
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(url, username, password);
			System.out.println("Kết nối thành công vs database " + databaseName);
		}catch(Exception e){
			e.printStackTrace();
		}
		return c;
	}
	public static void insert(KhachThue kt) {
		String query = "insert into khachthue(Num, idKH, idP, FName, LName)\r\n"
				+ "VALUES(?, ?, ?, ?, ?)";
		try {
			Connection c = getConnection();
			PreparedStatement ppst = c.prepareStatement(query);
			ppst.setString(1,kt.getIdthue());
			ppst.setString(2, kt.getIdkhach());
			ppst.setString(3, kt.getIdPhong());
			ppst.setString(4, kt.getHo());
			ppst.setString(5, kt.getTen());
			ppst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
