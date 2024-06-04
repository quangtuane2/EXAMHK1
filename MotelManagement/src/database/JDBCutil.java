package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class JDBCutil {
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

	public static List<Thongtin> findall() {
		List<Thongtin> thongtinList = new ArrayList<>();
		String query = "select*from thongtin";
		try {
			Connection c = getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Thongtin tt = new Thongtin(rs.getString("id"), rs.getString("name"), rs.getString("diachi"),
						rs.getInt("gioitinh"), rs.getString("sdt"));
				thongtinList.add(tt);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return thongtinList;
	}

	public static void insert(Thongtin tt) {
		String query = "insert into thongtin(id, NAME, diachi, gioitinh, sdt,images)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection c = getConnection();
			PreparedStatement ppst = c.prepareStatement(query);
			ppst.setString(1, tt.getId());
			ppst.setString(2, tt.getName());
			ppst.setString(3, tt.getDiachi());
			ppst.setInt(4, tt.getGioitinh());
			ppst.setString(5, tt.getSdt());
			ppst.setBytes(6,tt.getImage());
			ppst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete(Thongtin tt) {
		String query = "delete from thongtin where name ='" + tt.getName() + "'";
		try {
			Connection c = getConnection();
			PreparedStatement ppst = c.prepareStatement(query);
			ppst.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void Update(Thongtin tt) {
             String query="UPDATE thongtin SET NAME= ?, diachi = ?, gioitinh = ?, sdt = ?,images=?"
             		+ "WHERE id = ?";
             try {
            	 Connection c = getConnection();
     			PreparedStatement ppst = c.prepareStatement(query);
     			ppst.setString(1, tt.getName());
    			ppst.setString(2, tt.getDiachi());
    			ppst.setInt(3, tt.getGioitinh());
    			ppst.setString(4, tt.getSdt());
    			ppst.setString(6, tt.getId());
    			ppst.setBytes(5, tt.getImage());
    			ppst.executeUpdate();
			} catch (Exception e) {
		       e.printStackTrace();
			}
	}
	public static List<Thongtin>find(Thongtin t) {
		List<Thongtin> thongtinL= new ArrayList<>();
		String query = "SELECT * FROM thongtin"
				+ "WHERE NAME = '"+t.getName().trim()+"'";
		try {
			Connection c = getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Thongtin tt = new Thongtin(rs.getString("id"), rs.getString("name"), rs.getString("diachi"),
						rs.getInt("gioitinh"), rs.getString("sodienthoai"));
				thongtinL.add(tt);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return thongtinL;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if (c!=null) {
				c.close();
			}
			} catch (Exception e) {
				e.printStackTrace();
				
			}

	}
}

