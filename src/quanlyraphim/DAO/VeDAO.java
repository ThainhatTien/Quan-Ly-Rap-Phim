/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.DAO;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import quanlyraphim.entity.Ve;
import quanlyraphim.utils.XJdbc;

/**
 *
 * @author Tien
 */
public class VeDAO extends QuanLyRapPhimDAO<Ve, String> {

    @Override
    public void insert(Ve entity) {
        String sql = "insert into Ve (MaVe,SoGhe,MaLoaiVe) values (?,?,?)";
        XJdbc.update(sql,
                entity.getMaVe(),
                entity.getSoGhe(),
                entity.getMaLoaiVe());
    }

    @Override
    public void update(Ve entity) {
        String sql = "update Ve set SoGhe = ?, MaLoaiVe = ? where MaVe =? ";
        XJdbc.update(sql,
                entity.getSoGhe(),
                entity.getMaLoaiVe(),
                entity.getMaVe());
    }

    @Override
    public void delete(String id) {
        String sql = "delete from Ve where MaVe = ?";
        XJdbc.update(sql, id);
    }

    @Override
    public Ve selectById(String id) {
        String sql = "select * from Ve where MaVe = ?";
        List<Ve> list = this.selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Ve> selectAll() {
        String sql = "select * from Ve";
        return this.selectBySql(sql);
    }

    @Override
    protected List<Ve> selectBySql(String sql, Object... args) {
        List<Ve> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {                    
                    Ve ve = new Ve();
                    ve.setMaVe(rs.getString("MaVe"));
                    ve.setSoGhe(rs.getString("SoGhe"));
                    ve.setMaLoaiVe(rs.getString("MaLoaiVe"));
                    list.add(ve);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

}
