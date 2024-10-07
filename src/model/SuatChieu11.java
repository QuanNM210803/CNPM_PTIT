package model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class SuatChieu11 implements Serializable{
    private int id;
    private LocalDateTime ThoiGian;
    private Phim11 phim11;
    private PhongChieu11 phongChieu11;
    public SuatChieu11(int id, LocalDateTime ThoiGian
            , Phim11 phim11, PhongChieu11 phongChieu11) {
        this.id = id;
        this.ThoiGian = ThoiGian;
        this.phim11 = phim11;
        this.phongChieu11 = phongChieu11;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDateTime getThoiGian() {
        return ThoiGian;
    }
    public void setThoiGian(LocalDateTime ThoiGian) {
        this.ThoiGian = ThoiGian;
    }
    public Phim11 getPhim11() {
        return phim11;
    }
    public void setPhim11(Phim11 phim11) {
        this.phim11 = phim11;
    }
    public PhongChieu11 getPhongChieu11() {
        return phongChieu11;
    }
    public void setPhongChieu11(PhongChieu11 phongChieu11) {
        this.phongChieu11 = phongChieu11;
    }
}
