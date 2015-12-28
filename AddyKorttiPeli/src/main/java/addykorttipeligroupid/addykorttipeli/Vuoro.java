package addykorttipeligroupid.addykorttipeli;

import java.util.Scanner;

public class Vuoro {

    private Poyta poyta;
    private Scanner lukija;
    private int voitto = 0;

    public Vuoro(Scanner lukija, Poyta poyta) {
        this.poyta = poyta;
        this.lukija = lukija;
    }

    void aloitaPeli() {
        poyta.setVuoroAlussa();
        poyta.getPakka().jaaKortit(poyta);
    }

    public int vuoro() {
        valmistelut();
        while (true) {
            System.out.println("Pöydän päällimmäinen kortti on: " + poyta.getPaallimmainen());
            System.out.println(poyta.getTamanVuoronPelaaja().kadessaOlevatKortit());
            System.out.println("Mitä tehdään? (pelaa/nosta/lopeta vuoro).");
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
            } else {
                System.out.println("\nVirheellinen syöte.");
            }
        }
        jalkivalmistelut();

        return voitto;
    }

    private void jalkivalmistelut() {
        if (poyta.getTamanVuoronPelaaja().montaKorttiaKadessa() == 0) {
            voitto = 1;
        }

        if (poyta.onkoEkaVuoroOhi() == false) {
            poyta.ekaVuoroOhi();
        }

        poyta.setTamanVuoronPelaaja();
    }

    private void valmistelut() {
        voitto = 0;
        poyta.getTamanVuoronPelaaja().nollaaKorttienNostot();
        boolean apu = poyta.onkoEkaVuoroOhi();
        if (apu = true) {
            System.out.println(poyta.getViimeVuorollaPelattu());
        }
        System.out.println("Paina palautusnäppäintä (enteriä) aloittaaksesi pelaaja "
                + poyta.getTamanVuoronPelaaja().getNimi() + ":n vuoro.");
        lukija.nextLine();

    }

    private boolean pelaa() {
        while (true) {
            System.out.println("Mitä tehdään? (valitse kortteja/palaa)");
            String komento = lukija.nextLine();
            if (komento.equals("palaa")) {
                return false;
            } else if (komento.equals("valitse kortteja")) {
                //ei valmis
                return true;
            } else {
                System.out.println("Virheellinen syöte.");
            }
        }

    }

    private void nostaKortti() {
        if (poyta.getTamanVuoronPelaaja().getTallaVuorollaNostettu() >= 3) {
            System.out.println("\nNostit jo 3 korttia tällä vuorolla.");
        } else {
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

}
