package gui;

import java.sql.Connection;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.component.LiMoPok;
import model.entity.Pokoj;
import model.sluzby.IntZakaznikService;
import model.sluzby.ZakaznikDbService;

public class DiaPridPokoj extends javax.swing.JDialog {

    private LiMoPok mdlPokoje;
    private List<Pokoj> pokoje;
    private IntZakaznikService zakaznikService;
    private String pokId;
    private String pocetLuzek;
    private String internet;
    private String cena;
    private String volny;

    public DiaPridPokoj(JDialog owner, boolean modal) {
        super(owner, modal);

        setTitle("Výběr pokoje");

        zakaznikService = new ZakaznikDbService();

        pokoje = zakaznikService.getPokoje();

        mdlPokoje = new LiMoPok(pokoje);

        initComponents();
        setLocationRelativeTo(owner);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        btOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jList2.setModel(mdlPokoje);
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jList2);

        btOk.setText("Ok");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        jLabel1.setText("id:");

        jLabel2.setText("luzka:");

        jLabel3.setText("net:");

        jLabel4.setText("cena:");

        jLabel5.setText("volny:");

        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addContainerGap(835, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btOk, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCancel)
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btOk)
                        .addComponent(btCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed

        if (jList2.getSelectedValue() != null) {
            String pokInfo = jList2.getSelectedValue().toString();
            String[] rozdeleni = pokInfo.split("     ");
            pokId = rozdeleni[0];
            pocetLuzek = rozdeleni[1];
            internet = rozdeleni[2];
            cena = rozdeleni[3];
            volny = rozdeleni[4];

            if (volny.equals("false")) {
                JOptionPane.showMessageDialog(this, "Musíte vybrat volný pokoj!", "Chyba", JOptionPane.ERROR_MESSAGE);
                pokId = null;
            } else {
                System.out.println("ID pokoje: " + pokId + " volny: " + volny);

                setVisible(false);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Nutno vybrat pokoj!", "Chyba", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btOkActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        pokId = null;
        setVisible(false);
    }//GEN-LAST:event_btCancelActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables

    public String getPokId() {
        return pokId;
    }

    public String getPocetLuzek() {
        return pocetLuzek;
    }

    public String getInternet() {
        return internet;
    }

    public String getCena() {
        return cena;
    }

    public String getVolny() {
        return volny;
    }
}
