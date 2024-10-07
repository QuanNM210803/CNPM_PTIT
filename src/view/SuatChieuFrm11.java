package view;
import dao.ThongKeDoanhThuCtr11;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ThongKeSuatChieu11;

public final class SuatChieuFrm11 extends javax.swing.JFrame {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int phim11id;
    private DefaultTableModel tmSuatChieu = null;
    private ThongKeDoanhThuCtr11 thongKeDoanhThuCtr11 = null;
    private ArrayList<ThongKeSuatChieu11> thongKeSuatChieu11s;
    
    public SuatChieuFrm11(){
        this.setTitle("Trang thống kê suất chiếu");
    }
    public SuatChieuFrm11(LocalDateTime startTime, LocalDateTime endTime, int phim11id) throws SQLException {
        initComponents();
        this.setTitle("Trang thống kê suất chiếu");
        this.startTime=startTime;
        this.endTime=endTime;
        this.phim11id=phim11id;
        
        tmSuatChieu=(DefaultTableModel) tbSuatChieu.getModel();
        thongKeDoanhThuCtr11=new ThongKeDoanhThuCtr11();
        thongKeSuatChieu11s=(ArrayList<ThongKeSuatChieu11>) thongKeDoanhThuCtr11.getThongKeSuatChieu11(startTime, endTime, phim11id);
        setShowtbSuatChieu11();
        eventButton();
    }
    public void eventButton(){
        btReturn.addActionListener(e->{
            try {
                ThongKeDoanhThuFrm11 thongKeDoanhThuFrm11 = new ThongKeDoanhThuFrm11();
                getContentPane().removeAll();
                thongKeDoanhThuFrm11.ThongKeDoanhThuFrmReturn(startTime,endTime);
                revalidate();
                repaint();
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ThongKeDoanhThuFrm11.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    public void setShowtbSuatChieu11() throws SQLException{
        tmSuatChieu.setRowCount(0);
        for(ThongKeSuatChieu11 i:thongKeSuatChieu11s){
            tmSuatChieu.addRow(i.toObject());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSuatChieu = new javax.swing.JTable();
        btReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbSuatChieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã suất chiếu", "Suất chiếu", "Tổng số vé", "Tổng doanh thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSuatChieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSuatChieuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSuatChieu);

        btReturn.setText("Về trang thống kê phim");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btReturn)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btReturn)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbSuatChieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSuatChieuMouseClicked
        int row=tbSuatChieu.getSelectedRow();
        if(row>=0 && row<thongKeSuatChieu11s.size()){
            getContentPane().removeAll();
            HoaDonFrm11 hoaDonFrm11=new HoaDonFrm11();
            hoaDonFrm11.HoaDonFrm(startTime, endTime, (int) tmSuatChieu.getValueAt(row, 0),phim11id);
            revalidate();
            repaint();    
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Hãy chọn đúng dòng!!!");
        }
    }//GEN-LAST:event_tbSuatChieuMouseClicked

    public void SuatChieuFrm(LocalDateTime startTime, LocalDateTime endTime, int phim11id) {
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
            java.util.logging.Logger.getLogger(SuatChieuFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuatChieuFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuatChieuFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuatChieuFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SuatChieuFrm11(startTime,endTime,phim11id).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SuatChieuFrm11.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReturn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSuatChieu;
    // End of variables declaration//GEN-END:variables
}
