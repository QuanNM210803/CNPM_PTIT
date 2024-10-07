package model;
import java.io.Serializable;

public class Ve11 implements Serializable{
    private int id;
    private float UuDai;
    private SuatChieu_GheNgoi11 suatChieu_GheNgoi11;
    public Ve11(int id, float UuDai, SuatChieu_GheNgoi11 suatChieu_GheNgoi11) {
        this.id = id;
        this.UuDai = UuDai;
        this.suatChieu_GheNgoi11 = suatChieu_GheNgoi11;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getUuDai() {
        return UuDai;
    }
    public void setUuDai(float UuDai) {
        this.UuDai = UuDai;
    }
    public SuatChieu_GheNgoi11 getSuatChieu_GheNgoi11() {
        return suatChieu_GheNgoi11;
    }
    public void setSuatChieu_GheNgoi11(SuatChieu_GheNgoi11 suatChieu_GheNgoi11) {
        this.suatChieu_GheNgoi11 = suatChieu_GheNgoi11;
    }
}
