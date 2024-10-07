package dao;

import java.util.List;
import model.ThongKeHoaDon11;
import model.ThongKePhim11;
import model.ThongKeSuatChieu11;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import model.DichVu11;
import model.GheNgoi11;
import model.HD_DV11;
import model.HoaDon11;
import model.KhachHang11;
import model.NhanVien11;
import model.Phim11;
import model.PhongChieu11;
import model.Rap11;
import model.SuatChieu11;
import model.SuatChieu_GheNgoi11;
import model.Ve11;

public class ThongKeDoanhThuCtr11 extends DAO{
    public ThongKeDoanhThuCtr11(){
        super();
    }
    public List<ThongKePhim11> getThongKePhim11(LocalDateTime startTime, LocalDateTime endTime) throws SQLException{
        String sql="SELECT * FROM tblphim11";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<Phim11> phim11=new ArrayList<>();
        while(rs.next()){
            Phim11 p=this.getPhim11(rs.getInt("id"));
            phim11.add(p);
        }
        String sqlDoanhThu="select sg.GiaVe,v.UuDai from cnpm_movie_48.tblsuatchieu11 as s \n" +
                            "join cnpm_movie_48.tblsuatchieu_ghengoi11 as sg \n" +
                            "join cnpm_movie_48.tblve11 as v \n" +
                            "join cnpm_movie_48.tblhoadon11 as hd\n" +
                            "on s.Phim11id=? and s.id=sg.SuatChieu11id \n" +
                            "and sg.DaDat=true and sg.id=v.SuatChieu_GheNgoi11id \n" +
                            "and v.HoaDon11id=hd.id \n" +
                            "and ? <= hd.ThoiGianTao and hd.ThoiGianTao<= ?";
        List<ThongKePhim11> thongKePhim11s=new ArrayList<>();
        for(Phim11 p:phim11){
            PreparedStatement psDoanhThu=con.prepareStatement(sqlDoanhThu);
            psDoanhThu.setInt(1, p.getId());
            psDoanhThu.setTimestamp(2, Timestamp.valueOf(startTime));
            psDoanhThu.setTimestamp(3, Timestamp.valueOf(endTime));
            ResultSet rsDoanhThu=psDoanhThu.executeQuery();
            float DoanhThu=0;
            int TongVe=0;
            while(rsDoanhThu.next()){
                TongVe++;
                DoanhThu+=rsDoanhThu.getFloat("GiaVe")*(100-rsDoanhThu.getFloat("UuDai"))/100;
            }
            ThongKePhim11 thongKePhim11=new ThongKePhim11(DoanhThu,TongVe
                    ,p.getId(),p.getTen(),p.getLoai(),p.getNamSX(),p.getMoTa());
            thongKePhim11s.add(thongKePhim11);
        }
        thongKePhim11s.sort(new Comparator<ThongKePhim11>(){
            public int compare(ThongKePhim11 a,ThongKePhim11 b){
                return -Float.compare(a.getDoanhThu(), b.getDoanhThu());
            }
        });
        return thongKePhim11s;
    }
    public List<ThongKeSuatChieu11> getThongKeSuatChieu11(
            LocalDateTime startTime, LocalDateTime endTime, int phim11id) throws SQLException{
        String sql="select * from cnpm_movie_48.tblsuatchieu11 where Phim11id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, phim11id);
        ResultSet rs=ps.executeQuery();
        List<SuatChieu11> suatChieu11s=new ArrayList<>();
        while(rs.next()){
            SuatChieu11 sc=this.getSuatChieu11(rs.getInt("id"));
            suatChieu11s.add(sc);
        }
        String sqlDoanhThu="select sg.GiaVe,v.UuDai from cnpm_movie_48.tblsuatchieu_ghengoi11 as sg \n" +
                            "join cnpm_movie_48.tblve11 as v\n" +
                            "join cnpm_movie_48.tblhoadon11 as hd\n" +
                            "on sg.SuatChieu11id=? and sg.id=v.SuatChieu_GheNgoi11id \n" +
                            "and sg.DaDat=true and v.HoaDon11id=hd.id \n" +
                            "and ? <= hd.ThoiGianTao and hd.ThoiGianTao<= ?";
        List<ThongKeSuatChieu11> thongKeSuatChieu11s=new ArrayList<>();
        for(SuatChieu11 sc:suatChieu11s){
            PreparedStatement psDoanhThu=con.prepareStatement(sqlDoanhThu);
            psDoanhThu.setInt(1, sc.getId());
            psDoanhThu.setTimestamp(2, Timestamp.valueOf(startTime));
            psDoanhThu.setTimestamp(3, Timestamp.valueOf(endTime));
            ResultSet rsDoanhThu=psDoanhThu.executeQuery();
            float DoanhThu=0;
            int TongVe=0;
            while(rsDoanhThu.next()){
                TongVe++;
                DoanhThu+=rsDoanhThu.getFloat("GiaVe")*(100-rsDoanhThu.getFloat("UuDai"))/100;
            }
            ThongKeSuatChieu11 thongKeSuatChieu11=new ThongKeSuatChieu11(DoanhThu,TongVe
                    ,sc.getId(),sc.getThoiGian(),sc.getPhim11(),sc.getPhongChieu11());
            thongKeSuatChieu11s.add(thongKeSuatChieu11);
        }
        thongKeSuatChieu11s.sort(new Comparator<ThongKeSuatChieu11>(){
            public int compare(ThongKeSuatChieu11 a, ThongKeSuatChieu11 b){
                return a.getThoiGian().compareTo(b.getThoiGian());
            }
        });
        return thongKeSuatChieu11s;
    }
    public List<ThongKeHoaDon11> getThongKeHoaDon11(LocalDateTime startTime
            , LocalDateTime endTime, int suatChieu11id) throws SQLException{
        String sql="select * from  cnpm_movie_48.tblhoadon11 as hd \n" +
                    "where hd.id in (select distinct(v.HoaDon11id) from cnpm_movie_48.tblve11 as v \n" +
                    "				join cnpm_movie_48.tblsuatchieu_ghengoi11 as sg\n" +
                    "				on sg.SuatChieu11id=? and sg.id=v.SuatChieu_GheNgoi11id and sg.DaDat=true) \n" +
                    "	and ? <= hd.ThoiGianTao and hd.ThoiGianTao<= ?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, suatChieu11id);
        ps.setTimestamp(2, Timestamp.valueOf(startTime));
        ps.setTimestamp(3, Timestamp.valueOf(endTime));
        ResultSet rs=ps.executeQuery();
        List<HoaDon11> hoaDon11s=new ArrayList<>();
        while(rs.next()){
            HoaDon11 hd=this.getHoaDon11(rs.getInt("id"));
            hoaDon11s.add(hd);
        }
        String sqlDoanhThu="select sg.GiaVe,v.UuDai from cnpm_movie_48.tblve11 as v\n" +
                            "join cnpm_movie_48.tblsuatchieu_ghengoi11 as sg\n" +
                            "on v.HoaDon11id=? and sg.id=v.SuatChieu_GheNgoi11id and sg.DaDat=true";
        List<ThongKeHoaDon11> thongKeHoaDon11s=new ArrayList<>();
        for(HoaDon11 hd:hoaDon11s){
            PreparedStatement psDoanhThu=con.prepareStatement(sqlDoanhThu);
            psDoanhThu.setInt(1, hd.getId());
            ResultSet rsDoanhThu=psDoanhThu.executeQuery();
            float DoanhThu=0;
            int TongVe=0;
            while(rsDoanhThu.next()){
                TongVe++;
                DoanhThu+=rsDoanhThu.getFloat("GiaVe")*(100-rsDoanhThu.getFloat("UuDai"))/100;
            }
            ThongKeHoaDon11 thongKeHoaDon11=new ThongKeHoaDon11(DoanhThu,TongVe
                    ,hd.getId()
                    ,hd.getThoiGianTao()
                    ,hd.getKhachHang11()
                    ,hd.getNhanVien11()
                    ,hd.getVe11()
                    ,hd.getHd_dv11());
            thongKeHoaDon11s.add(thongKeHoaDon11);
        }
        thongKeHoaDon11s.sort(new Comparator<ThongKeHoaDon11>(){
            public int compare(ThongKeHoaDon11 a, ThongKeHoaDon11 b){
                return a.getThoiGianTao().compareTo(b.getThoiGianTao());
            }
        });
        return thongKeHoaDon11s;
    }
    public Phim11 getPhim11(int phim11id) throws SQLException{
        String sql="select * from cnpm_movie_48.tblphim11 where id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, phim11id);
        ResultSet rs=ps.executeQuery();
        Phim11 phim11=new Phim11();
        while(rs.next()){
            phim11.setId(rs.getInt("id"));
            phim11.setTen(rs.getString("Ten"));
            phim11.setLoai(rs.getString("Loai"));
            phim11.setNamSX(rs.getString("NamSX"));
            phim11.setMoTa(rs.getString("MoTa"));
        }
        return phim11;
    }
    public Rap11 getRap11(int rap11id) throws SQLException{
        String sql="select * from cnpm_movie_48.tblrap11 where id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, rap11id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Rap11 rap11=new Rap11(rs.getInt("id"),
                    rs.getString("Ten"),
                    rs.getString("DiaChi"),
                    rs.getString("GioiThieu"));
            return rap11;
        }
        return null;
    }
    public PhongChieu11 getPhongChieu11(int phongChieu11id) throws SQLException{
        String sql="select * from cnpm_movie_48.tblphongchieu11 where id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, phongChieu11id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            PhongChieu11 phongChieu11=new PhongChieu11(rs.getInt("id")
                    ,rs.getString("DacDiem"),rs.getInt("SoLuongGhe"),
            this.getRap11(rs.getInt("Rap11id")));
            return phongChieu11;
        }
        return null;
    }
    public SuatChieu11 getSuatChieu11(int suatChieu11id) throws SQLException{
        String sql="select * from cnpm_movie_48.tblsuatchieu11 where id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, suatChieu11id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            SuatChieu11 suatChieu11=new SuatChieu11(rs.getInt("id"),
                        rs.getTimestamp("ThoiGian").toLocalDateTime(),
                        this.getPhim11(rs.getInt("Phim11id")),
                        this.getPhongChieu11(rs.getInt("PhongChieu11id")));
            return suatChieu11;
        }
        return null;
    }
    public KhachHang11 getKhachHang11(int khachHang11id) throws SQLException{
        String sql="select * from cnpm_movie_48.tblkhachhang11 where id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, khachHang11id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            KhachHang11 khachHang11= new KhachHang11(rs.getInt("id"),
                    rs.getString("SoTheThanhToan"),
                    rs.getString("TenDayDu"),
                    rs.getString("DiaChi"),
                    rs.getString("Email"));
            return khachHang11;
        }
        return null;
    }
    public NhanVien11 getNhanVien11(int nhanVien11id) throws SQLException{
        String sql="select * from cnpm_movie_48.tblnhanvien11 where id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, nhanVien11id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            NhanVien11 nhanVien11= new NhanVien11(rs.getInt("id"),
                    rs.getString("Email"),
                    rs.getString("MatKhau"),
                    rs.getString("TenDayDu"),
                    rs.getString("VaiTro"));
            return nhanVien11;
        }
        return null;
    }
    public DichVu11 getDichVu11(int dichVu11id) throws SQLException{
        String sql="select * from cnpm_movie_48.tbldichvu11 where id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, dichVu11id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            DichVu11 dichVu11= new DichVu11(rs.getInt("id"),
                    rs.getString("Ten"),
                    rs.getFloat("DonGia"));
            return dichVu11;
        }
        return null;
    }
    public HD_DV11 getHd_dv11(int hd_dv11id) throws SQLException{
        String sql="select * from cnpm_movie_48.tblhd_dv11 where id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, hd_dv11id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            HD_DV11 hd_dv11= new HD_DV11(rs.getInt("id"),
                    rs.getInt("SoLuong"),
                    rs.getFloat("UuDai"),
                    this.getDichVu11(rs.getInt("DichVu11id")));
            return hd_dv11;
        }
        return null;
    }
    public GheNgoi11 getGheNgoi11(int gheNgoi11id) throws SQLException{
        String sql="select * from cnpm_movie_48.tblghengoi11 where id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, gheNgoi11id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            GheNgoi11 gheNgoi11= new GheNgoi11(rs.getInt("id"),
                    rs.getString("SoGhe"),
                    this.getPhongChieu11(rs.getInt("PhongChieu11id")));
            return gheNgoi11;
        }
        return null;
    }
    public SuatChieu_GheNgoi11 getSuatChieu_GheNgoi11(int suatChieu_GheNgoi11id) throws SQLException{
        String sql="select * from cnpm_movie_48.tblsuatchieu_ghengoi11 where id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, suatChieu_GheNgoi11id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            SuatChieu_GheNgoi11 suatChieu_GheNgoi11= new SuatChieu_GheNgoi11(rs.getInt("id"),
                    rs.getFloat("GiaVe"),
                    rs.getBoolean("DaDat"),
                    this.getSuatChieu11(rs.getInt("SuatChieu11id")),
                    this.getGheNgoi11(rs.getInt("GheNgoi11id")));
            return suatChieu_GheNgoi11;
        }
        return null;
    }
    public Ve11 getVe11(int ve11id) throws SQLException{
        String sql="select * from cnpm_movie_48.tblve11 where id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, ve11id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Ve11 ve11= new Ve11(rs.getInt("id"),
                    rs.getFloat("UuDai"),
                    this.getSuatChieu_GheNgoi11(rs.getInt("SuatChieu_GheNgoi11id")));
            return ve11;
        }
        return null;
    }
    public HoaDon11 getHoaDon11(int hoaDon11id) throws SQLException{
        String sql="select * from cnpm_movie_48.tblhoadon11 where id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, hoaDon11id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            ArrayList<Ve11> ve11s=new ArrayList<>();
            String sqlVe11="select * from cnpm_movie_48.tblve11 where HoaDon11id=?";
            PreparedStatement psVe11=con.prepareStatement(sqlVe11);
            psVe11.setInt(1, hoaDon11id);
            ResultSet rsVe11=psVe11.executeQuery();
            while(rsVe11.next()){
                Ve11 ve11=this.getVe11(rsVe11.getInt("id"));
                ve11s.add(ve11);
            }
            
            ArrayList<HD_DV11> hd_dv11s=new ArrayList<>();
            String sqlHD_DV11="select * from cnpm_movie_48.tblhd_dv11 where HoaDon11id=?";
            PreparedStatement psHD_DV11=con.prepareStatement(sqlHD_DV11);
            psHD_DV11.setInt(1, hoaDon11id);
            ResultSet rsHD_DV11=psHD_DV11.executeQuery();
            while(rsHD_DV11.next()){
                HD_DV11 hd_dv11=this.getHd_dv11(rsHD_DV11.getInt("id"));
                hd_dv11s.add(hd_dv11);
            }
            KhachHang11 khachHang11;
            if(rs.getInt("KhachHang11id")==0){
                khachHang11=null;
            }else{
                khachHang11=this.getKhachHang11(rs.getInt("KhachHang11id"));
            }
            HoaDon11 hoaDon11= new HoaDon11(rs.getInt("id"),
                    rs.getTimestamp("ThoiGianTao").toLocalDateTime(),
                    khachHang11,
                    this.getNhanVien11(rs.getInt("NhanVien11id")),
                    ve11s,
                    hd_dv11s);
            return hoaDon11;
        }
        return null;
    }
}
