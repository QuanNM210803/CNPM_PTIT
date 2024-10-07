package model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class HoaDon11 implements Serializable{
    private int id;
    private LocalDateTime ThoiGianTao;
    private KhachHang11 khachHang11;
    private NhanVien11 nhanVien11;
    private ArrayList<Ve11> ve11;
    private ArrayList<HD_DV11> hd_dv11;
    public HoaDon11(int id, LocalDateTime ThoiGianTao, KhachHang11 khachHang11
            , NhanVien11 nhanVien11, ArrayList<Ve11> ve11, ArrayList<HD_DV11> hd_dv11) {
        this.id = id;
        this.ThoiGianTao = ThoiGianTao;
        this.khachHang11 = khachHang11;
        this.nhanVien11 = nhanVien11;
        this.ve11 = ve11;
        this.hd_dv11 = hd_dv11;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDateTime getThoiGianTao() {
        return ThoiGianTao;
    }
    public void setThoiGianTao(LocalDateTime ThoiGianTao) {
        this.ThoiGianTao = ThoiGianTao;
    }
    public KhachHang11 getKhachHang11() {
        return khachHang11;
    }
    public void setKhachHang11(KhachHang11 khachHang11) {
        this.khachHang11 = khachHang11;
    }
    public NhanVien11 getNhanVien11() {
        return nhanVien11;
    }
    public void setNhanVien11(NhanVien11 nhanVien11) {
        this.nhanVien11 = nhanVien11;
    }
    public ArrayList<Ve11> getVe11() {
        return ve11;
    }
    public void setVe11(ArrayList<Ve11> ve11) {
        this.ve11 = ve11;
    }
    public ArrayList<HD_DV11> getHd_dv11() {
        return hd_dv11;
    }
    public void setHd_dv11(ArrayList<HD_DV11> hd_dv11) {
        this.hd_dv11 = hd_dv11;
    }
}
