/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanlyraphim.entity.Phong;
import quanlyraphim.utils.XJdbc;

/**
 *
 * @author Tien
 */
public class PhongDAO extends QuanLyRapPhimDAO<Phong, String> {

    @Override
    public void insert(Phong entity) {
        String sql = "insert into Phong (MaPhong,SoPhong) values (?,?)";
        XJdbc.update(sql,
                entity.getMaPhong(),
                entity.getSoPhong());
    }

    @Override
    public void update(Phong entity) {
        String sql = "update Phong set SoPhong = ? where MaPhong = ?";
        XJdbc.update(sql,
                entity.getSoPhong(),
                entity.getMaPhong()
        );
    }

    @Override
    public void delete(String id) {
        String sql = "delete Phong where MaPhong = ?";
        XJdbc.update(sql, id);
    }

    @Override
    public Phong selectById(String id) {
        String sql = "select * from Phong where MaPhong = ?";
        List<Phong> list = this.selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Phong> selectAll() {
        String sql = "select * from Phong";
        return this.selectBySql(sql);
    }

    @Override
    protected List<Phong> selectBySql(String sql, Object... args) {
        List<Phong> list = new ArrayList<>();

        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    Phong entity = new Phong();
                    entity.setMaPhong(rs.getString("MaPhong"));
                    entity.setSoPhong(rs.getInt("SoPhong"));
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
