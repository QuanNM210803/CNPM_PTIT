package model;
import java.io.Serializable;

public class SuatChieu_GheNgoi11 implements Serializable{
    private int id;
    private float GiaVe;
    private boolean DaDat;
    private SuatChieu11 suatChieu11;
    private GheNgoi11 gheNgoi11;
    public SuatChieu_GheNgoi11(int id, float GiaVe, boolean DaDat
            , SuatChieu11 suatChieu11, GheNgoi11 gheNgoi11) {
        this.id = id;
        this.GiaVe = GiaVe;
        this.DaDat = DaDat;
        this.suatChieu11 = suatChieu11;
        this.gheNgoi11 = gheNgoi11;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getGiaVe() {
        return GiaVe;
    }
    public void setGiaVe(float GiaVe) {
        this.GiaVe = GiaVe;
    }
    public boolean isDaDat() {
        return DaDat;
    }
    public void setDaDat(boolean DaDat) {
        this.DaDat = DaDat;
    }
    public SuatChieu11 getSuatChieu11() {
        return suatChieu11;
    }
    public void setSuatChieu11(SuatChieu11 suatChieu11) {
        this.suatChieu11 = suatChieu11;
    }
    public GheNgoi11 getGheNgoi11() {
        return gheNgoi11;
    }
    public void setGheNgoi11(GheNgoi11 gheNgoi11) {
        this.gheNgoi11 = gheNgoi11;
    }
}
