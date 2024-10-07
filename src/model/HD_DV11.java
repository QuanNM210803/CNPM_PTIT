package model;
import java.io.Serializable;

public class HD_DV11 implements Serializable{
    private int id;
    private int SoLuong;
    private float UuDai;
    private DichVu11 dichVu11;
    public HD_DV11(int id, int SoLuong, float UuDai, DichVu11 dichVu11) {
        this.id = id;
        this.SoLuong = SoLuong;
        this.UuDai = UuDai;
        this.dichVu11 = dichVu11;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSoLuong() {
        return SoLuong;
    }
    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    public float getUuDai() {
        return UuDai;
    }
    public void setUuDai(float UuDai) {
        this.UuDai = UuDai;
    }
    public DichVu11 getDichVu11() {
        return dichVu11;
    }
    public void setDichVu11(DichVu11 dichVu11) {
        this.dichVu11 = dichVu11;
    }
}
