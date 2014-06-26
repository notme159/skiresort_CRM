package gui;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.component.TaMoZak;
import model.component.AidZakInfo;
import model.sluzby.IntZakaznikService;
import model.sluzby.ZakaznikDbService;

public class DiaPrehledZak extends javax.swing.JDialog {

    private TaMoZak tblModelZakaznici;
    private List<AidZakInfo> zakaznici;
    private IntZakaznikService zakaznikService;
    private int zakId;

    public DiaPrehledZak(JFrame owner, boolean modal) {

        super(owner, modal);
        setTitle("Přehled zákazníků");
        setResizable(true);
        zakaznikService = new ZakaznikDbService();
        zakaznici = zakaznikService.prehledZak();
        tblModelZakaznici = new TaMoZak(zakaznici);
        initComponents();
        setLocationRelativeTo(owner);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btRefresh = new javax.swing.JButton();
        bdOdhl = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(1000, 371));

        jTable1.setModel(tblModelZakaznici);
        jScrollPane1.setViewportView(jTable1);

        btRefresh.setBackground(new java.awt.Color(255, 255, 255));
        btRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/img/update.jpg"))); // NOI18N
        btRefresh.setPreferredSize(new java.awt.Dimension(51, 51));
        btRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefreshActionPerformed(evt);
            }
        });

        bdOdhl.setBackground(new java.awt.Color(255, 255, 255));
        bdOdhl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/img/delete.png"))); // NOI18N
        bdOdhl.setText("Odhlásit");
        bdOdhl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdOdhlActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Přehled všech zákazníků");
        jLabel1.setMaximumSize(new java.awt.Dimension(34, 17));
        jLabel1.setMinimumSize(new java.awt.Dimension(34, 17));
        jLabel1.setPreferredSize(new java.awt.Dimension(34, 17));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(409, Short.MAX_VALUE)
                .addComponent(btRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(bdOdhl)
                .addGap(334, 334, 334))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bdOdhl)
                    .addComponent(btRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshActionPerformed
        zakaznici = zakaznikService.prehledZak();
        tblModelZakaznici.update(zakaznici);
    }//GEN-LAST:event_btRefreshActionPerformed

    private void bdOdhlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdOdhlActionPerformed

        int row = jTable1.getSelectedRow();

        if (row != -1) {
            zakId = (int) jTable1.getModel().getValueAt(row, 0);
            //System.out.println(zakId);
        }

        if (zakId != 0) {
            int ok = JOptionPane.showConfirmDialog(this, "Opravdu chcete zákazníka odhlásit?", "Potvrzení", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (ok == JOptionPane.YES_OPTION) {
                zakaznikService.odstrZak(zakId);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nejdříve označte zákazníka k odhlášení", "Odhlášení zákazníka", JOptionPane.ERROR_MESSAGE);
        }

        zakaznici = zakaznikService.prehledZak();
        tblModelZakaznici.update(zakaznici);

    }//GEN-LAST:event_bdOdhlActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bdOdhl;
    private javax.swing.JButton btRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
