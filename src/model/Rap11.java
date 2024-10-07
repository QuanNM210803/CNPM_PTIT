package model;
import java.io.Serializable;

public class Rap11 implements Serializable{
    private int id;
    private String Ten;
    private String DiaChi;
    private String GioiThieu;
    public Rap11(int id, String Ten, String DiaChi, String GioiThieu) {
        this.id = id;
        this.Ten = Ten;
        this.DiaChi = DiaChi;
        this.GioiThieu = GioiThieu;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTen() {
        return Ten;
    }
    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    public String getDiaChi() {
        return DiaChi;
    }
    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    public String getGioiThieu() {
        return GioiThieu;
    }
    public void setGioiThieu(String GioiThieu) {
        this.GioiThieu = GioiThieu;
    }
}
