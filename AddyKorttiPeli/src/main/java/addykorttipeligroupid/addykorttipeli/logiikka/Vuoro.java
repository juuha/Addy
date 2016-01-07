package addykorttipeligroupid.addykorttipeli.logiikka;

import addykorttipeligroupid.addykorttipeli.Kortti;
import addykorttipeligroupid.addykorttipeli.Poyta;
import addykorttipeligroupid.addykorttipeli.graafinenkayttoliittyma.AloitaVuoroRuutu;
import java.util.ArrayList;

/**
 *
 * Tämä luokka sisältää kaiken mitä tapahtuu pelivuorojenaikana.
 */
public class Vuoro {

    private Poyta poyta;
    private int voitto = 0;
    private ArrayList<Kortti> paallimaisenaPelattavat;
    private Kortti paallimmaisenaPelattava;

    

    

    /**
     *
     * @param poyta
     */
    public Vuoro(Poyta poyta) {
        this.poyta = poyta;

    }

    /**
     * Jakaa kortit ja antaa ensimmäisen vuoron ensimmäiselle pelaajalle.
     */
    public void aloitaPeli() {
        poyta.setVuoroAlussa();
        poyta.getPakka().jaaKortit(poyta);
    }

    /**
     * vanha Kysyy pelaajalta mitä tehdään (pelaa/nosta/lopeta vuoro/tilanne) ja
     * kutsuu metodeja siitä riippuen mitä käskettiin tehdä. Lopuksi tarkistaa
     * onko peli päättynyt.
     *
     * @return palauttaa tiedon voitosta
     */
//      
//    public int vuoro() {
//        valmistelut();
//        while (true) {
//            System.out.println("Pöydän päällimmäinen kortti on: " + poyta.getPaallimmainen());
//            System.out.println(poyta.getTamanVuoronPelaaja().kadessaOlevatKortit());
//            System.out.println("Mitä tehdään? (pelaa/nosta/lopeta vuoro/tilanne).");
//            String komento = lukija.nextLine();
//            if (komento.equals("nosta")) {
//                nostaKortti();
//            } else if (komento.equals("lopeta vuoro")) {
//                if (lopetavuoro()) {
//                    break;
//                }
//            } else if (komento.equals("pelaa")) {
//                if (pelaa()) {
//                    break;
//                }
//            } else if (komento.equals("tilanne")) {
//                tilanne();
//            } else {
//                System.out.println("\nVirheellinen syöte. Anna jokin seuraavista"
//                        + " komennoista (pelaa/nosta/lopeta vuoro/tilanne). ");
//            }
//        }
//        jalkivalmistelut();
//
//        return voitto;
//    }
    /**
     *
     * @return
     */
    public void vuoro() {
        valmistelut();
        AloitaVuoroRuutu.main(null);
    }

    public void jalkivalmistelut() {
        if (poyta.getTamanVuoronPelaaja().montaKorttiaKadessa() == 0) {
            voitto = 1;
            return;
        }

        if (poyta.onkoEkaVuoro() == false) {
            poyta.ekaVuoroOhi();
        }

        poyta.setTamanVuoronPelaaja();
    }

    public void valmistelut() {
        voitto = 0;
        poyta.getTamanVuoronPelaaja().nollaaKorttienNostot();
        if (poyta.onkoEkaVuoro()) {
            poyta.setPaallimmainen(poyta.getPakka().otaEka());
            poyta.laitaPoydallaOleviinKortteihin(poyta.getPaallimmainen());
        }
    }

//      vanha
//    private boolean pelaaa() {
//        while (true) {
//            System.out.println("Valitse kortteja muodossa \"hertta 2, hertta 3\""
//                    + " tai palaa komennolla \"palaa\".");
//            String komento = "hertta 12";
//            if (komento.equals("palaa")) {
//                return false;
//            } else {
//                ArrayList<Kortti> pelattavatKortit = new ArrayList();
//                if (pelattavatKortit != null) {
//                    if (voikoKortitPelata(pelattavatKortit)) {
//                        poyta.setPaallimmainen(pelattavatKortit.get(0));
//                        for (Kortti kortti : pelattavatKortit) {
//                            poyta.getTamanVuoronPelaaja().otaKorttiKadesta(kortti.getMaa(), kortti.getArvo());
//                            poyta.laitaPoydallaOleviinKortteihin(kortti);
//                        }
//                        break;
//                    }
//                }
//            }
//        }
//        return true;
//    }

    public void pelaa(ArrayList<Kortti> kortit) {
        poyta.setPaallimmainen(paallimmaisenaPelattava);
        for (Kortti kortti : kortit) {
            poyta.getTamanVuoronPelaaja().otaKorttiKadesta(kortti.getMaa(), kortti.getArvo());
            poyta.laitaPoydallaOleviinKortteihin(kortti);
        }
    }

//        vanha
//    private void nostaKortti() {
//        if (poyta.getTamanVuoronPelaaja().getTallaVuorollaNostettu() >= 3) {
//            System.out.println("\nNostit jo 3 korttia tällä vuorolla.");
//        } else {
//            if (poyta.getPakka().montaPakassa() < 2) {
//                poyta.getPakka().sekoitaPakkaan(poyta.getPoydallaOlevatKortit());
//            }
//            Kortti apuKortti = poyta.getPakka().otaEka();
//            poyta.getTamanVuoronPelaaja().nostaKortti(apuKortti);
//            System.out.println("");
//        }
//    }
    public boolean nostaKortti() {
        if (poyta.getTamanVuoronPelaaja().getTallaVuorollaNostettu() >= 3) {
            return true;
        } else {
            if (poyta.getPakka().montaPakassa() < 1) {
                if (poyta.getPoydallaOlevatKortit().size() > 0) {
                    poyta.getPakka().sekoitaPakkaan(poyta.getPoydallaOlevatKortit());
                    poyta.tyhjennaPoyta();
                }
            }
            Kortti apuKortti = poyta.getPakka().otaEka();
            poyta.getTamanVuoronPelaaja().nostaKortti(apuKortti);
        }
        return false;
    }

    public boolean voikoKortitPelata(ArrayList<Kortti> pelattavatKortit) {
        int summa = 0;
        for (Kortti kortti : pelattavatKortit) {
            summa += kortti.getArvo();
        }
        while (summa > 9) {
            summa -= 10;
        }
        return poyta.getPaallimmainen().getNumeroArvo() == summa;
    }

    public Poyta getPoyta() {
        return poyta;
    }

    public int getVoitto() {
        return voitto;
    }
    
    public ArrayList<Kortti> getPaallimaisenaPelattavat() {
        return paallimaisenaPelattavat;
    }

    public void setPaallimaisenaPelattavat(ArrayList<Kortti> paallimaisenaPelattavat) {
        this.paallimaisenaPelattavat = paallimaisenaPelattavat;
    }
    
    public Kortti getPaallimmaisenaPelattava() {
        return paallimmaisenaPelattava;
    }

    public void setPaallimmaisenaPelattava(Kortti paallimmaisenaPelattava) {
        this.paallimmaisenaPelattava = paallimmaisenaPelattava;
    }

}
