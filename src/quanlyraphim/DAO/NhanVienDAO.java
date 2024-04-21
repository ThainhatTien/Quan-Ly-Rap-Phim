/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.DAO;

import quanlyraphim.entity.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanlyraphim.utils.XJdbc;

/**
 *
 * @author ADMIN
 */
//public class NhanVienDAO {
//    public static List<NhanVien> ls = new ArrayList<>();
//    
//        public int add(NhanVien nv){
//            Connection conn = null;
//            PreparedStatement sttm = null;
//            try {
//                String sSQL = "insert into TaiKhoan(MaNguoiDung,TenNguoiDung,MatKhau) values (?,?,?)";
//                conn = DatabaseUtils.getDBConnect();
//                sttm = conn.prepareStatement(sSQL);
//                sttm.setString(1, nv.getMaNV());
//                sttm.setString(2, nv.getTenNV());
//                sttm.setString(3, nv.getMatKhau());
//                if(sttm.executeUpdate()>0) {
//                System.out.println("Thêm thành công!!!");
//                return 1;
//                }
//            } catch (Exception e) {
//                System.out.println("Error:"+e.toString());
//            }finally{
//                try {
//                    conn.close();
//                    sttm.close();
//                } catch (Exception e) {
//                }
//            }
//            return -1;
//        }
//
//        public int updateNhanVienByID(NhanVien nv){
//            Connection conn = null;
//            PreparedStatement sttm = null;
//            try {
//                String sSQL = "update TaiKhoan set TenNguoiDung = ?, MatKhau = ? where MaNguoiDung = ?";
//                conn = DatabaseUtils.getDBConnect();
//                sttm = conn.prepareStatement(sSQL);
//                sttm.setString(1, nv.getTenNV());
//                sttm.setString(2, nv.getMatKhau());
//                sttm.setString(3, nv.getMaNV());
//                if(sttm.executeUpdate()>0) {
//                    System.out.println("Sua thành công!!!");
//                    return 1;
//                }
//            } catch (Exception e) {
//                System.out.println("Error:"+e.toString());
//            }finally{
//                try {
//                    conn.close();
//                    sttm.close();
//                } catch (Exception e) {
//                }
//            }
//            return -1;
//        }
//        
//        public int delNhanVienByID(String MaNV){
//        Connection conn = null;
//        PreparedStatement sttm = null;
//            try {
//                String sSQL = "delete TaiKhoan where MaNguoiDung = ?";
//                conn = DatabaseUtils.getDBConnect();
//                sttm = conn.prepareStatement(sSQL);
//                sttm.setString(1, MaNV);
//                if(sttm.executeUpdate()>0){
//                    System.out.println("Xóa thành công!!!");
//                    return 1;
//                }
//            } catch (Exception e) {
//                System.out.println("Error:"+e.toString());
//            }finally{
//                try {
//                    conn.close();
//                    sttm.close();
//                } catch (Exception e) {
//                }
//            }
//            return -1;
//        }
//            
//
////            
////            
////            if(sttm.executeUpdate()>0) {
////                System.out.println("Xóa thành công!!!");
////                return 1;
////            }
////        } catch (Exception e) {
////            System.out.println("Error:"+e.toString());
////        }finally{
////            try {
////                conn.close();
////                sttm.close();
////            } catch (Exception e) {
////            }
////        }
////        return -1; // nếu thêm không thành công
////    }
//
//    public List<NhanVien> getAllNhanVien(){
//        List<NhanVien> ls = new ArrayList<>();
//        Connection conn = null;
//        Statement sttm = null;
//        ResultSet rs = null;
//        try {
//            String sSQL = "select * from TaiKhoan";
//            conn = DatabaseUtils.getDBConnect();
//            sttm = conn.createStatement();
//            rs = sttm.executeQuery(sSQL);
//            while(rs.next()){
//                  NhanVien nv = new NhanVien();
//                  nv.setMaNV(rs.getString(1));
//                  nv.setTenNV(rs.getString(2));
//                  nv.setMatKhau(rs.getString(3));
//                  ls.add(nv);
//            }
//        } catch (Exception e) {
//            System.out.println("Error:"+e.toString());
//        }finally{
//            try {
//                conn.close();
//                sttm.close();
//            } catch (Exception e) {
//            }
//        }
//        return ls;
//    }
//    public NhanVien getNhanVienByID(String maSV){
//        Connection conn = null;
//        PreparedStatement sttm = null;
//        ResultSet rs = null;
//        NhanVien nv = new NhanVien();
//        try {
//            String sSQL = "select * from TaiKhoan where MaNguoiDung = ?";
//            conn = DatabaseUtils.getDBConnect();
//            sttm = conn.prepareStatement(sSQL);
//            sttm.setString(1, maSV);
//            rs = sttm.executeQuery();
//            while(rs.next()){
//                nv.setMaNV(rs.getString(1));
//                nv.setTenNV(rs.getString(2));
//                nv.setMatKhau(rs.getString(3));
//                return nv;
//            }
//        } catch (Exception e) {
//            System.out.println("Error:"+e.toString());
//        }finally{
//            try {
//                conn.close();
//                rs.close();
//                sttm.close();
//            } catch (Exception e) {
//            }
//        }
//        return null;
//    }
//}
public class NhanVienDAO extends QuanLyRapPhimDAO<NhanVien, String> {

    public void insert(NhanVien model) {
        String sql = "insert into NhanVien (MaNV,TenNV,MatKhau,NgaySinh,DiaChi,SoDT,GioiTinh,VaiTro) values (?,?,?,?,?,?,?,?)";
        XJdbc.update(sql,
                model.getMaNV(),
                model.getTenNV(),
                model.getMatKhau(),
                model.getNgaySinh(),
                model.getDiaChi(),
                model.getSoDT(),
                model.getGioiTinh(),
                model.getVaiTro()
        );
    }

    public void update(NhanVien model) {
        String sql = "update NhanVien set TenNV = ? , MatKhau = ?, NgaySinh = ?, DiaChi = ?, SoDT=?, GioiTinh = ?,VaiTro = ? where MaNV = ?";
        XJdbc.update(sql,
                model.getTenNV(),
                model.getMatKhau(),
                model.getNgaySinh(),
                model.getDiaChi(),
                model.getSoDT(),
                model.getGioiTinh(),
                model.getVaiTro(),
                model.getMaNV()
        );
    }

    public void delete(String MaNV) {
        String sql = "delete NhanVien where MaNV = ?";
        XJdbc.update(sql, MaNV);
    }

    public List<NhanVien> selectAll() {
        String sql = "select * from NhanVien";
        return this.selectBySql(sql);
    }

    public NhanVien selectById(String manv) {
        String sql = "select * from NhanVien where MaNV = ?";
        List<NhanVien> list = this.selectBySql(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    NhanVien entity = new NhanVien();
                    entity.setMaNV(rs.getString("MaNV"));
                    entity.setTenNV(rs.getString("TenNV"));
                    entity.setMatKhau(rs.getString("MatKhau"));
                    entity.setNgaySinh(rs.getDate("NgaySinh"));
                    entity.setDiaChi(rs.getString("DiaChi"));
                    entity.setSoDT(rs.getString("SoDT"));
                    entity.setGioiTinh(rs.getString("GioiTinh"));
                    entity.setVaiTro(rs.getString("VaiTro"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
}
