package model;
import java.io.Serializable;

public class GheNgoi11 implements Serializable{
    private int id;
    private String SoGhe;
    private PhongChieu11 phongChieu11;
    public GheNgoi11(int id, String SoGhe, PhongChieu11 phongChieu11) {
        this.id = id;
        this.SoGhe = SoGhe;
        this.phongChieu11 = phongChieu11;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSoGhe() {
        return SoGhe;
    }
    public void setSoGhe(String SoGhe) {
        this.SoGhe = SoGhe;
    }
    public PhongChieu11 getPhongChieu11() {
        return phongChieu11;
    }
    public void setPhongChieu11(PhongChieu11 phongChieu11) {
        this.phongChieu11 = phongChieu11;
    }
}
