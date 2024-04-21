/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanlyraphim.entity.LoaiVe;
import quanlyraphim.utils.XJdbc;

/**
 *
 * @author Tien
 */
public class LoaiVeDAO extends QuanLyRapPhimDAO<LoaiVe, String> {

    @Override
    public void insert(LoaiVe entity) {
        String sql = "insert into LoaiVe (MaLoaiVe,TenLoaiVe,GiaVe) values (?,?,?)";
        XJdbc.update(sql,
                entity.getMaLoaiVe(),
                entity.getTenLoaiVe(),
                entity.getGiaVe());
    }

    @Override
    public void update(LoaiVe entity) {
        String sql = "update LoaiVe set TenLoaiVe = ?, GiaVe = ? where MaLoaiVe = ?";
        XJdbc.update(sql,
                entity.getTenLoaiVe(),
                entity.getGiaVe(),
                entity.getMaLoaiVe());
    }

    @Override
    public void delete(String id) {
        String sql = "delete LoaiVe where MaLoaiVe = ?";
    }

    @Override
    public LoaiVe selectById(String id) {
        String sql = "select * from LoaiVe where MaLoaiVe = ?";
        List<LoaiVe> list = this.selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<LoaiVe> selectAll() {
        String sql = "select * from LoaiVe";
        return this.selectBySql(sql);
    }

    @Override
    protected List<LoaiVe> selectBySql(String sql, Object... args) {
        List<LoaiVe> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = XJdbc.query(sql, args);
            try {
                while (rs.next()) {                    
                    LoaiVe entity = new LoaiVe();
                    entity.setMaLoaiVe(rs.getString("MaLoaiVe"));
                    entity.setTenLoaiVe(rs.getString("TenLoaiVe"));
                    entity.setGiaVe(rs.getFloat("GiaVe"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw  new RuntimeException(ex);
        }
        return list;
    }

}
