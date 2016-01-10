/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addykorttipeligroupid.addykorttipeli.graafinenkayttoliittyma;

import addykorttipeligroupid.addykorttipeli.Kortti;
import addykorttipeligroupid.addykorttipeli.logiikka.MuuLogiikka;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author ritakosk
 */
public class VuoroRuutu extends javax.swing.JFrame {

    private int voikoLopettaa = 3;
    private int tamanvuoronpelaaja;
    private int ekapelaaja;
    private int tokapelaaja;
    ArrayList<Kortti> pelattavatKortit = new ArrayList();

    /**
     * Creates new form VuoroRuutu
     */
    public VuoroRuutu() {
        
        initComponents();
        voikoLopettaa = 3;
        aloitus();
    }
    
    private void aloitus(){
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void joKolmeNostettu() {
        jNostitJoKolme.setVisible(true);
        jEtOleNostanut3.setVisible(false);
    }

    private void etOleNostanutKolmea() {
        jEtOleNostanut3.setVisible(true);
    }

    private void naytaOmatKortit() {
        ArrayList<Kortti> kortit = MuuLogiikka.getVuoro().getPoyta().getTamanVuoronPelaaja().getKadessaOlevatKortit();
        DefaultListModel listModel = new DefaultListModel();
        for (Kortti k : kortit) {
            listModel.addElement(k.toString());
        }
        jOmatKortit = new JList(listModel);
        jOmatKortit.setFixedCellHeight(30);
        jOmatKortit.setFixedCellWidth(80);
        jOmatKortit.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jOmatKortit.setVisibleRowCount(3);
        jScrollPane1.setViewportView(jOmatKortit);
    }

    public void pakkaJaPoytaLoppu() {
        jKortitLoppuPoydastaJaPakasta.setVisible(true);
    }

    private String getPaallimmainen() {
        return MuuLogiikka.getVuoro().getPoyta().getPaallimmainen().toString();
    }

    private String getEkaPelaaja() {
        for (int i = 0; i < MuuLogiikka.getVuoro().getPoyta().getPelaajat().size(); i++) {
            if (MuuLogiikka.getVuoro().getPoyta().getTamanVuoronPelaaja().getNimi()
                    .equals(MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(i).getNimi())) {
                tamanvuoronpelaaja = i;
            }
        }
        for (int i = 0; i < MuuLogiikka.getVuoro().getPoyta().getPelaajat().size(); i++) {
            if (MuuLogiikka.getVuoro().getPoyta().getTamanVuoronPelaaja().getNimi()
                    .equals(MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(i).getNimi())) {
            } else {
                String ekapelaajanpalautus = MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(i).getNimi();
                ekapelaajanpalautus += ": " + MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(i).montaKorttiaKadessa();
                ekapelaaja = i;
                return ekapelaajanpalautus;
            }
        }

        return "";
    }

    private String getTokaPelaaja() {
        if (MuuLogiikka.getVuoro().getPoyta().getPelaajat().size() > 2) {
            for (int i = 0; i < MuuLogiikka.getVuoro().getPoyta().getPelaajat().size(); i++) {
                if (MuuLogiikka.getVuoro().getPoyta().getTamanVuoronPelaaja().getNimi()
                        .equals(MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(i).getNimi())
                        || MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(i).getNimi()
                        .equals(MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(ekapelaaja).getNimi())) {
                } else {
                    String tokapelaajanpalautus = MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(i).getNimi();
                    tokapelaajanpalautus += ": " + MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(i).montaKorttiaKadessa();
                    tokapelaaja = i;
                    return tokapelaajanpalautus;
                }
            }
        }
        return "";
    }

    private String getKolmasPelaaja() {
        if (MuuLogiikka.getVuoro().getPoyta().getPelaajat().size() > 3) {
            for (int i = 0; i < MuuLogiikka.getVuoro().getPoyta().getPelaajat().size(); i++) {
                if (MuuLogiikka.getVuoro().getPoyta().getTamanVuoronPelaaja().getNimi()
                        .equals(MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(i).getNimi())
                        || MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(i).getNimi()
                        .equals(MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(ekapelaaja).getNimi())
                        || MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(i).getNimi()
                        .equals(MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(tokapelaaja).getNimi())) {
                } else {
                    String kolmaspelaajanpalautus = MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(i).getNimi();
                    kolmaspelaajanpalautus += ": " + MuuLogiikka.getVuoro().getPoyta().getPelaajat().get(i).montaKorttiaKadessa();
                    return kolmaspelaajanpalautus;
                }
            }
        }
        return "";
    }

    public void lopetaVuoro() {
        MuuLogiikka.getVuoro().jalkivalmistelut();
        if (MuuLogiikka.getVuoro().getVoitto() == 1) {
            MuuLogiikka.voitto();
            MuuLogiikka.nollaaPeli();
            this.setVisible(false);
        } else {
            this.setVisible(false);
            MuuLogiikka.getVuoro().vuoro();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jPelaa = new javax.swing.JButton();
        jNostaKortti = new javax.swing.JButton();
        jLopetaVuoro = new javax.swing.JButton();
        jLuovuta = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 38), new java.awt.Dimension(0, 38), new java.awt.Dimension(32767, 38));
        jLuovutaPeruuta = new javax.swing.JButton();
        jLuovutaOK = new javax.swing.JButton();
        jNostitJoKolme = new javax.swing.JLabel();
        jEtOleNostanut3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jVastustaja1Kortit = new javax.swing.JLabel();
        jVastustaja2kortit = new javax.swing.JLabel();
        jVastustaja3kortit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jOmatKortit = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jKortti = new javax.swing.JLabel();
        jKortitLoppuPoydastaJaPakasta = new javax.swing.JLabel();
        jEiValittujaKortteja = new javax.swing.JLabel();
        jVaaraSumma = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        jToggleButton2.setText("jToggleButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 560, 550));
        setMinimumSize(new java.awt.Dimension(650, 420));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPelaa.setText("Pelaa");
        jPelaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPelaaActionPerformed(evt);
            }
        });

        jNostaKortti.setText("Nosta Kortti");
        jNostaKortti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNostaKorttiActionPerformed(evt);
            }
        });

        jLopetaVuoro.setText("Lopeta Vuoro");
        jLopetaVuoro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLopetaVuoroActionPerformed(evt);
            }
        });

        jLuovuta.setText("Luovuta?");
        jLuovuta.setInheritsPopupMenu(true);
        jLuovuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLuovutaActionPerformed(evt);
            }
        });

        jLuovutaPeruuta.setText("Peruuta");
        jLuovutaPeruuta.setVisible(false);
        jLuovutaPeruuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLuovutaPeruutaActionPerformed(evt);
            }
        });

        jLuovutaOK.setText("Luovuta");
        jLuovutaOK.setVisible(false);
        jLuovutaOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLuovutaOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPelaa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jNostaKortti, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLopetaVuoro, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLuovutaOK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLuovutaPeruuta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLuovuta)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPelaa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jNostaKortti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLuovutaPeruuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLuovutaOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLuovuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLopetaVuoro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        jNostitJoKolme.setText("Nostit jo 3 korttia tällä vuorolla, et voi nostaa lisää kortteja.");
        jNostitJoKolme.setVisible(false);

        jEtOleNostanut3.setText("Et ole vielä nostanut kolmea korttia tällä vuorolla.");
        jEtOleNostanut3.setVisible(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jVastustaja1Kortit.setText(getEkaPelaaja());

        jVastustaja2kortit.setText(getTokaPelaaja());

        jVastustaja3kortit.setText(getKolmasPelaaja());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jVastustaja1Kortit)
                .addGap(162, 162, 162)
                .addComponent(jVastustaja2kortit)
                .addGap(162, 162, 162)
                .addComponent(jVastustaja3kortit)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jVastustaja1Kortit, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jVastustaja2kortit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jVastustaja3kortit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Omat Kortit"));

        jOmatKortit.setFixedCellHeight(30);
        jOmatKortit.setFixedCellWidth(80);
        jOmatKortit.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jOmatKortit.setVisibleRowCount(3);
        naytaOmatKortit();
        jScrollPane1.setViewportView(jOmatKortit);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Päällimäinen kortti:");

        jKortti.setText(getPaallimmainen());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jKortti)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jKortti))
                .addContainerGap())
        );

        jKortitLoppuPoydastaJaPakasta.setText("Pakka ja pelatut kortit ovat loppu, pelaa kortteja, lopeta vuoro tai luovuta.");
        jKortitLoppuPoydastaJaPakasta.setVisible(false);

        jEiValittujaKortteja.setText("Valitse yhdestä kolmeen korttia.");
        jEiValittujaKortteja.setVisible(false);

        jVaaraSumma.setText("Valitsemiesi korttien summa ei ole sama kuin päällimmäisen kortin arvo.");
        jVaaraSumma.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNostitJoKolme)
                            .addComponent(jEtOleNostanut3)
                            .addComponent(jKortitLoppuPoydastaJaPakasta)
                            .addComponent(jEiValittujaKortteja)
                            .addComponent(jVaaraSumma))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jVaaraSumma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jEiValittujaKortteja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jKortitLoppuPoydastaJaPakasta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jEtOleNostanut3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNostitJoKolme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLuovutaOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLuovutaOKActionPerformed
        jEiValittujaKortteja.setVisible(false);
        jVaaraSumma.setVisible(false);
        MuuLogiikka.getVuoro().getPoyta().poistaPelaaja(MuuLogiikka.getVuoro()
            .getPoyta().getTamanVuoronPelaaja());
        if (MuuLogiikka.getVuoro().getPoyta().getPelaajat().size() == 1) {
            MuuLogiikka.getVuoro().getPoyta().setTamanVuoronPelaaja();
            this.setVisible(false);
            MuuLogiikka.voitto();
            MuuLogiikka.nollaaPeli();
        } else {
            this.setVisible(false);
            for (Kortti kortti : MuuLogiikka.getVuoro().getPoyta().getTamanVuoronPelaaja().getKadessaOlevatKortit()) {
                MuuLogiikka.getVuoro().getPoyta().laitaPoydallaOleviinKortteihin(kortti);
            }
            MuuLogiikka.getVuoro().jalkivalmistelut();
            MuuLogiikka.getVuoro().vuoro();

        }
    }//GEN-LAST:event_jLuovutaOKActionPerformed

    private void jLuovutaPeruutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLuovutaPeruutaActionPerformed
        jLuovuta.setVisible(true);
        jLuovutaOK.setVisible(false);
        jLuovutaPeruuta.setVisible(false);
    }//GEN-LAST:event_jLuovutaPeruutaActionPerformed

    private void jLuovutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLuovutaActionPerformed
        jLuovuta.setVisible(false);
        jLuovutaOK.setVisible(true);
        jLuovutaPeruuta.setVisible(true);
    }//GEN-LAST:event_jLuovutaActionPerformed

    private void jLopetaVuoroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLopetaVuoroActionPerformed
        jEiValittujaKortteja.setVisible(false);
        jVaaraSumma.setVisible(false);
        if (voikoLopettaa == 0) {
            lopetaVuoro();
        } else {
            etOleNostanutKolmea();
        }
    }//GEN-LAST:event_jLopetaVuoroActionPerformed

    private void jNostaKorttiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNostaKorttiActionPerformed
        jEiValittujaKortteja.setVisible(false);
        jVaaraSumma.setVisible(false);
        if (MuuLogiikka.getVuoro().getPoyta().getPakka().montaPakassa() < 1
            && MuuLogiikka.getVuoro().getPoyta().getPoydallaOlevatKortit().size() < 1) {
            pakkaJaPoytaLoppu();
        } else {
            if (MuuLogiikka.getVuoro().nostaKortti()) {
                joKolmeNostettu();
                jEtOleNostanut3.setVisible(false);
            }
            naytaOmatKortit();
            if (voikoLopettaa > 0) {
                voikoLopettaa--;
            }
        }
    }//GEN-LAST:event_jNostaKorttiActionPerformed

    private void jPelaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPelaaActionPerformed
        if (jOmatKortit.getSelectedValuesList().isEmpty() || jOmatKortit.getSelectedValuesList().size() > 3) {
            jEiValittujaKortteja.setVisible(true);
        } else {
            jEiValittujaKortteja.setVisible(false);

            tekstiKorteiksi();
            if (pelattavatKortit.size() > 1) {
                if (MuuLogiikka.getVuoro().voikoKortitPelata(pelattavatKortit)) {
                    MuuLogiikka.getVuoro().setPaallimaisenaPelattavat(pelattavatKortit);
                    this.setVisible(false);
                    MikaKorteistaPaallimaiseksiRuutu mkpr = new MikaKorteistaPaallimaiseksiRuutu(this, pelattavatKortit);
                } else {
                    jVaaraSumma.setVisible(true);
                }
            } else if (MuuLogiikka.getVuoro().voikoKortitPelata(pelattavatKortit)) {
                MuuLogiikka.getVuoro().setPaallimmaisenaPelattava(pelattavatKortit.get(0));
                MuuLogiikka.getVuoro().pelaa(pelattavatKortit);
                lopetaVuoro();
            } else {
                jVaaraSumma.setVisible(true);
            }
        }
    }//GEN-LAST:event_jPelaaActionPerformed

    private void tekstiKorteiksi() throws NumberFormatException {
        pelattavatKortit = new ArrayList();
        List<String> pelattavatKortitTekstina = jOmatKortit.getSelectedValuesList();
        for (String kortti : pelattavatKortitTekstina) {
            String[] maaJaArvo = kortti.split(" ");
            pelattavatKortit.add(new Kortti(maaJaArvo[0], Integer.parseInt(maaJaArvo[1])));
        }
    }

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jEiValittujaKortteja;
    private javax.swing.JLabel jEtOleNostanut3;
    private javax.swing.JLabel jKortitLoppuPoydastaJaPakasta;
    private javax.swing.JLabel jKortti;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jLopetaVuoro;
    private javax.swing.JButton jLuovuta;
    private javax.swing.JButton jLuovutaOK;
    private javax.swing.JButton jLuovutaPeruuta;
    private javax.swing.JButton jNostaKortti;
    private javax.swing.JLabel jNostitJoKolme;
    private javax.swing.JList<String> jOmatKortit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jPelaa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel jVaaraSumma;
    private javax.swing.JLabel jVastustaja1Kortit;
    private javax.swing.JLabel jVastustaja2kortit;
    private javax.swing.JLabel jVastustaja3kortit;
    // End of variables declaration//GEN-END:variables
}
