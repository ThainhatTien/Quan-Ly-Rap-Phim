/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanlyraphim.entity.LoaiPhim;
import quanlyraphim.utils.XJdbc;

/**
 *
 * @author Tien
 */
public class LoaiPhimDAO extends QuanLyRapPhimDAO<LoaiPhim, String> {

    @Override
    public void insert(LoaiPhim entity) {
        String sql = "insert into LoaiPhim (MaLoaiPhim,TenLoaiPhim) values (?,?)";
        XJdbc.update(sql,
                entity.getMaLoaiPhim(),
                entity.getTenLoaiPhim());
    }

    @Override
    public void update(LoaiPhim entity) {
        String sql = "update LoaiPhim set TenLoaiPhim = ? where MaLoaiPhim = ?";
        XJdbc.update(sql,
                entity.getTenLoaiPhim(),
                entity.getMaLoaiPhim());
    }

    @Override
    public void delete(String id) {
        String sql = "delete LoaiPhim where MaLoaiPhim = ?";
    }

    @Override
    public LoaiPhim selectById(String id) {
        String sql = "select * from LoaiPhim where MaLoaiPhim = ?";
        List<LoaiPhim> list = this.selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<LoaiPhim> selectAll() {
        String sql = "select * from LoaiPhim";
        return this.selectBySql(sql);
    }

    @Override
    protected List<LoaiPhim> selectBySql(String sql, Object... args) {
        List<LoaiPhim> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = XJdbc.query(sql, args);
            try {
                while (rs.next()) {
                    LoaiPhim entity = new LoaiPhim();
                    entity.setMaLoaiPhim(rs.getString("MaLoaiPhim"));
                    entity.setTenLoaiPhim(rs.getString("TenLoaiPhim"));
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
