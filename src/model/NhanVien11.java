package model;
import java.io.Serializable;

public class NhanVien11 implements Serializable{
    private int id;
    private String Email;
    private String MatKhau;
    private String TenDayDu;
    private String VaiTro;
    public NhanVien11(int id, String Email, String MatKhau, String TenDayDu, String VaiTro) {
        this.id = id;
        this.Email = Email;
        this.MatKhau = MatKhau;
        this.TenDayDu = TenDayDu;
        this.VaiTro = VaiTro;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getMatKhau() {
        return MatKhau;
    }
    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }
    public String getTenDayDu() {
        return TenDayDu;
    }
    public void setTenDayDu(String TenDayDu) {
        this.TenDayDu = TenDayDu;
    }
    public String getVaiTro() {
        return VaiTro;
    }
    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }
}
