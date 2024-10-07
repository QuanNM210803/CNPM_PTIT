package view;
import dao.ThongKeDoanhThuCtr11;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ThongKePhim11;

public final class ThongKeDoanhThuFrm11 extends javax.swing.JFrame {
    private LocalDateTime startTime;
    private LocalDateTime endTime;   
    private final DefaultTableModel tmPhim;
    private final ThongKeDoanhThuCtr11 thongKeDoanhThuCtr11;
    private ArrayList<ThongKePhim11> thongKePhim11s;
    
    public ThongKeDoanhThuFrm11() throws SQLException {
        initComponents();
        this.setTitle("Trang thống kê phim");
        tmPhim=(DefaultTableModel) tbPhim.getModel();
        thongKeDoanhThuCtr11=new ThongKeDoanhThuCtr11();
        thongKePhim11s=new ArrayList<>();
        setShowtbPhim11();
        eventButton();
    }
    public ThongKeDoanhThuFrm11(LocalDateTime startTime, LocalDateTime endTime) throws SQLException {
        initComponents();
        this.setTitle("Trang thống kê phim");
        this.startTime=startTime;
        this.endTime=endTime;
        tmPhim=(DefaultTableModel) tbPhim.getModel();
        thongKeDoanhThuCtr11=new ThongKeDoanhThuCtr11();
        thongKePhim11s=(ArrayList<ThongKePhim11>) thongKeDoanhThuCtr11.getThongKePhim11(startTime, endTime);
        setShowtbPhim11();
        eventButton();
    }
    public void eventButton(){
        btThongKe.addActionListener(e->{
            try{
                tmPhim.setRowCount(0);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate stDateTime=LocalDate.parse(textBatDau.getText(), formatter);
                LocalDate endDateTime=LocalDate.parse(textKetThuc.getText(), formatter);
                if(stDateTime.compareTo(endDateTime)>0){
                    throw new Exception();
                }
                startTime=convertStringToLocalDateTime(textBatDau.getText(), true);
                endTime=convertStringToLocalDateTime(textKetThuc.getText(), false);
                thongKePhim11s=(ArrayList<ThongKePhim11>) thongKeDoanhThuCtr11.getThongKePhim11(startTime,endTime);
                setShowtbPhim11();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Sai định dạng ngày (định dạng đúng: dd-MM-yyyy)"
                        + " hoặc lỗi do Ngày kết thúc trước ngày bắt đầu!");
            }
        });
        btReturn.addActionListener(e->{
            try {
                QuanLyFrm11 quanLyFrm11 = new QuanLyFrm11();
                getContentPane().removeAll();
                quanLyFrm11.QuanLyFrm();
                revalidate();
                repaint();
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ThongKeDoanhThuFrm11.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    public void setShowtbPhim11(){
        tmPhim.setRowCount(0);
        for(ThongKePhim11 i:thongKePhim11s){
            tmPhim.addRow(i.toObject());
        }
    }
    public LocalDateTime convertStringToLocalDateTime(String dateString, Boolean type){
        List<String> partsList=Arrays.asList(dateString.split("[-/]"));
        String input=partsList.get(2)+"-"+partsList.get(1)+"-"+partsList.get(0);
        if(type){
            input+=" 00:00:00";
        }else{
            input+=" 23:59:59";
        }
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(input, inputFormatter);
        return localDateTime;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textBatDau = new javax.swing.JTextField();
        textKetThuc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btThongKe = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhim = new javax.swing.JTable();
        btReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Ngày bắt đầu:");

        jLabel3.setText("Ngày kết thúc: ");

        btThongKe.setText("Bắt đầu thống kê");

        tbPhim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã", "Tên phim", "Tổng số vé", "Tổng doanh thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhimMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPhim);

        btReturn.setText("Về trang quản lý");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btReturn)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(btThongKe)
                .addContainerGap(283, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btThongKe)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btReturn)
                .addGap(15, 15, 15))
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

    private void tbPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhimMouseClicked
        int row=tbPhim.getSelectedRow();
        if(row>=0 && row<thongKePhim11s.size()){
            getContentPane().removeAll();
            SuatChieuFrm11 suatChieuFrm11=new SuatChieuFrm11();
            suatChieuFrm11.SuatChieuFrm(startTime, endTime, (int) tmPhim.getValueAt(row, 0));
            revalidate();
            repaint();
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Hãy chọn đúng dòng!!!");
        }
    }//GEN-LAST:event_tbPhimMouseClicked
 
    public void ThongKeDoanhThuFrmReturn(LocalDateTime startTime, LocalDateTime endTime) {
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
            java.util.logging.Logger.getLogger(ThongKeDoanhThuFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeDoanhThuFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeDoanhThuFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeDoanhThuFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new ThongKeDoanhThuFrm11(startTime,endTime).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhThuFrm11.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void ThongKeDoanhThuFrm() {
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
            java.util.logging.Logger.getLogger(ThongKeDoanhThuFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeDoanhThuFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeDoanhThuFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeDoanhThuFrm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new ThongKeDoanhThuFrm11().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeDoanhThuFrm11.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReturn;
    private javax.swing.JButton btThongKe;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPhim;
    private javax.swing.JTextField textBatDau;
    private javax.swing.JTextField textKetThuc;
    // End of variables declaration//GEN-END:variables
}
