/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import quanlyraphim.utils.XJdbc;

/**
 *
 * @author Tien
 */
public class DoanhThuDAO {
    
    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public List<Object[]> getDSPhim() {
        String sql = "select * from fn_DSPhim()";
        String[] cols = {"MaPhim", "TenPhim", "TenLoaiPhim", "NgayBD","NgayKT"};
        return this.getListOfArray(sql, cols);
    }
    
    public List<Object[]> getTenPhim(String tenPhim) {
        String sql = "select * from  SeachTenPhim(?)";
        String[] cols = {"MaPhim", "NgayBD", "NgayKT"};
        return this.getListOfArray(sql, cols,tenPhim);
    }

}
