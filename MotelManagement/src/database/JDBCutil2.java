package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCutil2 {
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

	public static List<Dsphongtro> findall() {
		List<Dsphongtro> dsList = new ArrayList<>();
		String query = "select*from thongtin";
		try {
			Connection c = getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Dsphongtro ds = new Dsphongtro(rs.getString("iD"), rs.getString("tenPhong"), rs.getString("trangThai"),
						rs.getString("giaPhong"));
				dsList.add(ds);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsList;
	}

	public static void insert(Dsphongtro ds) {
		String query = "insert into dsphongtro(iD,tenPhong,trangThai,giaPhong)"
				+ "VALUES (?, ?, ?, ?)";
		try {
			Connection c = getConnection();
			PreparedStatement ppst = c.prepareStatement(query);
			ppst.setString(1, ds.getiD());
			ppst.setString(2, ds.getTenPhong());
			ppst.setString(3, ds.getTrangthai());
			ppst.setString(4, ds.getGiaPhong());
			ppst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Delete(Dsphongtro ds) {
		String query = "delete from dsphongtro where tenPhong ='" +ds.getTenPhong()+ "'";
		try {
			Connection c = getConnection();
			PreparedStatement ppst = c.prepareStatement(query);
			ppst.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void Update(Dsphongtro ds) {
             String query="UPDATE dsphongtro SET tenPhong = ?, trangThai = ?, giaPhong = ?\r\n"
             		+ "WHERE iD = ?";
             try {
            	 Connection c = getConnection();
     			PreparedStatement ppst = c.prepareStatement(query);
     			ppst.setString(1, ds.getTenPhong());
    			ppst.setString(2, ds.getTrangthai());
    			ppst.setString(3, ds.getGiaPhong());
    			ppst.setString(4, ds.getiD());
    			ppst.executeUpdate();
			} catch (Exception e) {
		       e.printStackTrace();
			}
	}
	
}
