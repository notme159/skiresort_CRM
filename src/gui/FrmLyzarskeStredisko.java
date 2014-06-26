package gui;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.util.Date;

public class FrmLyzarskeStredisko extends JFrame {

    private DiaPridZak diaPridZak;
    private DiaPrehledZak diaPrehZak;
    private DiaPridPerm diaPridPerm;
    private DiaPrehlProd diaPrehlProd;
    private DiaPrehlPerm diaPrehlPerm;
    private DiaSpravaVyp diaSpravaVyp;
    
    // pro zobrazení hodin
    private Date dNow = new Date();
    
    // format pro zobrazeni hodin
    private SimpleDateFormat ft = new SimpleDateFormat("E dd.MMMM yyyy");
    

    public FrmLyzarskeStredisko() throws SQLException {
        initComponents();

        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNadpis = new javax.swing.JLabel();
        btPridatZakaznika = new javax.swing.JButton();
        btPrehledZak = new javax.swing.JButton();
        btPrehlProd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btPridejPerm = new javax.swing.JButton();
        btSpravaVyp = new javax.swing.JButton();
        btZakoupenePerm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lyžařské středisko Randoms");
        setBackground(new java.awt.Color(51, 0, 255));
        setResizable(false);

        lblNadpis.setBackground(new java.awt.Color(255, 255, 255));
        lblNadpis.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblNadpis.setText("Lyžařské středisko Medovice");
        lblNadpis.setBorder(new javax.swing.border.MatteBorder(null));

        btPridatZakaznika.setBackground(new java.awt.Color(255, 255, 255));
        btPridatZakaznika.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/img/user_add_48.png"))); // NOI18N
        btPridatZakaznika.setText("Přidat zákaznika");
        btPridatZakaznika.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btPridatZakaznika.setPreferredSize(new java.awt.Dimension(200, 57));
        btPridatZakaznika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPridatZakaznikaActionPerformed(evt);
            }
        });

        btPrehledZak.setBackground(new java.awt.Color(255, 255, 255));
        btPrehledZak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/img/book.png"))); // NOI18N
        btPrehledZak.setText("Přehled zákazníků");
        btPrehledZak.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btPrehledZak.setPreferredSize(new java.awt.Dimension(200, 55));
        btPrehledZak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrehledZakActionPerformed(evt);
            }
        });

        btPrehlProd.setBackground(new java.awt.Color(255, 255, 255));
        btPrehlProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/img/lyze.png"))); // NOI18N
        btPrehlProd.setText("Přehled Produktů");
        btPrehlProd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btPrehlProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrehlProdActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Dnes je: " + ft.format(dNow));

        btPridejPerm.setBackground(new java.awt.Color(255, 255, 255));
        btPridejPerm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/img/lanovka.png"))); // NOI18N
        btPridejPerm.setText("Přidat permanentku");
        btPridejPerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPridejPermActionPerformed(evt);
            }
        });

        btSpravaVyp.setBackground(new java.awt.Color(255, 255, 255));
        btSpravaVyp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/img/book.png"))); // NOI18N
        btSpravaVyp.setText("Správa výpůjček");
        btSpravaVyp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btSpravaVyp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSpravaVypActionPerformed(evt);
            }
        });

        btZakoupenePerm.setBackground(new java.awt.Color(255, 255, 255));
        btZakoupenePerm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/img/book.png"))); // NOI18N
        btZakoupenePerm.setText("Zakoupené permanentky");
        btZakoupenePerm.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btZakoupenePerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btZakoupenePermActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(lblNadpis)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btPridejPerm, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPridatZakaznika, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPrehlProd, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPrehledZak, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSpravaVyp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btZakoupenePerm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNadpis, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPridatZakaznika, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPrehledZak, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPrehlProd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSpravaVyp, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPridejPerm, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btZakoupenePerm, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPridatZakaznikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPridatZakaznikaActionPerformed
        diaPridZak = new DiaPridZak(this, true);
        diaPridZak.setVisible(true);
    }//GEN-LAST:event_btPridatZakaznikaActionPerformed

    private void btPrehledZakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrehledZakActionPerformed
        diaPrehZak = new DiaPrehledZak(this, true);
        diaPrehZak.setVisible(true);
    }//GEN-LAST:event_btPrehledZakActionPerformed

    private void btPridejPermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPridejPermActionPerformed
        diaPridPerm = new DiaPridPerm(this, true);
        diaPridPerm.setVisible(true);
    }//GEN-LAST:event_btPridejPermActionPerformed

    private void btPrehlProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrehlProdActionPerformed
        diaPrehlProd = new DiaPrehlProd(this, true);
        diaPrehlProd.setVisible(true);
    }//GEN-LAST:event_btPrehlProdActionPerformed

    private void btSpravaVypActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSpravaVypActionPerformed
        diaSpravaVyp = new DiaSpravaVyp(this, true);
        diaSpravaVyp.setVisible(true);
    }//GEN-LAST:event_btSpravaVypActionPerformed

    private void btZakoupenePermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btZakoupenePermActionPerformed
        diaPrehlPerm = new DiaPrehlPerm(this, true);
        diaPrehlPerm.setVisible(true);
    }//GEN-LAST:event_btZakoupenePermActionPerformed

    public static void main(String args[]) throws ClassNotFoundException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLyzarskeStredisko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new FrmLyzarskeStredisko().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmLyzarskeStredisko.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPrehlProd;
    private javax.swing.JButton btPrehledZak;
    private javax.swing.JButton btPridatZakaznika;
    private javax.swing.JButton btPridejPerm;
    private javax.swing.JButton btSpravaVyp;
    private javax.swing.JButton btZakoupenePerm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNadpis;
    // End of variables declaration//GEN-END:variables
}