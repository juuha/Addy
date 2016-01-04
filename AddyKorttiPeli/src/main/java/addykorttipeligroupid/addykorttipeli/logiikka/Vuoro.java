package addykorttipeligroupid.addykorttipeli.logiikka;

import addykorttipeligroupid.addykorttipeli.Kortti;
import addykorttipeligroupid.addykorttipeli.Pelaaja;
import addykorttipeligroupid.addykorttipeli.Poyta;
import graafinenkayttoliittyma.AloitaVuoroRuutu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * Tämä luokka sisältää kaiken mitä tapahtuu pelivuorojenaikana.
 */
public class Vuoro {

    private Poyta poyta;
    private Scanner lukija;
    private int voitto = 0;

    /**
     *
     * @param lukija
     * @param poyta
     */
    public Vuoro(Scanner lukija, Poyta poyta) {
        this.poyta = poyta;
        this.lukija = lukija;
    }

    /**
     *   Jakaa kortit ja antaa ensimmäisen vuoron ensimmäiselle pelaajalle.
     */
    public void aloitaPeli() {
        poyta.setVuoroAlussa();
        poyta.getPakka().jaaKortit(poyta);
    }

    /**
     *
     * Kysyy pelaajalta mitä tehdään (pelaa/nosta/lopeta vuoro/tilanne) ja kutsuu
     * metodeja siitä riippuen mitä käskettiin tehdä. Lopuksi tarkistaa onko peli
     * päättynyt.
     * 
     * @return palauttaa tiedon voitosta
     */
    public int vuoro() {
        valmistelut();
        while (true) {
            System.out.println("Pöydän päällimmäinen kortti on: " + poyta.getPaallimmainen());
            System.out.println(poyta.getTamanVuoronPelaaja().kadessaOlevatKortit());
            System.out.println("Mitä tehdään? (pelaa/nosta/lopeta vuoro/tilanne).");
            String komento = lukija.nextLine();
            if (komento.equals("nosta")) {
                nostaKortti();
            } else if (komento.equals("lopeta vuoro")) {
                if (lopetavuoro()) {
                    break;
                }
            } else if (komento.equals("pelaa")) {
                if (pelaa()) {
                    break;
                }
            } else if (komento.equals("tilanne")) {
                tilanne();
            } else {
                System.out.println("\nVirheellinen syöte. Anna jokin seuraavista"
                        + " komennoista (pelaa/nosta/lopeta vuoro/tilanne). ");
            }
        }
        jalkivalmistelut();

        return voitto;
    }
    
    /**
     *
     * @return
     */
    public void vuoroGUI() {
        valmistelutGUI();
        
        
    }

    private void jalkivalmistelut() {
        if (poyta.getTamanVuoronPelaaja().montaKorttiaKadessa() == 0) {
            voitto = 1;
            return;
        }

        if (poyta.onkoEkaVuoro() == false) {
            poyta.ekaVuoroOhi();
        }

        poyta.setTamanVuoronPelaaja();
    }

    private void valmistelut() {
        voitto = 0;
        poyta.getTamanVuoronPelaaja().nollaaKorttienNostot();
        if (poyta.onkoEkaVuoro()) {
            System.out.println(poyta.getViimeVuorollaPelattu());
        }
        System.out.println("Paina palautusnäppäintä (enteriä) aloittaaksesi pelaaja "
                + poyta.getTamanVuoronPelaaja().getNimi() + ":n vuoro.");
        lukija.nextLine();

    }
    
    private void valmistelutGUI() {
        voitto = 0;
        poyta.getTamanVuoronPelaaja().nollaaKorttienNostot();
        AloitaVuoroRuutu.main(null);
    }

    private boolean pelaa() {
        while (true) {
            System.out.println("Valitse kortteja muodossa \"hertta 2, hertta 3\""
                    + " tai palaa komennolla \"palaa\".");
            String komento = lukija.nextLine();
            if (komento.equals("palaa")) {
                return false;
            } else {
                ArrayList<Kortti> pelattavatKortit = valitseKortit(komento);
                if (pelattavatKortit != null) {
                    if (voikoKortitPelata(pelattavatKortit)) {
                        poyta.setPaallimmainen(pelattavatKortit.get(0));
                        for (Kortti kortti : pelattavatKortit) {
                            poyta.getTamanVuoronPelaaja().otaKorttiKadesta(kortti.getMaa(), kortti.getArvo());
                            poyta.laitaPoydallaOleviinKortteihin(kortti);
                        }
                        break;
                    }
                }
            }
        }
        return true;
    }

    private ArrayList<Kortti> valitseKortit(String komento) {
        ArrayList<Kortti> pelattavatKortit = new ArrayList();
        String[] kortit = komento.split(", ");

        for (String annettuKortti : kortit) {
            String[] maaJaArvo = annettuKortti.split(" ");
            try {
                Kortti apuKortti = new Kortti(maaJaArvo[0],
                        Integer.parseInt(maaJaArvo[1]));
                if (poyta.getTamanVuoronPelaaja().getKorttiArvolta(
                        apuKortti.getMaa(), apuKortti.getArvo()) != null) {
                    pelattavatKortit.add(apuKortti);
                }
            } catch (Exception e) {
                System.out.println("\nVirheellinen syöte.");
                return null;
            }
        }
        if (olikoLaillinenSiirto(pelattavatKortit)) {
            return null;
        }

        return pelattavatKortit;
    }

    private boolean olikoLaillinenSiirto(ArrayList<Kortti> pelattavatKortit) {
        if (pelattavatKortit.size() > 3) {
            System.out.println("Pelasit liikaa kortteja.");
            return true;
        }

        Set<Kortti> set = new HashSet<Kortti>(pelattavatKortit);
        if (set.size() < pelattavatKortit.size()) {
            System.out.println("Et voi pelata samaa korttia monta kertaa");
            return true;
        }

        return false;
    }

    private void nostaKortti() {
        if (poyta.getTamanVuoronPelaaja().getTallaVuorollaNostettu() >= 3) {
            System.out.println("\nNostit jo 3 korttia tällä vuorolla.");
        } else {
            if (poyta.getPakka().montaPakassa() < 2) {
                poyta.getPakka().sekoitaPakkaan(poyta.getPoydallaOlevatKortit());
            }
            Kortti apuKortti = poyta.getPakka().otaEka();
            poyta.getTamanVuoronPelaaja().nostaKortti(apuKortti);
            System.out.println("");
        }
    }

    private boolean lopetavuoro() {
        if (poyta.getTamanVuoronPelaaja().getTallaVuorollaNostettu() == 3) {
            return true;
        } else {
            System.out.println("\nEt ole nostanut kolmea kertaa tällä vuorolla.");
            return false;
        }
    }

    private boolean voikoKortitPelata(ArrayList<Kortti> pelattavatKortit) {
        int summa = 0;
        for (Kortti kortti : pelattavatKortit) {
            summa += kortti.getArvo();
        }
        while (summa > 9) {
            summa -= 10;
        }
        System.out.println("summa: " + summa);
        return poyta.getPaallimmainen().getNumeroArvo() == summa;
    }

    private void tilanne() {
        System.out.println("");
        for (Pelaaja pelaaja : poyta.getPelaajat()) {
            System.out.println("Pelaaja " + pelaaja.getNimi() + ": "
                    + pelaaja.montaKorttiaKadessa() + " korttia kädessä.");
        }
    }
    
    public Poyta getPoyta(){
        return poyta;
    }

    
}
