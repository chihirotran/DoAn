
package InterFace;


import Model.HoaDon;
import Model.MatHang;
import Process.ThongKe;
import com.toedter.calendar.JDayChooser;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmThongke extends javax.swing.JFrame {
    private final  DefaultTableModel tbModel = new DefaultTableModel();
    private final SimpleDateFormat ngaythangnam = new SimpleDateFormat("dd-MM-yyyy");
    private final SimpleDateFormat NgayDateFormat = new SimpleDateFormat("dd");
    private final SimpleDateFormat ThangNam = new SimpleDateFormat("MM-yyyy");
    private final SimpleDateFormat ThangDateFormat = new SimpleDateFormat("MM");
    private final SimpleDateFormat Nam = new SimpleDateFormat("yyyy");
    private final ThongKe tk = new ThongKe();

    private frmThongke() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public List<HoaDon> getdata() throws SQLException{
        List<HoaDon> lst = tk.getAll();
        return lst;
    }
    public List<HoaDon> getdataNgayThangNam(String NgayString,String ThangString,String Nam) throws SQLException{
        List<HoaDon> lst = tk.TimTheoNgayThangNam(NgayString, ThangString, Nam);
        return lst;
    }
    public List<HoaDon> getdataThangNam(String ThangString,String Nam) throws SQLException{
        List<HoaDon> lst = tk.TimTheoThangNam(ThangString, Nam);
        return lst;
    }
    public List<HoaDon> getdataNam(String Nam) throws SQLException{
        List<HoaDon> lst = tk.TimTheoNam(Nam);
        return lst;
    }
    public JFrame jframe;
    public frmThongke(JFrame jfr) throws SQLException {
        jframe=jfr;
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        String[] colName = {"Ma Hd","Ngay Tao Hoa Don","Tong So Tien","Ma NV","MaKH"};
        tbModel.setColumnIdentifiers(colName);
        tableThongke.setModel(tbModel);
        showData();
       
    }
    public void clearData(){
        while(tbModel.getRowCount()>0){
            tbModel.removeRow(0);
        }
    }
    public void showData() throws SQLException{
        clearData();
        List<HoaDon> data = getdata();
        for(int i=0; i <data.size();i++){
           
            String[] row11 = {
                data.get(i).getMaHD(),
                ""+data.get(i).getNgayTaoDate(),
                ""+data.get(i).getTongTienLong(),
                ""+data.get(i).getMaNV(),
                ""+data.get(i).getMaKH()
            };
         
        tbModel.addRow(row11);
        }
    }
    public void showDataNTN(String NgayString,String ThangString,String Nam) throws SQLException{
        clearData();
        List<HoaDon> data = getdataNgayThangNam(NgayString, ThangString, Nam);
        long TongDoanhThu = (long) 0.0;
        for(int i=0; i <data.size();i++){
           
            String[] row11 = {
                data.get(i).getMaHD(),
                ""+data.get(i).getNgayTaoDate(),
                ""+data.get(i).getTongTienLong(),
                ""+data.get(i).getMaNV(),
                ""+data.get(i).getMaKH()
            };
         TongDoanhThu =TongDoanhThu+data.get(i).getTongTienLong();
        tbModel.addRow(row11);
        }
        lblSoHoaDon.setText(""+data.size());
        lblTongDoanhThu.setText(""+TongDoanhThu+"VND");
    }
    public void showDataTN(String ThangString,String Nam) throws SQLException{
        clearData();
        List<HoaDon> data =  getdataThangNam(ThangString, Nam);
        long TongDoanhThu = (long) 0.0;
        for(int i=0; i <data.size();i++){
           
            String[] row11 = {
                data.get(i).getMaHD(),
                ""+data.get(i).getNgayTaoDate(),
                ""+data.get(i).getTongTienLong(),
                ""+data.get(i).getMaNV(),
                ""+data.get(i).getMaKH()
            };
         TongDoanhThu =TongDoanhThu+data.get(i).getTongTienLong();
        tbModel.addRow(row11);
        }
        lblSoHoaDon.setText(""+data.size());
        lblTongDoanhThu.setText(""+TongDoanhThu+"VND");
    }
    public void showDataN(String Nam) throws SQLException{
        clearData();
        List<HoaDon> data = getdataNam(Nam);
        long TongDoanhThu = (long) 0.0;
        for(int i=0; i <data.size();i++){
           
            String[] row11 = {
                data.get(i).getMaHD(),
                ""+data.get(i).getNgayTaoDate(),
                ""+data.get(i).getTongTienLong(),
                ""+data.get(i).getMaNV(),
                ""+data.get(i).getMaKH()
            };
         TongDoanhThu =TongDoanhThu+data.get(i).getTongTienLong();
        tbModel.addRow(row11);
        }
        lblSoHoaDon.setText(""+data.size());
        lblTongDoanhThu.setText(""+TongDoanhThu+"VND");
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThongke = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        radXemngay = new javax.swing.JRadioButton();
        radXemthang = new javax.swing.JRadioButton();
        radXemnam = new javax.swing.JRadioButton();
        btnFind = new javax.swing.JButton();
        NgayThang = new com.toedter.calendar.JDateChooser();
        btnHome = new javax.swing.JButton();
        lbTrangthai = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSoHoaDon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTongDoanhThu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thống kê");

        tableThongke.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableThongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MaHD", "Ngày bán", "Tổng tiền hóa đơn", "NV Ban", "MaKH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableThongke);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        buttonGroup1.add(radXemngay);
        radXemngay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radXemngay.setText("Xem theo ngày");
        radXemngay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radXemngayItemStateChanged(evt);
            }
        });

        buttonGroup1.add(radXemthang);
        radXemthang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radXemthang.setText("Xem theo tháng");
        radXemthang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radXemthangItemStateChanged(evt);
            }
        });

        buttonGroup1.add(radXemnam);
        radXemnam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radXemnam.setText("Xem theo năm");
        radXemnam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radXemnamItemStateChanged(evt);
            }
        });

        btnFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search.png"))); // NOI18N
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(radXemngay)
                                .addGap(29, 29, 29)
                                .addComponent(radXemthang)
                                .addGap(27, 27, 27)
                                .addComponent(radXemnam))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(NgayThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addComponent(btnFind, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radXemngay)
                    .addComponent(radXemthang)
                    .addComponent(radXemnam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NgayThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnFind)
                .addContainerGap())
        );

        btnHome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/smart-home (1).png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        lbTrangthai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTrangthai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTrangthai.setText("Trạng thái");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tổng Số Hóa Đơn Bán Ra:");

        lblSoHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSoHoaDon.setText("0");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tổng Tiền Thu Về:");

        lblTongDoanhThu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTongDoanhThu.setText("0 VND");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTongDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblSoHoaDon)
                    .addComponent(jLabel4)
                    .addComponent(lblTongDoanhThu))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        jframe.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String day = NgayDateFormat.format(NgayThang.getDate());
        String month = ThangDateFormat.format(NgayThang.getDate());
        String year = Nam.format(NgayThang.getDate());
        if(radXemngay.isSelected()==true){
            try {
                showDataNTN(day, month, year);
            } catch (SQLException ex) {
                Logger.getLogger(frmThongke.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(radXemthang.isSelected()==true){
            try {
                showDataTN(month, year);
            } catch (SQLException ex) {
                Logger.getLogger(frmThongke.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(radXemnam.isSelected()==true){
            try {
                showDataN(year);
            } catch (SQLException ex) {
                Logger.getLogger(frmThongke.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnFindActionPerformed

    private void radXemnamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radXemnamItemStateChanged
        
    }//GEN-LAST:event_radXemnamItemStateChanged

    private void radXemthangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radXemthangItemStateChanged
      
    }//GEN-LAST:event_radXemthangItemStateChanged

    private void radXemngayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radXemngayItemStateChanged
        
    }//GEN-LAST:event_radXemngayItemStateChanged


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
            java.util.logging.Logger.getLogger(frmThongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmThongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmThongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmThongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new frmThongke().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser NgayThang;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnHome;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTrangthai;
    private javax.swing.JLabel lblSoHoaDon;
    private javax.swing.JLabel lblTongDoanhThu;
    private javax.swing.JRadioButton radXemnam;
    private javax.swing.JRadioButton radXemngay;
    private javax.swing.JRadioButton radXemthang;
    private javax.swing.JTable tableThongke;
    // End of variables declaration//GEN-END:variables
}
