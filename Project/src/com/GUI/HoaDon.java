/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import com.dao.HangDAO;
import com.dao.HoaDonCTDAO;
import com.dao.HoaDonDAO;
import com.dao.LoaiHangDAO;
import com.dao.SanPhamDAO;
import com.entity.HangEntity;
import com.entity.HoaDonCTEntity;
import com.entity.HoaDonEntity;
import com.entity.LoaiHangEntity;
import com.entity.SanPhamEntity;
import com.utils.MsgBox;
import com.utils.XImage;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author doanh
 */
public class HoaDon extends javax.swing.JDialog {

    /**
     * Creates new form HoaDon
     */
    HoaDonCTDAO HDCT = new HoaDonCTDAO();
    HoaDonCTDAO HoaDon = new HoaDonCTDAO();
    HangDAO hang = new HangDAO();
    LoaiHangDAO loai = new LoaiHangDAO();
    List<HoaDonCTEntity> listHD = new ArrayList<>();
    List<HoaDonCTEntity> listHDT = new ArrayList<>();
    int countClick = 0;
    int row = -1;

    SanPhamDAO sanPham = new SanPhamDAO();
    String maHD = null;

    public HoaDon(java.awt.Frame parent, boolean modal, String mahd) {
        super(parent, modal);
        initComponents();
           this.setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(parent);
        setResizable(false);
//        listHD = HoaDon.selectAll();
        maHD = mahd;
        initHD();
    }

    private HoaDon(JFrame jFrame, boolean modal) {
        initComponents();
        setResizable(false);
//        listHD = HoaDon.selectAll();
        maHD = "HD01";
        initHD();
    }

    public void fillTablehd() {
        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        try {
            for (HoaDonCTEntity hd : listHD) {
                if (maHD.equalsIgnoreCase(hd.getMaHD())) {               
                    Object[] row = {hd.getMaHD(), hd.getTenSP(), hd.getNgayLap(), hd.getNgayNhap(), hd.getSl(), hd.getGiaBan(), hd.getTongTien()};
                    model.addRow(row);
                    listHDT.add(hd);
                }
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    public void initHD() {
        setLocationRelativeTo(null);
        listHoaDonCT();
        this.fillTablehd();
        this.row = -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        lbltenSP = new javax.swing.JLabel();
        lblNgayNhap = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        lblMacthd = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        txtTongTienX = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        txtGiaBanX = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        btnCapNhatX = new com.swing.Button();
        lbltenNV = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        lblTenHang = new javax.swing.JLabel();
        lblTenLoai = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel132 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        lbltenkh = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        spsl = new javax.swing.JSpinner();
        lblImageHDCT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1180, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("HÓA ĐƠN CHI TIẾT");
        jPanel1.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 290, 40));

        lbltenSP.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbltenSP.setForeground(new java.awt.Color(0, 0, 255));
        lbltenSP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltenSP.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lbltenSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 200, 30));

        lblNgayNhap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNgayNhap.setForeground(new java.awt.Color(0, 0, 255));
        lblNgayNhap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNgayNhap.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lblNgayNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, 100, 30));

        txtMaSP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 200, 30));

        lblMacthd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblMacthd.setForeground(new java.awt.Color(0, 0, 255));
        lblMacthd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMacthd.setToolTipText("");
        jPanel1.add(lblMacthd, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 230, 30));

        jLabel125.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(0, 0, 255));
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel125.setText("Tổng tiền:");
        jLabel125.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, -1, 30));

        txtTongTienX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTongTienX.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTongTienX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienXActionPerformed(evt);
            }
        });
        jPanel1.add(txtTongTienX, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 200, 30));

        jLabel128.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(0, 0, 255));
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel128.setText("Giá bán:");
        jLabel128.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, -1, 30));

        txtGiaBanX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtGiaBanX.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtGiaBanX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanXActionPerformed(evt);
            }
        });
        jPanel1.add(txtGiaBanX, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 200, 30));

        jLabel120.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(0, 0, 255));
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel120.setText("Số lượng:");
        jLabel120.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, 30));

        btnCapNhatX.setBackground(new java.awt.Color(102, 204, 255));
        btnCapNhatX.setBorder(null);
        btnCapNhatX.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhatX.setText("Cập nhật");
        btnCapNhatX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatXActionPerformed(evt);
            }
        });
        jPanel1.add(btnCapNhatX, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 380, 116, 39));

        lbltenNV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbltenNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltenNV.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lbltenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 240, 30));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Tên sản phẩm", "Ngày lập", "Ngày nhập", "Số lượng", "Giá bán", "Tổng tiền"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseReleased(evt);
            }
        });
        jScrollPane12.setViewportView(tblHoaDon);

        jPanel1.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 1218, 250));

        lblTenHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTenHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTenHang.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lblTenHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 200, 30));

        lblTenLoai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTenLoai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTenLoai.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lblTenLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 200, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 54, 290, 10));

        jLabel132.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel132.setText("Nhân viên:");
        jLabel132.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        jLabel137.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel137.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel137.setText("Anh/chị:");
        jLabel137.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 30));

        lbltenkh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbltenkh.setForeground(new java.awt.Color(0, 0, 255));
        lbltenkh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltenkh.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lbltenkh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 240, 30));

        jLabel139.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(0, 0, 255));
        jLabel139.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel139.setText("No:");
        jLabel139.setToolTipText("");
        jPanel1.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 60, 30, 30));

        jLabel140.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel140.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel140.setText("Mã sản phẩm:");
        jLabel140.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 100, 30));

        jLabel124.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(0, 0, 255));
        jLabel124.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel124.setText("Tên sản phẩm:");
        jLabel124.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, 30));

        jLabel141.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel141.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel141.setText("Ngày lập:");
        jLabel141.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 20, -1, 30));

        jLabel142.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(0, 0, 255));
        jLabel142.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel142.setText("Tên Loại:");
        jLabel142.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 70, 30));

        jLabel143.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(0, 0, 255));
        jLabel143.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel143.setText("Tên Hãng:");
        jLabel143.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, 30));

        spsl.setBorder(null);
        jPanel1.add(spsl, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 50, 30));

        lblImageHDCT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblImageHDCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 130, 150, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapNhatXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatXActionPerformed
        updateHoaDonCT();
    }//GEN-LAST:event_btnCapNhatXActionPerformed

    private void txtTongTienXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienXActionPerformed

    private void txtGiaBanXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanXActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked

        int i = tblHoaDon.getSelectedRow();
        HoaDonCTEntity hd = listHDT.get(i);
        SanPhamEntity sp = sanPham.selectById(hd.getMaSP());
        lbltenkh.setText(hd.getTenKH());
        lbltenNV.setText(hd.getTenNV());
        lblMacthd.setText(hd.getMaCTHD().substring(hd.getMaCTHD().length() - 2, hd.getMaCTHD().length()));
        lblNgayNhap.setText(String.valueOf(hd.getNgayLap()));
        lbltenSP.setText(hd.getTenSP());
        spsl.setValue(hd.getSl());
        txtGiaBanX.setText(String.valueOf(hd.getGiaBan()));
        txtTongTienX.setText(String.valueOf(hd.getTongTien()));
        lblTenHang.setText(hd.getTenHang());
        lblTenLoai.setText(hd.getTenLH());
        txtMaSP.setText(hd.getMaSP());

        if (sp.getHinh() != null) {
            File file = new File("src\\com\\images\\" + sp.getHinh() + ".PNG");
            try {
                Image img = ImageIO.read(file);
                lblImageHDCT.setText("");
                int w = lblImageHDCT.getWidth();
                int h = lblImageHDCT.getHeight();
                lblImageHDCT.setIcon(new ImageIcon(img.getScaledInstance(w, h, 0)));
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            lblImageHDCT.setIcon(null);
        }

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblHoaDonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseReleased

    }//GEN-LAST:event_tblHoaDonMouseReleased

    public void updateHoaDonCT() {
        HoaDonCTEntity hd = getFormHoaDonCT();
        try {
            HDCT.update(hd);
            listHoaDonCT();
            this.fillTablehd();
            this.clearFormHoaDonCT();
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, e + "Cập nhật thất bại!");
        }
    }

    public void listHoaDonCT() {
        listHD = HoaDon.selectAll();
        List<HoaDonCTEntity> listHDCTTemp = new ArrayList<>();
        listHDCTTemp.addAll(listHD);
        listHD.clear();
        listHD.addAll(listHDCTTemp);
    }

    public HoaDonCTEntity getFormHoaDonCT() {
        HoaDonCTEntity hd = new HoaDonCTEntity();
        SanPhamEntity sp = sanPham.selectById(txtMaSP.getText());
        HangEntity h = hang.selectById(sp.getMaHang());
        LoaiHangEntity lh = loai.selectById(sp.getMaLH());
        hd.setMaSP(txtMaSP.getText());
        hd.setMaHang(sp.getMaHang());
        hd.setMaLH(sp.getMaLH());
        hd.setTenSP(sp.getTenSP());
        hd.setTenHang(h.getTenHang());
        hd.setTenLH(lh.getTenLH());
        hd.setSl((int) spsl.getValue());
        hd.setMaCTHD("CTHD" + lblMacthd.getText());
        return hd;
    }

    public void clearFormHoaDonCT() {
        lbltenkh.setText("");
        lbltenNV.setText("");
        lblMacthd.setText("");
        lblNgayNhap.setText("");
        lbltenSP.setText("");
        spsl.setValue(0);
        txtGiaBanX.setText("");
        txtTongTienX.setText("");
        lblTenHang.setText("");
        lblTenLoai.setText("");
        txtMaSP.setText("");
        lblImageHDCT.setIcon(null);
    }

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
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                var dialog = new HoaDon(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.Button btnCapNhatX;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImageHDCT;
    private javax.swing.JLabel lblMacthd;
    private javax.swing.JLabel lblNgayNhap;
    private javax.swing.JLabel lblTenHang;
    private javax.swing.JLabel lblTenLoai;
    private javax.swing.JLabel lbltenNV;
    private javax.swing.JLabel lbltenSP;
    private javax.swing.JLabel lbltenkh;
    private javax.swing.JSpinner spsl;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtGiaBanX;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtTongTienX;
    // End of variables declaration//GEN-END:variables
}