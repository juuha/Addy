/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addykorttipeligroupid.addykorttipeli.graafinenkayttoliittyma;

import addykorttipeligroupid.addykorttipeli.Kortti;
import addykorttipeligroupid.addykorttipeli.logiikka.MuuLogiikka;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author ritakosk
 */
public class MikaKorteistaPaallimaiseksiRuutu extends javax.swing.JFrame {

    private final ArrayList<Kortti> kortit;

    /**
     * Creates new form MikaKorteistaPaallimaiseksiRuutu
     */
    public MikaKorteistaPaallimaiseksiRuutu() {
        initComponents();
        kortit = MuuLogiikka.getVuoro().getPaallimaisenaPelattavat();
    }

    public void asetaLista() {
        DefaultListModel listModel = new DefaultListModel();
        for (Kortti k : kortit) {
            listModel.addElement(k.toString());
        }
        jPaallimmainenLista = new JList(listModel);
        jPaallimmainenLista.setFixedCellHeight(30);
        jPaallimmainenLista.setFixedCellWidth(80);
        jPaallimmainenLista.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jPaallimmainenLista.setVisibleRowCount(3);
        jScrollPane1.setViewportView(jPaallimmainenLista);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPaallimmainenLista = new javax.swing.JList<>();
        jValitse = new javax.swing.JButton();
        jValitseKortti = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Mikä päällimäiseksi?"));

        jPaallimmainenLista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "kortti 13", "kortti 2", "kortti 6" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jPaallimmainenLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jPaallimmainenLista.setFixedCellHeight(50);
        jPaallimmainenLista.setFixedCellWidth(119);
        jPaallimmainenLista.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jPaallimmainenLista.setVisibleRowCount(1);
        jScrollPane1.setViewportView(jPaallimmainenLista);

        jValitse.setText("Valitse");
        jValitse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jValitseActionPerformed(evt);
            }
        });

        jValitseKortti.setText("Valitse jokin korteista.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValitse, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValitseKortti))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jValitseKortti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jValitse)
                .addContainerGap())
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

    private void jValitseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jValitseActionPerformed
        if (!jPaallimmainenLista.getSelectedValue().equals("-1")) {
            String apu = jPaallimmainenLista.getSelectedValue();
            String[] maajaarvo = apu.split(" ");
            MuuLogiikka.getVuoro().setPaallimmaisenaPelattava(new Kortti(maajaarvo[0], Integer.parseInt(maajaarvo[1])));
            
            this.setVisible(false);
        } else {
            jValitseKortti.setVisible(true);
        }
    }//GEN-LAST:event_jValitseActionPerformed

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
            java.util.logging.Logger.getLogger(MikaKorteistaPaallimaiseksiRuutu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MikaKorteistaPaallimaiseksiRuutu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MikaKorteistaPaallimaiseksiRuutu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MikaKorteistaPaallimaiseksiRuutu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MikaKorteistaPaallimaiseksiRuutu mkpr = new MikaKorteistaPaallimaiseksiRuutu();
                mkpr.setLocationRelativeTo(null);
                mkpr.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jPaallimmainenLista;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jValitse;
    private javax.swing.JLabel jValitseKortti;
    // End of variables declaration//GEN-END:variables
}
