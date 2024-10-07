package view;
import dao.ThongKeDoanhThuCtr11;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.ThongKeHoaDon11;

public final class HoaDonFrm11 extends javax.swing.JFrame {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int phim11id;
    private DefaultTableModel tmHoaDon=new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            // Chỉ cột "Name" có thể chỉnh sửa (cột thứ 2)
            return column == 1;
        }
    };;
    private ThongKeDoanhThuCtr11 thongKeDoanhThuCtr11;
    private ArrayList<ThongKeHoaDon11> thongKeHoaDon11s;
    
    public HoaDonFrm11(){
        
    }
    public HoaDonFrm11(LocalDateTime startTime, LocalDateTime endTime, int suatChieu11id, int phim11id) throws SQLException {
        initComponents();
        this.setTitle("Trang thống kê hóa đơn");
        this.startTime=startTime;
        this.endTime=endTime;
        this.phim11id=phim11id;
        tmHoaDon=(DefaultTableModel) tbHoaDon.getModel();
        thongKeDoanhThuCtr11=new ThongKeDoanhThuCtr11();
        thongKeHoaDon11s=(ArrayList<ThongKeHoaDon11>) thongKeDoanhThuCtr11.getThongKeHoaDon11(startTime, endTime, suatChieu11id);
        setShowtbHoaDon11();
        eventButton();
    }
    public void eventButton(){
        btReturn.addActionListener(e->{
            getContentPane().removeAll();
            SuatChieuFrm11 suatChieuFrm11=new SuatChieuFrm11();
            suatChieuFrm11.SuatChieuFrm(startTime, endTime, phim11id);
            revalidate();
            repaint();
            this.dispose();
        });
    }
    public void setShowtbHoaDon11() throws SQLException{
        tmHoaDon.setRowCount(0);
        for(ThongKeHoaDon11 i:thongKeHoaDon11s){
            tmHoaDon.addRow(i.toObject());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        btReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã", "Khách hàng", "Tổng số vé", "Tổng hóa đơn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        btReturn.setText("Về trang thống kê suất chiếu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 463, Short.MAX_VALUE)
                        .addComponent(btReturn)
                        .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btReturn)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void HoaDonFrm(LocalDateTime startTime, LocalDateTime endTime, int suatChieu11id, int phim11id) {
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
            java.util.logging.Logger.getLogger(HoaDonFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HoaDonFrm11(startTime,endTime,suatChieu11id, phim11id).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonFrm11.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReturn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbHoaDon;
    // End of variables declaration//GEN-END:variables
}
