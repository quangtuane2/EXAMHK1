package database;

public class Dsphongtro {
private String iD;
private String tenPhong;
private String trangthai;
private String giaPhong;
public Dsphongtro() {
	
}
public Dsphongtro(String iD, String tenPhong, String trangthai, String giaPhong) {
	
	this.iD = iD;
	this.tenPhong = tenPhong;
	this.trangthai = trangthai;
	this.giaPhong = giaPhong;
}
public String getiD() {
	return iD;
}
public void setiD(String iD) {
	this.iD = iD;
}
public String getTenPhong() {
	return tenPhong;
}
public void setTenPhong(String tenPhong) {
	this.tenPhong = tenPhong;
}
public String getTrangthai() {
	return trangthai;
}
public void setTrangthai(String trangthai) {
	this.trangthai = trangthai;
}
public String getGiaPhong() {
	return giaPhong;
}
public void setGiaPhong(String giaPhong) {
	this.giaPhong = giaPhong;
}

}
