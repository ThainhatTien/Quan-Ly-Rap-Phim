/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanlyraphim.entity.DichVu;
import quanlyraphim.utils.XJdbc;

/**
 *
 * @author Tien
 */
public class DichVuDAO extends QuanLyRapPhimDAO<DichVu, String> {

    @Override
    public void insert(DichVu entity) {
        String sql = "insert into DichVu (Ma,Ten,Gia) values (?,?,?)";
        XJdbc.update(sql,
                entity.getMa(),
                entity.getTen(),
                entity.getGia());
    }

    @Override
    public void update(DichVu entity) {
        String sql = "update DichVu set Ten= ?, Gia = ? where Ma = ?";
        XJdbc.update(sql,
                entity.getTen(),
                entity.getGia(),
                entity.getMa());
    }

    @Override
    public void delete(String id) {
        String sql = "delete DichVu where Ma = ?";
        XJdbc.update(sql, id);
    }

    @Override
    public DichVu selectById(String id) {
        String sql = "select * from DichVu where Ma = ?";
        List<DichVu> list = this.selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<DichVu> selectAll() {
        String sql = "select * from DichVu";
        return this.selectBySql(sql);
    }

    @Override
    protected List<DichVu> selectBySql(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    DichVu entity = new DichVu();
                    entity.setMa(rs.getString("Ma"));
                    entity.setTen(rs.getString("Ten"));
                    entity.setGia(rs.getFloat("Gia"));
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
