/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlyraphim.ui;

import quanlyraphim.utils.Auth;
import quanlyraphim.utils.MsgBox;
import quanlyraphim.utils.XImage;

/**
 *
 * @author Admin
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form ListPhim
     */
    public Main() {
        initComponents();
        init();
    }

    void init() {
        setLocationRelativeTo(null);
        setTitle("Quản lý rạp phim");
        displayUserInfo();
    }

    Boolean checkThongKe() {
        if (Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền truy cập vào chức năng này !");
            jQuanLy.setEnabled(false);
            return false;
        }
        return true;
    }

    void displayUserInfo() {
        String userID = Auth.user.getMaNV();
        String role = Auth.user.getVaiTro();
        lblTenNV.setText("Mã Nhân Viên: " + userID);
        lblChucVu.setText("Chức vụ: " + role);
        if (Auth.isManager()) {
            jQuanLy.setEnabled(false);
            jThongKe.setEnabled(false);
        }
    }

    void checkQuanLy() {
        if (Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền truy cập vào chức năng này !");
            jQuanLy.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHinh = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        lblChucVu = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        jPhim = new javax.swing.JMenu();
        jLichChieu = new javax.swing.JMenu();
        jVe = new javax.swing.JMenu();
        jQuanLy = new javax.swing.JMenu();
        jQuanLyNhanVien = new javax.swing.JMenu();
        jQuanLyLuongNhanVien = new javax.swing.JMenu();
        jQuanLyLichChieu = new javax.swing.JMenu();
        jQuanLyPhim = new javax.swing.JMenu();
        jQuanLyPhong = new javax.swing.JMenu();
        jQuanLyLoaiVe = new javax.swing.JMenu();
        jQuanLyVe = new javax.swing.JMenu();
        jQuanLyLoaiPhim = new javax.swing.JMenu();
        jQuanLyThucAnNuocUong = new javax.swing.JMenu();
        jAbout = new javax.swing.JMenu();
        jThongKe = new javax.swing.JMenu();
        jTaiKhoan = new javax.swing.JMenu();
        jDangXuat = new javax.swing.JMenu();
        jDoiMatKhau = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(900, 1000));

        lblHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.jpg"))); // NOI18N

        lblTenNV.setText("jLabel1");
        lblTenNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblChucVu.setText("jLabel2");
        lblChucVu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPhim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-movies.gif"))); // NOI18N
        jPhim.setText("Phim");
        jPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPhimMouseClicked(evt);
            }
        });
        jPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPhimActionPerformed(evt);
            }
        });
        Menu.add(jPhim);

        jLichChieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-movie-30.png"))); // NOI18N
        jLichChieu.setText("Lịch Chiếu");
        jLichChieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLichChieuMouseClicked(evt);
            }
        });
        Menu.add(jLichChieu);

        jVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cinema-ticket-30.png"))); // NOI18N
        jVe.setText("Vé");
        jVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jVeMouseClicked(evt);
            }
        });
        Menu.add(jVe);

        jQuanLy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-operating-system-30.png"))); // NOI18N
        jQuanLy.setText("Quản Lý");
        jQuanLy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jQuanLyMouseClicked(evt);
            }
        });

        jQuanLyNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Person-Male-Light-icon-16.png"))); // NOI18N
        jQuanLyNhanVien.setText("Quản Lý Nhân Viên");
        jQuanLyNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jQuanLyNhanVienMouseClicked(evt);
            }
        });
        jQuanLy.add(jQuanLyNhanVien);

        jQuanLyLuongNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Actions-document-edit-icon-16.png"))); // NOI18N
        jQuanLyLuongNhanVien.setText("Quản Lý Lương");
        jQuanLyLuongNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jQuanLyLuongNhanVienMouseClicked(evt);
            }
        });
        jQuanLy.add(jQuanLyLuongNhanVien);

        jQuanLyLichChieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lc.png"))); // NOI18N
        jQuanLyLichChieu.setText(" Quản Lý Lịch Chiếu");
        jQuanLyLichChieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jQuanLyLichChieuMouseClicked(evt);
            }
        });
        jQuanLy.add(jQuanLyLichChieu);

        jQuanLyPhim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/phim.png"))); // NOI18N
        jQuanLyPhim.setText("Quản Lý Phim");
        jQuanLyPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jQuanLyPhimMouseClicked(evt);
            }
        });
        jQuanLy.add(jQuanLyPhim);

        jQuanLyPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/phong.png"))); // NOI18N
        jQuanLyPhong.setText(" Quản Lý Phòng");
        jQuanLyPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jQuanLyPhongMouseClicked(evt);
            }
        });
        jQuanLy.add(jQuanLyPhong);

        jQuanLyLoaiVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loaive.png"))); // NOI18N
        jQuanLyLoaiVe.setText("Quản Lý Loại Vé");
        jQuanLyLoaiVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jQuanLyLoaiVeMouseClicked(evt);
            }
        });
        jQuanLy.add(jQuanLyLoaiVe);

        jQuanLyVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ve.png"))); // NOI18N
        jQuanLyVe.setText("Quản Lý Vé");
        jQuanLyVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jQuanLyVeMouseClicked(evt);
            }
        });
        jQuanLy.add(jQuanLyVe);

        jQuanLyLoaiPhim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loaiphim.png"))); // NOI18N
        jQuanLyLoaiPhim.setText("Quản Lý Loại Phim");
        jQuanLyLoaiPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jQuanLyLoaiPhimMouseClicked(evt);
            }
        });
        jQuanLy.add(jQuanLyLoaiPhim);

        jQuanLyThucAnNuocUong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/thucannuocuong.png"))); // NOI18N
        jQuanLyThucAnNuocUong.setText(" Quản Lý Dịch Vụ");
        jQuanLyThucAnNuocUong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jQuanLyThucAnNuocUongMouseClicked(evt);
            }
        });
        jQuanLy.add(jQuanLyThucAnNuocUong);

        Menu.add(jQuanLy);

        jAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-user-30.png"))); // NOI18N
        jAbout.setText("About");
        jAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAboutMouseClicked(evt);
            }
        });
        Menu.add(jAbout);

        jThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/doanhthu.png"))); // NOI18N
        jThongKe.setText("Doanh Thu");
        jThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jThongKeMouseClicked(evt);
            }
        });
        Menu.add(jThongKe);

        jTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        jTaiKhoan.setText("Tài Khoản");
        jTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTaiKhoanMouseClicked(evt);
            }
        });

        jDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dX.png"))); // NOI18N
        jDangXuat.setText("Đăng Xuất");
        jDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDangXuatMouseClicked(evt);
            }
        });
        jDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDangXuatActionPerformed(evt);
            }
        });
        jTaiKhoan.add(jDangXuat);

        jDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/password.png"))); // NOI18N
        jDoiMatKhau.setText("Đổi Mật Khẩu");
        jDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDoiMatKhauMouseClicked(evt);
            }
        });
        jDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDoiMatKhauActionPerformed(evt);
            }
        });
        jTaiKhoan.add(jDoiMatKhau);

        Menu.add(jTaiKhoan);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 508, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChucVu))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPhimMouseClicked
        // TODO add your handling code here:
        new ListPhim().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPhimMouseClicked

    private void jPhimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPhimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPhimActionPerformed

    private void jLichChieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLichChieuMouseClicked
        // TODO add your handling code here:
        new LichChieuPhim().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLichChieuMouseClicked

    private void jQuanLyLuongNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jQuanLyLuongNhanVienMouseClicked
        // TODO add your handling code here:
        new QuanLyLuongJDialog().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jQuanLyLuongNhanVienMouseClicked

    private void jTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTaiKhoanMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTaiKhoanMouseClicked

    private void jAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAboutMouseClicked
        // TODO add your handling code here:
        new About().setVisible(true);
    }//GEN-LAST:event_jAboutMouseClicked

    private void jQuanLyNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jQuanLyNhanVienMouseClicked
        // TODO add your handling code here:
        new QuanLyNhanVien().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jQuanLyNhanVienMouseClicked

    private void jThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jThongKeMouseClicked
        // TODO add your handling code here:
        if (checkThongKe()) {
            new DoanhThu().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jThongKeMouseClicked

    private void jQuanLyLichChieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jQuanLyLichChieuMouseClicked
        // TODO add your handling code here:
        new LichChieuPhim().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jQuanLyLichChieuMouseClicked

    private void jQuanLyPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jQuanLyPhimMouseClicked
        // TODO add your handling code here:
        new QuanLyPhimJDiaLog().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jQuanLyPhimMouseClicked

    private void jQuanLyPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jQuanLyPhongMouseClicked
        // TODO add your handling code here:
        new QuanLyPhongJDialog(this, true).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jQuanLyPhongMouseClicked

    private void jQuanLyLoaiVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jQuanLyLoaiVeMouseClicked
        // TODO add your handling code here:
        new QuanLyLoaiVeJDialog(this, true).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jQuanLyLoaiVeMouseClicked

    private void jQuanLyVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jQuanLyVeMouseClicked
        // TODO add your handling code here:
        new QuanLyVe().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jQuanLyVeMouseClicked

    private void jVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jVeMouseClicked
        // TODO add your handling code here:
        new QuanLyVe().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jVeMouseClicked

    private void jDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDangXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDangXuatActionPerformed

    private void jDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDoiMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDoiMatKhauActionPerformed

    private void jDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDoiMatKhauMouseClicked
        // TODO add your handling code here:
        new DoiMatKhauJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_jDoiMatKhauMouseClicked

    private void jDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDangXuatMouseClicked
        // TODO add your handling code here:
        new DangNhap().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jDangXuatMouseClicked

    private void jQuanLyLoaiPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jQuanLyLoaiPhimMouseClicked
        // TODO add your handling code here:
        new QuanLyLoaiPhimJDialog(this, true).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jQuanLyLoaiPhimMouseClicked

    private void jQuanLyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jQuanLyMouseClicked
        // TODO add your handling code here:
        checkQuanLy();
    }//GEN-LAST:event_jQuanLyMouseClicked

    private void jQuanLyThucAnNuocUongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jQuanLyThucAnNuocUongMouseClicked
        // TODO add your handling code here:
        new QuanLyDichVuJDialog(this, true).setVisible(true);
        dispose();
    }//GEN-LAST:event_jQuanLyThucAnNuocUongMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu jAbout;
    private javax.swing.JMenu jDangXuat;
    private javax.swing.JMenu jDoiMatKhau;
    private javax.swing.JMenu jLichChieu;
    private javax.swing.JMenu jPhim;
    private javax.swing.JMenu jQuanLy;
    private javax.swing.JMenu jQuanLyLichChieu;
    private javax.swing.JMenu jQuanLyLoaiPhim;
    private javax.swing.JMenu jQuanLyLoaiVe;
    private javax.swing.JMenu jQuanLyLuongNhanVien;
    private javax.swing.JMenu jQuanLyNhanVien;
    private javax.swing.JMenu jQuanLyPhim;
    private javax.swing.JMenu jQuanLyPhong;
    private javax.swing.JMenu jQuanLyThucAnNuocUong;
    private javax.swing.JMenu jQuanLyVe;
    private javax.swing.JMenu jTaiKhoan;
    private javax.swing.JMenu jThongKe;
    private javax.swing.JMenu jVe;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblTenNV;
    // End of variables declaration//GEN-END:variables

}
