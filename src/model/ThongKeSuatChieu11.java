package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ThongKeSuatChieu11 extends SuatChieu11{
    private float DoanhThu;
    private int TongVe;
    public ThongKeSuatChieu11(float DoanhThu, int TongVe, int id
            , LocalDateTime ThoiGian, Phim11 phim11, PhongChieu11 phongChieu11) {
        super(id, ThoiGian, phim11, phongChieu11);
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
        return new Object[]{
          super.getId(),DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
                  .format(super.getThoiGian()), TongVe, DoanhThu
        };
    }
}
