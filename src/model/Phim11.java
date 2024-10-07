package model;
import java.io.Serializable;
public class Phim11 implements Serializable{
    private int id;
    private String Ten;
    private String Loai;
    private String NamSX;
    private String MoTa; 
    public Phim11(){
        super();
    }
    public Phim11(int id, String Ten, String Loai, String NamSX, String MoTa) {
        this.id = id;
        this.Ten = Ten;
        this.Loai = Loai;
        this.NamSX = NamSX;
        this.MoTa = MoTa;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTen() {
        return Ten;
    }
    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    public String getLoai() {
        return Loai;
    }
    public void setLoai(String Loai) {
        this.Loai = Loai;
    }
    public String getNamSX() {
        return NamSX;
    }
    public void setNamSX(String NamSX) {
        this.NamSX = NamSX;
    }
    public String getMoTa() {
        return MoTa;
    }
    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
}
