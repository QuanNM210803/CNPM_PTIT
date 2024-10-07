package model;
import java.io.Serializable;

public class KhachHang11 implements Serializable{
    private int id;
    private String SoTheThanhToan;
    private String TenDayDu;
    private String DiaChi;
    private String Email;
    public KhachHang11(int id, String SoTheThanhToan, String TenDayDu, String DiaChi, String Email) {
        this.id = id;
        this.SoTheThanhToan = SoTheThanhToan;
        this.TenDayDu = TenDayDu;
        this.DiaChi = DiaChi;
        this.Email = Email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSoTheThanhToan() {
        return SoTheThanhToan;
    }
    public void setSoTheThanhToan(String SoTheThanhToan) {
        this.SoTheThanhToan = SoTheThanhToan;
    }
    public String getTenDayDu() {
        return TenDayDu;
    }
    public void setTenDayDu(String TenDayDu) {
        this.TenDayDu = TenDayDu;
    }
    public String getDiaChi() {
        return DiaChi;
    }
    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
}
