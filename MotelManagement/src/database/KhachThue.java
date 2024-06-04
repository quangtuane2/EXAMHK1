package database;

public class KhachThue {
private String Idthue;
private String IdPhong;
private String Idkhach;
private String Ho;
private String Ten;
public KhachThue() {
	
}
public KhachThue(String idthue, String idPhong, String idkhach, String ho, String ten) {
	
	Idthue = idthue;
	IdPhong = idPhong;
	Idkhach = idkhach;
	Ho = ho;
	Ten = ten;
}
public String getIdthue() {
	return Idthue;
}
public void setIdthue(String idthue) {
	Idthue = idthue;
}
public String getIdPhong() {
	return IdPhong;
}
public void setIdPhong(String idPhong) {
	IdPhong = idPhong;
}
public String getIdkhach() {
	return Idkhach;
}
public void setIdkhach(String idkhach) {
	Idkhach = idkhach;
}
public String getHo() {
	return Ho;
}
public void setHo(String ho) {
	Ho = ho;
}
public String getTen() {
	return Ten;
}
public void setTen(String ten) {
	Ten = ten;
}

}
