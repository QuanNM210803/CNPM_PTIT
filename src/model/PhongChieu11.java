package model;
import java.io.Serializable;

public class PhongChieu11 implements Serializable{
    private int id;
    private String DacDiem;
    private int SoLuongGhe;
    private Rap11 rap11;
    public PhongChieu11(int id, String DacDiem, int SoLuongGhe, Rap11 rap11) {
        this.id = id;
        this.DacDiem = DacDiem;
        this.SoLuongGhe = SoLuongGhe;
        this.rap11 = rap11;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDacDiem() {
        return DacDiem;
    }
    public void setDacDiem(String DacDiem) {
        this.DacDiem = DacDiem;
    }
    public int getSoLuongGhe() {
        return SoLuongGhe;
    }
    public void setSoLuongGhe(int SoLuongGhe) {
        this.SoLuongGhe = SoLuongGhe;
    }
    public Rap11 getRap11() {
        return rap11;
    }
    public void setRap11(Rap11 rap11) {
        this.rap11 = rap11;
    }
}
