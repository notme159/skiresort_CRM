package gui;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.sluzby.IntZakaznikService;
import model.sluzby.ZakaznikDbService;

public class DiaPridZak extends javax.swing.JDialog {

    private IntZakaznikService zakaznikService;
    private DiaPridPokoj diaPridPokoj;
    private String[] zakInfo = new String[20];
    private double celkovaCena;
    final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
    private int cenaPenze = 0;
    private int cenaStrava = 0;

    public DiaPridZak(JFrame owner, boolean modal) {
        super(owner, modal);
        setTitle("Přidat Zákazníka");
        initComponents();
        setLocationRelativeTo(owner);
        pack();
    }

    private double spocitejCenuStravy(String typPenze, String typStravy) {

        if (typPenze.equals("Plná")) {
            cenaPenze = 3;
        } else if (typPenze.equals("Polopenze")) {
            cenaPenze = 2;
        } else if (typPenze.equals("Žádná")) {
            cenaPenze = 1;
        }
        
        if (typStravy.equals("Klasická")) {
            cenaStrava = 100;
        } else if (typStravy.equals("Vegetariánská")) {
            cenaStrava = 85;
        } else if (typStravy.equals("Žádná")) {
            cenaStrava = 1;
        }

        return cenaPenze * cenaStrava;

    }

    private int spocitejPocetDni(String datPrij, String datOdj) throws ParseException {
        Date datPrijezd = new SimpleDateFormat("yyyy-MM-dd").parse(datPrij);
        Date datOdjezd = new SimpleDateFormat("yyyy-MM-dd").parse(datOdj);
        int pocetDni = (int) ((datOdjezd.getTime() - datPrijezd.getTime()) / DAY_IN_MILLIS);
        return pocetDni;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btVybPok = new javax.swing.JButton();
        btVlozZak = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        btSpocAVal = new javax.swing.JButton();
        jTextField9 = new javax.swing.JTextField();
        lblNadpis = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Jméno:");

        jLabel2.setText("Příjmení:");

        jLabel3.setText("Telefon:");

        jLabel4.setText("Email:");

        jLabel5.setText("Ulice:");

        jLabel6.setText("Číslo popisné:");

        jLabel7.setText("PSČ:");

        jLabel8.setText("Město:");

        jLabel9.setText("Datum příjezdu:");

        jLabel10.setText("Datum odjezdu:");

        jLabel11.setText("Typ penze:");

        jLabel12.setText("Typ stravy:");

        btVybPok.setBackground(new java.awt.Color(255, 255, 255));
        btVybPok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/img/postel.png"))); // NOI18N
        btVybPok.setText("Vyber pokoj");
        btVybPok.setName("btVybPok"); // NOI18N
        btVybPok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVyberPokActPerf(evt);
            }
        });

        btVlozZak.setText("Vlož zákazníka");
        btVlozZak.setEnabled(false);
        btVlozZak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVlozZakActPerf(evt);
            }
        });

        jTextField1.setMinimumSize(new java.awt.Dimension(20, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Plná", "Polopenze", "Žádná" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Klasická", "Vegetariánská", "Žádná" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel14.setText("Celková cena:");

        jTextField12.setEditable(false);

        jXDatePicker2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker2ActionPerformed(evt);
            }
        });

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        btSpocAVal.setText("Spočti a validuj");
        btSpocAVal.setEnabled(false);
        btSpocAVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSpocAValActPerf(evt);
            }
        });

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(255, 255, 255));

        lblNadpis.setBackground(new java.awt.Color(255, 255, 255));
        lblNadpis.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNadpis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNadpis.setText("Přidání nového zákazníka");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNadpis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btVlozZak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel14))
                                    .addComponent(btSpocAVal))
                                .addGap(10, 10, 10)
                                .addComponent(jTextField12))
                            .addComponent(btVybPok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(7, 7, 7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblNadpis, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField4)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField5)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField6)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField7)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField8)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(btVybPok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSpocAVal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btVlozZak, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVyberPokActPerf(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVyberPokActPerf

        diaPridPokoj = new DiaPridPokoj(this, true);
        diaPridPokoj.setVisible(true);
        zakInfo[13] = diaPridPokoj.getPokId();
        zakInfo[14] = diaPridPokoj.getPocetLuzek();
        zakInfo[15] = diaPridPokoj.getInternet();
        zakInfo[16] = diaPridPokoj.getCena();
        zakInfo[17] = diaPridPokoj.getVolny();
       
        System.out.println(zakInfo[13]);
        
        if (zakInfo[13]==null) {
            btSpocAVal.setEnabled(false);
             
        } else {
            btSpocAVal.setEnabled(true);
        }

    }//GEN-LAST:event_btVyberPokActPerf

    private boolean validuj(String[] zakInfo) {

        zakInfo[0] = jTextField1.getText(); //jm
        zakInfo[1] = jTextField2.getText(); //prijm
        zakInfo[2] = jTextField3.getText(); //tel
        zakInfo[3] = jTextField4.getText(); //email
        zakInfo[4] = jTextField5.getText(); //ulice
        zakInfo[5] = jTextField6.getText(); //cp
        zakInfo[6] = jTextField7.getText(); //psc
        zakInfo[7] = jTextField8.getText(); //mesto

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        zakInfo[8] = sdf.format(jXDatePicker1.getDate());
        zakInfo[9] = sdf.format(jXDatePicker2.getDate());

        zakInfo[10] = jComboBox1.getSelectedItem().toString();//penze
        zakInfo[11] = jComboBox2.getSelectedItem().toString();//typStravy

        double cenaPokoje = Double.parseDouble(zakInfo[16]);//cenaPok
        double cenaStravy = spocitejCenuStravy(zakInfo[10], zakInfo[11]);//penze,typStrav

        int pocetDni = 0;

        try {
            pocetDni = spocitejPocetDni(zakInfo[8], zakInfo[9]);
        } catch (ParseException ex) {
            Logger.getLogger(DiaPridZak.class.getName()).log(Level.SEVERE, null, ex);
        }

        zakInfo[12] = String.valueOf(cenaStravy);
        celkovaCena = pocetDni * (cenaPokoje + cenaStravy);
        zakInfo[18] = String.valueOf(celkovaCena);

        if (!zakInfo[0].isEmpty() && !zakInfo[1].isEmpty() && !zakInfo[2].isEmpty() && !zakInfo[3].isEmpty() && !zakInfo[4].isEmpty() && !zakInfo[5].isEmpty()
                && !zakInfo[6].isEmpty() && !zakInfo[7].isEmpty() && !zakInfo[8].isEmpty() && !zakInfo[9].isEmpty() && !zakInfo[10].isEmpty()
                && !zakInfo[11].isEmpty() && !zakInfo[12].isEmpty() && !zakInfo[13].isEmpty() && !zakInfo[13].isEmpty() && !zakInfo[14].isEmpty() && !zakInfo[15].isEmpty()
                && !zakInfo[16].isEmpty() && !zakInfo[17].isEmpty() && !zakInfo[18].isEmpty()) {

            return true;

        } else {
            
            JOptionPane.showMessageDialog(this, "Musíte vyplnit všechny hodnoty!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }

    private void btVlozZakActPerf(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVlozZakActPerf

        zakaznikService = new ZakaznikDbService();

        zakaznikService.pridatZak(zakInfo);
        JOptionPane.showMessageDialog(null, "Zákazník přidán");
        setVisible(false);

    }//GEN-LAST:event_btVlozZakActPerf

    private void jXDatePicker2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker2ActionPerformed
    }//GEN-LAST:event_jXDatePicker2ActionPerformed

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    private void btSpocAValActPerf(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSpocAValActPerf

        if (validuj(zakInfo)) {
            btVlozZak.setEnabled(true);
        }
        
        jTextField12.setText(String.format("Zvalidováno OK\n\r %s", String.valueOf(celkovaCena)));


    }//GEN-LAST:event_btSpocAValActPerf

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        zakInfo[10] = jComboBox1.getSelectedItem().toString();//penze
        zakInfo[11] = jComboBox2.getSelectedItem().toString();//typStravy

        double cenaStravy = spocitejCenuStravy(zakInfo[10], zakInfo[11]);//penze,typStrav
        jTextField9.setText("Cena za den: " + cenaStravy);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        zakInfo[10] = jComboBox1.getSelectedItem().toString();//penze
        zakInfo[11] = jComboBox2.getSelectedItem().toString();//typStravy

        double cenaStravy = spocitejCenuStravy(zakInfo[10], zakInfo[11]);//penze,typStrav
        jTextField9.setText("Cena za den: " + cenaStravy);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSpocAVal;
    private javax.swing.JButton btVlozZak;
    private javax.swing.JButton btVybPok;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JLabel lblNadpis;
    // End of variables declaration//GEN-END:variables
}
