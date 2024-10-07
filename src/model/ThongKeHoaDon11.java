package model;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ThongKeHoaDon11 extends HoaDon11{
    private float DoanhThu;
    private int TongVe;
    public ThongKeHoaDon11(float DoanhThu, int TongVe, int id
            , LocalDateTime ThoiGianTao, KhachHang11 khachHang11
            , NhanVien11 nhanVien11, ArrayList<Ve11> ve11
            , ArrayList<HD_DV11> hd_dv11) {
        super(id, ThoiGianTao, khachHang11, nhanVien11, ve11, hd_dv11);
        this.DoanhThu = DoanhThu;
        this.TongVe = TongVe;
    }
    public float getDoanhThu() {
        return DoanhThu;
    }
    public void setDoanhThu(float DoanhThu) {
        this.DoanhThu = DoanhThu;
    }
    public int getTongVe() {
        return TongVe;
    }
    public void setTongVe(int TongVe) {
        this.TongVe = TongVe;
    }
    public Object[] toObject(){
        String fullname="None";
        if(super.getKhachHang11()!=null){
            fullname=super.getKhachHang11().getTenDayDu();
        }
        return new Object[]{
          super.getId(),fullname, TongVe, DoanhThu
        };
    }
}
