package gui;

import java.sql.Connection;
import java.util.List;
import model.component.AidPermInfo;
import model.component.TaMoPerm;
import model.sluzby.IntZakaznikService;
import model.sluzby.ZakaznikDbService;

/**
 *
 * @author Randoms
 */
public class DiaPrehlPerm extends javax.swing.JDialog {

    private IntZakaznikService zakaznikService;
    private TaMoPerm tblModelPermanentky;
    private List<AidPermInfo> permInfo;

    public DiaPrehlPerm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Zakoupené permanentky");

        zakaznikService = new ZakaznikDbService();
        permInfo = zakaznikService.getPerm();
        tblModelPermanentky = new TaMoPerm(permInfo);
        initComponents();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPermanentky = new javax.swing.JTable();
        btCancel = new javax.swing.JButton();
        lblNadpis = new javax.swing.JLabel();
        btUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblPermanentky.setModel(tblModelPermanentky);
        jScrollPane1.setViewportView(tblPermanentky);

        btCancel.setBackground(new java.awt.Color(255, 255, 255));
        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        lblNadpis.setBackground(new java.awt.Color(255, 255, 255));
        lblNadpis.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNadpis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNadpis.setText("Přehled zakoupených permanentek");
        lblNadpis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/img/update.jpg"))); // NOI18N
        btUpdate.setMaximumSize(new java.awt.Dimension(52, 52));
        btUpdate.setMinimumSize(new java.awt.Dimension(50, 50));
        btUpdate.setPreferredSize(new java.awt.Dimension(51, 51));
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNadpis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addComponent(btCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblNadpis, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCancel))
                    .addComponent(btUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btCancelActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        tblModelPermanentky.update(permInfo);
    }//GEN-LAST:event_btUpdateActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNadpis;
    private javax.swing.JTable tblPermanentky;
    // End of variables declaration//GEN-END:variables
}
