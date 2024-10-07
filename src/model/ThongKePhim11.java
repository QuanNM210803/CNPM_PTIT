package model;

public class ThongKePhim11 extends Phim11{
    private float DoanhThu;
    private int TongVe;
    public ThongKePhim11(float DoanhThu, int TongVe, int id
            , String Ten, String Loai, String NamSX, String MoTa) {
        super(id, Ten, Loai, NamSX, MoTa);
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
          super.getId(),super.getTen(),TongVe,DoanhThu
        };
    }
}
