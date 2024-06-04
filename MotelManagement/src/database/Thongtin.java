package database;

public class Thongtin{
private String id;
private String name;
private String diachi;
private int gioitinh;
private String sdt;
private byte[]image;

public Thongtin() {
	
}

public Thongtin(String id, String name, String diachi, int gioitinh, String sdt) {
	super();
	this.id = id;
	this.name = name;
	this.diachi = diachi;
	this.gioitinh = gioitinh;
	this.sdt = sdt;
	this.image = image;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDiachi() {
	return diachi;
}

public void setDiachi(String diachi) {
	this.diachi = diachi;
}

public int getGioitinh() {
	return gioitinh;
}

public void setGioitinh(int gioitinh) {
	this.gioitinh = gioitinh;
}

public String getSdt() {
	return sdt;
}

public void setSdt(String sdt) {
	this.sdt = sdt;
}

public byte[] getImage() {
	return image;
}

public void setImage(byte[] image) {
	this.image = image;
}
}