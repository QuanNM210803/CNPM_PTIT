package model;
import java.io.Serializable;

public class DichVu11 implements Serializable{
    private int id;
    private String Ten;
    private float DonGia;
    public DichVu11(int id, String Ten, float DonGia) {
        this.id = id;
        this.Ten = Ten;
        this.DonGia = DonGia;
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
    public float getDonGia() {
        return DonGia;
    }
    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }
}
